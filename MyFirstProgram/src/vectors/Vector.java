package vectors;
import java.util.Iterator;
public interface Vector extends Iterable<Double> {

    double getNum(int numb);
    double getNorm();

    int getRazm();

    void addElement(double numb2);

    void removeElement(int numb);

    @Override
    Iterator<Double> iterator();
}
