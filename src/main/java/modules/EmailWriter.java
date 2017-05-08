package modules;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailWriter {
    public static void writeTo(String destinationEmail, String subject, String message) {
        try {
            Email email = new SimpleEmail();
            email.setHostName("127.0.0.1");
            email.setSmtpPort(25);
            email.setFrom("dorin@mail.md");
            email.setSubject(subject);
            email.setMsg(message);
            email.addTo(destinationEmail);
            email.send();
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
    }
}
