import java.util.Vector;

//создание последовательности операций чтения-записи
class RunVector {
    private boolean writeSec = true;
//контроль доступа к общим ресурсам в многопоточной среде
    public synchronized void write() {
        try {
            while (!writeSec) {
                wait();
            }
            writeSec = false;
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();//завершение и прерывание потока
        }
    }

    public synchronized void read() {
        try {
            while (writeSec) {
                wait();
            }
            writeSec = true;
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
//создание задачи, которую выполняет поток,т.е код
class SequentalWriter implements Runnable {
    private RunVector RunVector;
    private Vector<Double> vector;

    public SequentalWriter(RunVector RunVector, Vector<Double> vector) {
        this.RunVector = RunVector;
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.size(); i++) {
            double value = Math.random() * 100;
            if (value != 0) {
                RunVector.write();
                vector.set(i, value);
                System.out.println("Write: " + value + " to position " + i);
            }
        }
    }
}
 class SequentalReader implements Runnable {
    private RunVector RunVector;
    private Vector<Double> vector;

    public SequentalReader(RunVector RunVector, Vector<Double> vector) {
        this.RunVector = RunVector;
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.size(); i++) {
            RunVector.read();
            double value = vector.get(i);
            System.out.println("Read: " + value + " from position " + i);
        }
    }
}

class Reliz {
    public static void main(String[] args) {
        //инициализация нового конструктора вектора
        Vector<Double> vector = new Vector<>(3);
        for (int i = 0; i < 5; i++) {
            vector.add(0.0);
        }

        RunVector RunVector = new RunVector();
        SequentalWriter writer = new SequentalWriter(RunVector, vector);
        SequentalReader reader = new SequentalReader(RunVector, vector);

        Thread writeT = new Thread(writer);
        Thread readT = new Thread(reader);

        writeT.start();
        readT.start();
    }
}
