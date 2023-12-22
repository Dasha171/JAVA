import java.util.Vector;
//создание потока на уровне кода
class WriteThread extends Thread {
    private Vector<Double> vector;

    public WriteThread(Vector<Double> vector) {
        this.vector = vector;
    }
    //при помещении значения в вектор, выводится сообщение
    @Override
    public void run() {
        for (int i = 0; i < vector.size(); i++) {
            double value = Math.random() * 100;
            if (value != 0) {
                vector.set(i, value);
                System.out.println("Write: " + value + " to position " + i);
            }
        }
    }
}

class ReadThread extends Thread {
    private Vector<Double> vector;

    public ReadThread(Vector<Double> vector) {
        this.vector = vector;
    }
   //считывание значения из вектора
    @Override
    public void run() {
        for (int i = 0; i < vector.size(); i++) {
            double value = vector.get(i);
            System.out.println("Read: " + value + " from position " + i);
        }
    }
}

 class Main {
    public static void main(String[] args) {
        //динамический массив
        Vector<Double> vector = new Vector<>(3);
        //изначально по заданию задать нули
        for (int i = 0; i < 10; i++) {
            vector.add(0.0);
        }
        //создала 2 новых веткора
        WriteThread writeThread = new WriteThread(vector);
        ReadThread readThread = new ReadThread(vector);
        //максимальный приоритет потока
        writeThread.setPriority(Thread.MAX_PRIORITY);
        //минимальный приоритет потока
        readThread.setPriority(Thread.MIN_PRIORITY);

        writeThread.start();
        readThread.start();
    }
}

