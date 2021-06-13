package com.notebook.pages.emailsender.exception;

import com.notebook.pages.emailsender.entity.Sender;

import java.io.File;

public class EmailValidator{

    public static Boolean isFileValid(File file) throws NotValidException{
        if(file == null){
            throw new NotValidException("File is required");
        }
        if(file.length() == 0){
            throw new NotValidException("File is empty");
        }
        return true;
    }

    public static Boolean isSenderValid(Sender sender) throws NotValidException{
        if(sender == null){
            throw new NotValidException("Sender is null ");
        }
        if(sender.getFirstName() == null || sender.getFirstName().trim().equals("")){
            throw new NotValidException("Sender's first name required");
        }
        if(sender.getLastName() == null || sender.getLastName().trim().equals("")){
            throw new NotValidException("Sender's last name required");
        }
        if(sender.getEmail() == null || sender.getEmail().trim().equals("")){
            throw new NotValidException("Sender's email address required");
        }
        if(sender.getPassword() == null || sender.getPassword().trim().equals("")){
            throw new NotValidException("Sender's password required");
        }
        return true;
    }
}
