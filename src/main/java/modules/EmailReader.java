package modules;

import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class EmailReader {
    public void readFrom(int messageNr) {
        try {
            POP3Client client = new POP3Client();
            client.connect("127.0.0.1", 110);
            if (client.login("vasea", "07")) {
                POP3MessageInfo[] messages = client.listMessages();
                System.out.println("Mesaje: " + messages.length);
                System.out.println("Primul mesaj");

                Reader r = client.retrieveMessage(messages[messageNr].number);
                BufferedReader br = new BufferedReader(r);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } else {
                System.out.println("Logare fara succes...");
            }
//            client.logout();
//            client.disconnect();
        } catch (IOException ex) {
            System.out.println("Error on connection");
        }
    }
}
