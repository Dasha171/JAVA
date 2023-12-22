package vectors;
import java.io.ObjectInputStream;//считывание обьектов
import java.io.ObjectOutputStream;//для записи
import java.net.Socket;
import vectors.ArrayVector;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             //возможность записывать объекты в поток для их последующей передачи или сохранения
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {

            ArrayVector vector1 = new ArrayVector(5);
            vector1.vector[0] = 1;
            vector1.vector[1] = 2;
            vector1.vector[2] = 3;
            vector1.vector[3] = 4;
            vector1.vector[4] = 5;

            ArrayVector vector2 = new ArrayVector(5);
            vector2.vector[0] = 1;
            vector2.vector[1] = 2;
            vector2.vector[2] = 3;
            vector2.vector[3] = 4;
            vector2.vector[4] = 5;


            objectOutputStream.writeObject(vector1);
            objectOutputStream.writeObject(vector2);
            objectOutputStream.flush();

            double result = objectInputStream.readDouble();
            System.out.println("результат скалярного умножения: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
