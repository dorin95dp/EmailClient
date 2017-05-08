package modules;

import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class EmailReader {

    private String userName;
    private String userPassword;

    public EmailReader (String userName, String password) {
        this.userName = userName;
        this.userPassword = password;
    }

    public void readMail(int messageNr) {
        try {
            POP3Client client = new POP3Client();
            client.connect("127.0.0.1", 110);
            if (client.login(userName, userPassword)) {
                POP3MessageInfo[] messages = client.listMessages();
                System.out.println("Total nr of messages: " + messages.length);
                System.out.println("Message" + messageNr);
                System.out.println("--------------------------------------------------");

                Reader r = client.retrieveMessage(messages[messageNr].number);
                BufferedReader br = new BufferedReader(r);
                String line;
                int i = 0;
                while ((line = br.readLine()) != null) {
                    i++;
                    if (i == 9 || i >= 13) {
                        System.out.println(line);
                    }
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

}
