package server;

import java.io.*;
import java.net.*;
import client.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String username;
    private String currentRoom;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Request username
            out.println("Enter your username: ");
            username = in.readLine();
            System.out.println(username + " joined the chat.");

            // Handle user commands
            String message;
            while ((message = in.readLine()) != null) {
                if (message.startsWith("/join ")) {
                    String room = message.substring(6);
                    if (currentRoom != null) {
                        ChatServer.removeClient(this, currentRoom);
                    }
                    currentRoom = room;
                    ChatServer.addClientToRoom(this, room);
                } else if (message.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    ChatServer.broadcastMessage(username + ": " + message, this, currentRoom);
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public String getUsername() {
        return username;
    }
}
