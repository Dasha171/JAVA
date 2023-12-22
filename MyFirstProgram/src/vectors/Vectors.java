package vectors;
import java.util.Iterator;
import vectors.VectorFactory;
public class Vectors {
    private static VectorFactory vectorFactory = new ArrayVector(6);

    public static void setVectorFactory(VectorFactory factory) {
        vectorFactory = factory;
    }
    public static Vector createInstance(VectorFactory factory) {
        vectorFactory = factory;
        return null;
    }
    public static ArrayVector scalarUmn(ArrayVector vector, double scalar) {
        ArrayVector result = new ArrayVector(vector.getRazm());
        for (int i = 0; i < vector.getRazm(); i++) {
            result.vector[i] = vector.getNum(i) * scalar;
        }
        return result;
    }

    public static ArrayVector scalarRes(ArrayVector vector, double scalar) {
        ArrayVector result = new ArrayVector(vector.getRazm());
        for (int i = 0; i < vector.getRazm(); i++) {
            result.vector[i] = vector.getNum(i) + vector.getNum(i);
        }
        return result;
    }

    public static double scalarProv(ArrayVector vector1, ArrayVector vector2) {
        if (vector1.getRazm() != vector2.getRazm()) {
            System.out.println("должна быть одинаковая длина");
        }
        double product = 0;
        for (int i = 0; i < vector1.getRazm(); i++) {
            product += vector1.getNum(i) * vector2.getNum(i);
        }
        return product;
    }
    public Iterator<Double> iterator() {
        System.out.println("Повторите попытку");
        return null;
    }
}
