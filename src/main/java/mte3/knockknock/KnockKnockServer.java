// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 2
// Filename: KnockKnockServer.java (inside knockknock package)

package mte3.knockknock;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class KnockKnockServer {
    public static final int port = 54322;

    public static void receiveAndSend(Scanner scanner,String message,PrintWriter writer,boolean concat) {
        
        if (scanner == null || writer == null) return;
        String clientLine = null;
        if (scanner.hasNextLine()) {
            clientLine = scanner.nextLine();
        }
        String out = message;
        if (concat && clientLine != null) {
            out = out + clientLine;
        }
        writer.println(out);
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("KnockKnockServer started on port " + port + " at " + InetAddress.getLocalHost());
            while (!server.isClosed()) {
                try (Socket client = server.accept();
                     Scanner sc = new Scanner(client.getInputStream());
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true)) {
                    writer.println("Welcome to KnockKnockServer. Send a line:");
                    receiveAndSend(sc, "Server received: ", writer, true);
                } catch (IOException e) {
                    System.out.println("Client connection error: " + e.getMessage());
                }
            }
        }
    }
}