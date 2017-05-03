import org.apache.commons.mail.*;

public class Main {

    public static void main( String[] args ) {

        System.out.println("Client simplu de posta – trimitere mesaj");
        try {
            Email email = new SimpleEmail();
            email.setHostName("192.168.55.163");
            email.setSmtpPort(2525);
            email.setFrom("dorin@domain1.com");
            email.setSubject("Subject2");
            email.setMsg("Message2");
            email.addTo("dr@domain.com");
            email.send();
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
    }
}