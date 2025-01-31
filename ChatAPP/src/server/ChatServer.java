package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static Map<String, Set<ClientHandler>> rooms = new HashMap<>();
    private static Set<ClientHandler> clients = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat Server started on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addClientToRoom(ClientHandler client, String room) {
        rooms.computeIfAbsent(room, k -> new HashSet<>()).add(client);
        ChatServer.broadcastMessage("User " + client.getUsername() + " has joined the room " + room, client, room);

    }

    public static void broadcastMessage(String message, ClientHandler sender, String room) {
        for (ClientHandler client : rooms.getOrDefault(room, new HashSet<>())) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    public static void removeClient(ClientHandler client, String room) {
        if (rooms.containsKey(room)) {
            rooms.get(room).remove(client);
            if (rooms.get(room).isEmpty()) {
                rooms.remove(room);
            }
        }
    }
}
