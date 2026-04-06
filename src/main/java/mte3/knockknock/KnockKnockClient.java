// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 2
// Filename: KnockKnockClient.java (inside knockknock package)

package mte3.knockknock;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class KnockKnockClient {
    private static final int port = 54322;
    private static final String server = "localhost";
    public static String getServer() {
        return server;
    }

    public static int getPort() {
        return port;
    }
public static void sendAndReceive(PrintWriter writer, String message, Scanner scanner) {
    // send the message to the server
    writer.println(message);
    // print a single response line from the server if available
    if (scanner.hasNextLine()) {
        String response = scanner.nextLine();
        System.out.println(response);
    }
}

public static void joke(String who, String punchLine) throws IOException {
    try (Socket socket = new Socket(getServer(), getPort());
         PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
         Scanner scanner = new Scanner(socket.getInputStream())) {
        // read server greeting if present
        if (scanner.hasNextLine()) {
            String greeting = scanner.nextLine();
            System.out.println(greeting);
        }

        sendAndReceive(writer, "Knock! Knock!", scanner);
        sendAndReceive(writer, who, scanner);
        sendAndReceive(writer, punchLine, scanner);

        // finish conversation
        writer.println("bye");
    }
} // joke() method closed

    public static void main(String[] args) throws IOException {

        String[][] jokes = {{"Tank","You're welcome!"},
                            {"Nobel","Nobel...that's why I knocked!"},
                            {"Says","Says me!"},
                            {"Hawaii","I'm good. Hawaii you?"},
                            {"Lettuce","Lettuce in, it's cold out here!"},
                            {"Cow says","No, a cow says moooooo!"},
                            {"Otto","Otto know. I forgot."}
                        };
        int i = new Random().nextInt(jokes.length);
        joke(jokes[i][0],jokes[i][1]);

    } // main() method closed

    // hint: please run KnockKnockServer first and then run KnockKnockClient

} // KnockKnockClient { } class closed