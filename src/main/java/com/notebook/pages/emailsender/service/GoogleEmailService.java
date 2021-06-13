package com.notebook.pages.emailsender.service;

import com.notebook.pages.emailsender.entity.Sender;
import com.notebook.pages.emailsender.entity.Person;
import com.notebook.pages.emailsender.entity.Email;
import com.notebook.pages.emailsender.exception.NotValidException;
import org.springframework.web.multipart.MultipartFile;
import java.util.Properties;
import java.util.List;
import javax.mail.*;
import javax.mail.internet.*;

public class GoogleEmailService
{
  private Session session;
  public GoogleEmailService(Sender sender)throws NotValidException
  {
    this.session=null;
    establishConnection(sender);
    if(this.session==null)
    {
      throw new NotValidException("Email/Password is not correct ");
    }
  }
  private void establishConnection(Sender sender)
  {
       Properties props = new Properties();
       props.put("mail.smtp.host", "smtp.gmail.com");
       props.put("mail.smtp.socketFactory.port", "465");
       props.put("mail.smtp.socketFactory.class",
                 "javax.net.ssl.SSLSocketFactory");
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.port", "465");

       this.session = Session.getInstance(props,
        new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(sender.getEmail(),sender.getPassword());
        }
       });
  }
  public Boolean sendEmails(List<Email> emails)throws NotValidException
  {
    for(Email email:emails)
    {
    try {
          MimeMessage message = new MimeMessage(session);
          message.addRecipient(Message.RecipientType.TO,new InternetAddress(email.getReceiver().getEmail()));
          message.setSubject(email.getSubject());
          message.setText(email.getEmailBody());
          Transport.send(message);
         } catch (MessagingException e)
         {
           throw new NotValidException(e.toString());
         }
    }
    return true;
  }
}
