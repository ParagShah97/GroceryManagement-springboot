package com.practice.chhotabasket.response;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.*; 
import java.io.*;
import javax.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import javax.mail.MessagingException;

import org.springframework.mail.MailSender;  
import org.springframework.mail.SimpleMailMessage;  


@Component
public class EmailMessanger{

@Autowired
    private JavaMailSender emailSender;

public void sendSimpleMessage(String to,String subject, String text) {
        //String to="parag.shah97@gmail.com";
		//String subject="Mail about my project";
		//String text="Mail from java class created by me";
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("mr.codersGrocery@gmail.com");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);        
    }

public void sendMessageWithAttachment() {
        
try{
		String to="parag.shah97@gmail.com";
		String subject="Mail about my project";
		String text="Mail from java class created by me";
		String pathToAttachment="E:/PROGRAMMING/MeAndPratyush/documentation/groceryProject.png";
    
    MimeMessage message = emailSender.createMimeMessage();
     
    MimeMessageHelper helper = new MimeMessageHelper(message, true);
    
    helper.setFrom("mr.codersGrocery@gmail.com");
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(text);
        
    FileSystemResource file 
      = new FileSystemResource(new File(pathToAttachment));
    helper.addAttachment("Invoice.png", file);
 
    emailSender.send(message);
}catch(MessagingException me)
{
System.out.println("******* sendMessageWithAttachment "+me.getMessage());
}
    
}

}

