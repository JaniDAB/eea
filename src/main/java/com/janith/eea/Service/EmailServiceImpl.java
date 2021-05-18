package com.janith.eea.Service;

import com.janith.eea.Dto.UserDto;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class EmailServiceImpl {

    private final  String CollegeEmail = "timetable766@gmail.com";

    private JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail( final UserDto userInfo)
    {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {

                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(userInfo.getEmail()));
                mimeMessage.setSubject("Welcome to  Timetabling System 766");
                mimeMessage.setFrom(new InternetAddress(CollegeEmail));
                mimeMessage.setText(
                        "Dear " + userInfo.getFirstname()+ " "
                                + userInfo.getLastname()
                                + ",You Have Successfully Registered with Timetable System, Following  will be your User Name And Password "
                                +  "UserName "+ userInfo.getUsername()
                                +"   Password : user123");
                mimeMessage.setSentDate(new Date());
            }
        };
        try {
            this.javaMailSender.send(preparator);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}
