import modules.EmailReader;
import modules.EmailWriter;

public class Main {

    public static void main( String[] args ) {
        boolean reading = true;
        boolean writing = !reading;

        if (reading) {
            System.out.println("Reading message...");

            EmailReader emailReader = new EmailReader();
            emailReader.readFrom(0);
        }

        if (writing) {
            System.out.println("Client for sending message");

            EmailWriter emailWriter = new EmailWriter();
            emailWriter.writeTo("vasea@mail.md",
                                "subject careva",
                                "Inca un mesaj pentru Vasea");

        }

    }
}