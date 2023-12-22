import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatKlient {

    private String username;
    private BufferedReader consoleInput;
    private BufferedReader in;
    private PrintWriter out;

    public ChatKlient(String username, String serverAddress, int serverPort) {
        this.username = username;

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            consoleInput = new BufferedReader(new InputStreamReader(System.in));

            new Thread(this::StartMessage).start();
            sendUsername();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendUsername() throws IOException {
        out.println(username);
    }

    private void StartMessage() {
        try {
            String message;
            while ((message = consoleInput.readLine()) != null) {
                out.println(message);
                System.out.println(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String username = "dasha";
        String serverAddress = "localhost";
        int serverPort = 12345;

        ChatKlient client = new ChatKlient(username, serverAddress, serverPort);
    }
}
