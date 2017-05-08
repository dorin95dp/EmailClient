import modules.EmailWriter;

import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main( String[] args ) {
        boolean reading = false;
        boolean writing = !reading;

        if (reading) {
            System.out.println("Reading message...");
            try {
                POP3Client client = new POP3Client();
                client.connect("127.0.0.1", 110);
                if (client.login("vasea", "07")) {
                    POP3MessageInfo[] messages = client.listMessages();
                    System.out.println("Mesaje: " + messages.length);
                    System.out.println("Primul mesaj");

                    Reader r = client.retrieveMessage(messages[1].number);
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
            }
        }

        if (writing) {
            System.out.println("Client for sending message");

            EmailWriter emailWriter = new EmailWriter();
            emailWriter.writeTo("vasea@mail.md", "Mesajul meu pentru Vasea");

        }

    }
}