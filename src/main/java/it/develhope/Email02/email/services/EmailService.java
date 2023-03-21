package it.develhope.Email02.email.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author Drumstyle92
 * Class used as part of a system to send automated emails
 */
@Service
public class EmailService {

    /**
     * Interface dependency interface provided by Spring framework which provides
     * methods to send email in Java via Simple Mail Transfer Protocol (SMTP).
     * This interface abstracts the complexity of sending email in Java by simplifying
     * the email sending process through the use of a well-designed API
     */
    @Autowired
    private JavaMailSender javaMailSender;


    /**
     * @param email Parameter that gets the email for the SimpleMailMessage object
     * @param title Parameter that gets the title for the SimpleMailMessage object
     * @param text  Parameter that takes the text for the SimpleMailMessage subject
     * @throws MessagingException the messaging exception
     * Method that uses the supplied parameters to create a new MIME message using
     * an instance of "JavaMailSender". The text of the email is inserted into a formatted
     * HTML string and inserted into the body of the message. The method also uses a
     * "MimeMessageHelper" instance to set the recipient, sender, and subject of the email.
     * Finally, the method is called "javaMailSender.send" to send the email
     */
    public void sendTo(String email, String title, String text) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "<h1>Hello World!</h1>" +
                "<h2>You have a new message: </h2>" +
                "<img src='https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png' alt='Alternative text' height='200'>" +
                "<h3>" + text + "</h3>";
        helper.setText(htmlMsg, true);
        helper.setTo(email);
        helper.setSubject(title);
        helper.setFrom("xxxxx@xxxxx");
        javaMailSender.send(mimeMessage);

    }

}
