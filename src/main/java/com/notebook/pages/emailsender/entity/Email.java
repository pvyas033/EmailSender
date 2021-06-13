package com.notebook.pages.emailsender.entity;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class Email{

    private Sender sender;

    @Override
    public String toString(){
        return "Email{"+
                "sender="+sender+
                ", receiver="+receiver+
                ", subject='"+subject+'\''+
                ", emailBody='"+emailBody+'\''+
                ", attachements="+attachements+
                '}';
    }

    private Receiver            receiver;
    private String              subject;
    private String              emailBody;
    private List<MultipartFile> attachements;

    public Email(Sender sender, Receiver receiver, String subject, String emailBody, List<MultipartFile> attachements){
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.emailBody = emailBody;
        this.attachements = attachements;
    }

    public List<MultipartFile> getAttachements(){
        return this.attachements;
    }

    public String getEmailBody(){
        return this.emailBody;
    }

    public String getSubject(){
        return this.subject;
    }

    public Sender getSender(){
        return this.sender;
    }

    public Receiver getReceiver(){
        return this.receiver;
    }
}
