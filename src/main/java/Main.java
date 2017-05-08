import org.apache.commons.mail.*;

public class Main {

    public static void main( String[] args ) {

        System.out.println("Client simplu de posta – trimitere mesaj");
        try {
            Email email = new SimpleEmail();
            email.setHostName("127.0.0.1");
            email.setSmtpPort(25);
            email.setFrom("dorin@mail.md");
            email.setSubject("Subject3");
            email.setMsg("Message 3 - bla bla bla");
            email.addTo("vasea@mail.md");
            email.send();
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
    }
}