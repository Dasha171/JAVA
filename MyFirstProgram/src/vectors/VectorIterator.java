package vectors;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class VectorIterator implements Iterator<Double> {
    private Vector vector;
    private int currentIndex;

    public VectorIterator(Vector vector) {
        this.vector = vector;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < vector.getRazm();
    }

    @Override
    public Double next() {
        if (!hasNext()) {
            System.out.println("Повторите попытку");
        }
        double value = vector.getNum(currentIndex);
        currentIndex++;
        return value;
    }
    @Override
    public void remove() {
        System.out.println("Повторите попытку");
    }
}
