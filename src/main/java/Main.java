import modules.EmailReader;
import modules.EmailWriter;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) throws IOException {
        printMenu();

    }

    private static void printMenu () {
        System.out.println("Menu");
        System.out.println("1. Write message");
        System.out.println("2. Read latest message");
        System.out.println("3. Read specific message");
        Scanner scanner = new Scanner(System.in);
        EmailReader emailReader = new EmailReader("vasea", "07");
        EmailWriter emailWriter = new EmailWriter();

        switch (scanner.nextInt()) {
            case 1:
                clearConsole();
                System.out.println("Destination email: ");
                String destinationEmail = scanner.next();

                System.out.println("Subject: ");
                String subject = scanner.nextLine();

                System.out.println("Message: ");
                String message = scanner.nextLine();

                emailWriter.writeTo(destinationEmail, subject, message);

                break;
            case 2:
                emailReader.readMail(0);

                break;
            case 3:
                clearConsole();
                System.out.println("Which message?");
                emailReader.readMail(scanner.nextInt());

                break;
            default:
                System.out.println("Default choice");
                break;
        }

        return;
    }

    public final static void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }
}
