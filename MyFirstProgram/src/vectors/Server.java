package vectors;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import vectors.ArrayVector;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("сервер запущен");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream())) {

                    ArrayVector vector1 = (ArrayVector) objectInputStream.readObject();
                    ArrayVector vector2 = (ArrayVector) objectInputStream.readObject();

                    double result = scalarProduct(vector1, vector2);

                    objectOutputStream.writeDouble(result);
                    objectOutputStream.flush();
                    System.out.println("результат отправлен: " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double scalarProduct(ArrayVector vector1, ArrayVector vector2) {
        if (vector1.getRazm() != vector2.getRazm()) {
            throw new IllegalArgumentException("длина векторов не совпадают.");
        }

        double product = 0;
        for (int i = 0; i < vector1.getRazm(); i++) {
            product += vector1.getNum(i) * vector2.getNum(i);
        }
        return product;
    }
}
