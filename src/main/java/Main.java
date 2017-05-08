import org.apache.commons.mail.*;

public class Main {

    public static void main( String[] args ) {

        System.out.println("Client simplu de posta – trimitere mesaj");
        try {
            POP3Client client = new POP3Client();
            client.connect("127.0.0.1",110);
            if (client.login("dorin","10")) {
                POP3MessageInfo[] messages = client.listMessages();
                System.out.println("Mesaje: " + messages.length);
                System.out.println("Primul mesaj");

                // verify to no messages
                if (messages.length == 0) {
                    System.out.println("No messages");
                }

                Reader r = client.retrieveMessage(messages[0].number);
                BufferedReader br = new BufferedReader(r);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } else {
                System.out.println("Logare fara succes...");
            }
            client.logout();
            client.disconnect();
        } catch (IOException ex) {
            System.out.println("Error on connection");
// =======
        //     Email email = new SimpleEmail();
        //     email.setHostName("127.0.0.1");
        //     email.setSmtpPort(25);
        //     email.setFrom("dorin@mail.md");
        //     email.setSubject("Subject3");
        //     email.setMsg("Message 3 - bla bla bla");
        //     email.addTo("vasea@mail.md");
        //     email.send();
        // } catch (EmailException e) {
        //     System.out.println(e.getMessage());
        }
    }
}