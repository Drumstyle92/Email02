package it.develhope.Email02.api.controllers;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import it.develhope.Email02.api.entities.NotificationDTO;
import it.develhope.Email02.students.entities.Student;
import it.develhope.Email02.students.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

/**
 * @author Drumstyle92
 * REST controller class for handling notifications
 */
@RestController
@RequestMapping("/notification")
public class NotificationController {

    /**
     * Dependency to be able to use methods for student list management
     */
    private final StudentService studentService;

    /**
     * @param studentService Parameter that takes the instance of StudentService
     * Constructor that injects the StudentService dependency
     */
    public NotificationController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * @param id              Parameter which takes the id of the student to whom the email will arrive
     * @param notificationDTO Parameter that the notification DTO takes
     * @return the response entity
     * Method that searches for the student in the list through the "StudentService"
     * service using the ID. If the student is not found, a BAD_REQUEST status is returned.
     * If the student is found, a "Mail" object is created using the SendGrid API to send the email.
     * The Mail subject is populated with the sender, recipient, subject, and content of the notification.
     * If the email is sent successfully, an OK status is returned.
     * Otherwise, an INTERNAL_SERVER_ERROR status is returned
     */
    @PostMapping("/{id}")
    public ResponseEntity<String> sendEmailToStudent(@PathVariable String id, @RequestBody NotificationDTO notificationDTO) {

        try {

            // Get the student by ID
            Student student = studentService.getStudentById(id);

            if (student == null) {

                // If student is not found, return BAD_REQUEST
                return ResponseEntity.badRequest().body("Student with ID " + id + " not found.");

            }

            // Set up the email client
            Email from = new Email("Dino@example.com");

            String subject = notificationDTO.getTitle();
            Email to = new Email(student.getEmail());
            Content content = new Content("text/plain", notificationDTO.getText());
            Mail mail = new Mail(from, subject, to, content);

            SendGrid sg = new SendGrid("<la tua chiave API SendGrid>");

            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            // If email was sent successfully, return OK
            if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {

                return ResponseEntity.ok("Email sent to " + student.getEmail());

            } else {

                // If there was an error sending the email, return INTERNAL_SERVER_ERROR
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("An error occurred while sending email to " + student.getEmail() + ".");

            }

        } catch (IOException ex) {

            // If there was an exception, return INTERNAL_SERVER_ERROR
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while sending email.");

        }

    }

}