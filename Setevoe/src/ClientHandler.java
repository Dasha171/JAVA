import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private ChatServer server;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket clientSocket, ChatServer server) {
        this.clientSocket = clientSocket;
        this.server = server;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return "Имя";
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    @Override
    public void run() {
        try {
            out.println("Введите имя:");
            String username = in.readLine();
            out.println("Вы в чате онлайн, " + username + "!");

            String input;
            while ((input = in.readLine()) != null) {
                if (input.equalsIgnoreCase("Выйти")) {
                    break;
                } else if (input.startsWith("/direct ")) {
                    // Формат: /direct username message
                    String[] parts = input.split(" ", 3);
                    if (parts.length == 3) {
                        server.sendDirectMessage(parts[2], parts[1], this);
                    } else {
                        out.println("Invalid /direct command. Usage: /direct username message");
                    }
                } else {
                    server.broadcastMessage(username + ": " + input, this);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            server.removeClient(this);
        }
    }
}
