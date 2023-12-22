import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    private List<ClientHandler> clients = new ArrayList<>();

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новый пользователь: " + clientSocket);

                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public void sendDirectMessage(String message, String recipientUsername, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(recipientUsername) || client == sender) {
                client.sendMessage("Сообщение " + sender.getUsername() + ": " + message);
                return;
            }
        }
        sender.sendMessage("Имя '" + recipientUsername + "' не онлайн.");
    }




    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.start(12345);
    }
}
