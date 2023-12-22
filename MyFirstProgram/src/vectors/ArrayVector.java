package vectors;
import java.util.Arrays;
import java.io.Serializable;
public class ArrayVector implements VectorFactory, Serializable {

    public double[] vector;

    public ArrayVector(int length) {

        vector = new double[length];
    }
    @Override
    public ArrayVector createVector(int length) {
        return new ArrayVector(length);
    }
    public double getNum(int numb) {
        if (numb < 0 || numb >= vector.length) {
            System.out.println("0 нельзя.");
        }
        return vector[numb];
    }

    public int getRazm() {
        return vector.length;
    }

    public double getNorm() {
        double norm = 0;
        for (int i = 0; i <= vector.length; i++) {
            norm += vector[i] * vector[i];
        }
        return Math.sqrt(norm);
    }
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ArrayVector: [");
        for (int i = 0; i < vector.length; i++) {
            sb.append(vector[i]);
            if (i < vector.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ArrayVector other = (ArrayVector) obj;
        if (vector.length != other.vector.length) {
            return false;
        }
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] != other.vector[i]) {
                return false;
            }
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        for (double value : vector) {
            if (value == (int) value) {
                hash ^= Float.floatToIntBits((float) value);
            } else {
                long bits = Double.doubleToLongBits(value);
                int firstPart = (int) (bits ^ (bits >>> 32));
                int secondPart = (int) bits;
                hash ^= firstPart ^ secondPart;
            }
        }
        return hash;
    }
    @Override
    public Object clone() {
        ArrayVector clone = new ArrayVector(vector.length);
        System.arraycopy(vector, 0, clone.vector, 0, vector.length);
        return clone;
    }

    public void setElement(int index, double value) {
        System.out.println("ошибка");
    }


    public void addElement(double value) {
        System.out.println("ошибка");
    }


    public void removeElement(int index) {
        System.out.println("ошибка");
    }

    public static void main(String[] args) {
        ArrayVector originalArrayVector = new ArrayVector(3);
        ArrayVector clonedArrayVector = (ArrayVector) originalArrayVector.clone();
        ArrayVector vector1 = new ArrayVector(2);
        vector1.vector[0] = 6;
        vector1.vector[1] = 10;
        ArrayVector vector2 = new ArrayVector(2);
        vector2.vector[0] = 6;
        vector2.vector[1] = 10;

        System.out.println("Ответ 1 вектор: ");
        ArrayVector result = Vectors.scalarUmn(vector1, 5);
        System.out.println("Умножение: " + result.toString());
        System.out.println("Ответ 2 вектор: ");
        ArrayVector result2 = Vectors.scalarUmn(vector2, 5);
        System.out.println("Умножение: " + result2.toString());

        result2 = Vectors.scalarRes(vector1, 10);
        System.out.println("Сложение двух векторов: " + result2.toString());

        double umnozhenie = Vectors.scalarProv(vector1, vector2);
        System.out.println("Произведение: " + umnozhenie);

        // задание 5 интерфейс Iterator
        vector1.vector[0] = 6;
        vector1.vector[1] = 10;

        for (double value : vector1.vector) {
            System.out.println("Ответ работы интерфейса: " + value);
        }
    }

}

