package com.notebook.pages.emailsender.controller;

import com.notebook.pages.emailsender.entity.Email;
import com.notebook.pages.emailsender.entity.Sender;
import com.notebook.pages.emailsender.exception.EmailValidator;
import com.notebook.pages.emailsender.exception.NotValidException;
import com.notebook.pages.emailsender.service.EmailMaker;
import com.notebook.pages.emailsender.service.GoogleEmailService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmailController{

    private File                file;
    private Sender              sender;
    private List<MultipartFile> attachements;

    @PostMapping("/sender")
    public ResponseEntity sendMails(@Valid @RequestBody Sender sender) throws NotValidException{
        EmailValidator.isSenderValid(sender);
        this.sender = sender;
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException, NotValidException{
        File convertFile = new File(file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        EmailValidator.isFileValid(convertFile);
        this.file = convertFile;
        return "File is upload successfully";
    }

    @GetMapping("/send")
    public ResponseEntity sendMail() throws NotValidException{
        if(this.sender == null){
            throw new NotValidException("sender required");
        }
        if(this.file == null){
            throw new NotValidException("file required");
        }
        List<Email> emails = EmailMaker.makeEmailFromExcelFile(file);

        /**************** this is for google email ****************************/
        GoogleEmailService googleEmailService = new GoogleEmailService(this.sender);
        googleEmailService.sendEmails(emails);
        this.sender = null;
        /**********************************************************************/
        this.file.delete();
        return ResponseEntity.ok().build();
    }
}
