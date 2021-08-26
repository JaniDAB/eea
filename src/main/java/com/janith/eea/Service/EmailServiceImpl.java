package com.janith.eea.Service;

import com.janith.eea.Dto.UserDto;
import com.janith.eea.Model.Timetable;
import com.janith.eea.Model.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage ,true);

                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(userInfo.getEmail()));
                helper.setSubject("Welcome to  Timetabling System 766");
                helper.setFrom(new InternetAddress(CollegeEmail));

                String mailContent = "<p><b>Dear </b>" + userInfo.getFirstname()+" "+userInfo.getLastname() +"</p>";
                mailContent+= "<p><b>You Have Successfully Registered with Timetable System,</b>"+"</p>";
                mailContent+="<p><b> Following  will be your User Name And Password ,</b>" +"</p>";
                mailContent+=  "<p><b> UserName: </b>"+ userInfo.getUsername() +"</p>";
                mailContent+= " <p><b> Password : user123 </b></p>";
                mailContent+= "<hr><img src='cid:logoImage' />";


                helper.setText(mailContent,true);
////                        helper.setText(
////                        "Dear " + userInfo.getFirstname()+ " "
////                                + userInfo.getLastname()
////                                + ",You Have Successfully Registered with Timetable System, Following  will be your User Name And Password "
////                                +  "UserName "+ userInfo.getUsername()
//                                +"   Password : user123");
                mimeMessage.setSentDate(new Date());
                ClassPathResource  resource = new ClassPathResource("static/images/cover.png");
                helper.addInline("logoImage" , resource);
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


    public void emailUserUpdate( final User userInfo)
    {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {

                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage ,true);

                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(userInfo.getEmail()));
                helper.setSubject("Updating your account Timetabling System 766 !");
                helper.setFrom(new InternetAddress(CollegeEmail));

                String mailContent = "<p><b>Dear </b>" + userInfo.getFirstname()+" "+userInfo.getLastname() +"</p>";
                mailContent+= "<p><b>You Have Successfully Updated Your account in  Timetable System,</b>"+"</p>";
                mailContent+= "<hr><img src='cid:logoImage' />";

                helper.setText(mailContent,true);
                mimeMessage.setSentDate(new Date());
                ClassPathResource  resource = new ClassPathResource("static/images/timetable.png");
                helper.addInline("logoImage" , resource);
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


    public void emaiPasswordReset( final User userInfo)
    {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {

                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage ,true);

                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(userInfo.getEmail()));
                helper.setSubject("Password Reset : Timetabling System 766 !");
                helper.setFrom(new InternetAddress(CollegeEmail));

                String mailContent = "<p><b>Dear </b>" + userInfo.getFirstname()+" "+userInfo.getLastname() +"</p>";
                mailContent+= "<p><b>You Have Successfully Updated Your account in  Timetable System,</b>"+"</p>";
                mailContent+=  "<p><b> Default password for  Username: </b>"+ userInfo.getUsername() +"</p>";
                mailContent+= " <p><b> Also Has been Changed </b></p>";
                mailContent+= "<hr><img src='cid:logoImage' />";


                helper.setText(mailContent,true);
                mimeMessage.setSentDate(new Date());
                ClassPathResource  resource = new ClassPathResource("static/images/timetable.png");
                helper.addInline("logoImage" , resource);
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

    public void RescheduleRequested( final Timetable timetable)
    {
 String AdminMail="janithdabare17@gmail.com";
        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {

                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage ,true);

                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(AdminMail));
                helper.setSubject("A Reschedule Has been Requested By Mrs./Mr "+timetable.getModule().getLecUser().getFirstname());
                helper.setFrom(new InternetAddress(CollegeEmail));

                String mailContent = "<p><b>Dear </b> Admin </p>";
                mailContent+= "<p><b>Lecturer : Mrs/Mr. "+ timetable.getModule().getLecUser().getFirstname()+"</b> Has Requested a Reschedule on</p>";
                mailContent+=  "<p><b> Timetable ID: </b>"+timetable.getTimetableID() +"</p>";
                mailContent+=  "<p><b> Module Code: </b>"+timetable.getModule().getModuleCode() +"</p>";
                mailContent+=  "<p><b> Scheduled On: </b>"+timetable.getDate()+" From :" +timetable.getStartTime()+" To :"+timetable.getEndTIme()+"</p>";
                mailContent+=  "<p><b> Please Kindly Look on to it </b></p>";
                mailContent+=  "<p><b> Thank you</b></p>";
                mailContent+= "<hr><img src='cid:logoImage' />";

                helper.setText(mailContent,true);
                mimeMessage.setSentDate(new Date());
                ClassPathResource  resource = new ClassPathResource("static/images/timetable.png");
                helper.addInline("logoImage" , resource);
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
