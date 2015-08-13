package com.epam.academy.exercises.executors_server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectionClient {

    private static final int SERVER_PORT = 8010;

    public static void main(String[] args) {
        String host = null;
        int port = 0;

        if (args.length < 2) {
            host = "127.0.0.1";
            port = SERVER_PORT;
        }

        try (Socket s = new Socket(host, port);
                OutputStream os = s.getOutputStream()) {
            // The Socket() call returns only when the connection
            // request from this client is accepted by the server.

            System.out.println("Connection established to server. Type characters and press <ENTER> to send");
            System.out.println("Type EXIT and press <RETURN> to exit");

            // Read data from the standard input and send it to the remote socket
            while (true) {
                byte[] inData = new byte[100];

                int readBytes = System.in.read(inData);

                // Create a substring of lenght "EXIT".length() from the input
                String inString = new String(inData, 0, "EXIT".length());

                if ("EXIT".equalsIgnoreCase(inString)) {
                    System.out.println("Quiting ...");
                    System.exit(0);
                }

                // Send only as many bytes as we read from console
                os.write(inData, 0, readBytes);
            }
        } catch (IOException e) {
            System.out.println("Failed to connect to remote host: " + e.getMessage());
        }
    }
}
