public class Vector {
    private double[] vector;

    public Vector(double[] values) {
        vector = values;
    }

    public void add(Vector other) {
        if (other.vector.length != vector.length) {
            System.out.println("разной длины");
        }
        for (int i = 0; i < vector.length; i++) {
            vector[i] += other.vector[i];
        }
    }

    public void res(Vector other) {
        if (other.vector.length != vector.length) {
            System.out.println("разной длины");
        }
        for (int i = 0; i < vector.length; i++) {
            vector[i] -= other.vector[i];
        }
    }

    public void result(double scalar) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] *= scalar;
        }
    }

    public double dotProduct(Vector other) {
        if (other.vector.length != vector.length) {
            System.out.println("Векторы разной длины");
        }
        double result = 0.0;
        for (int i = 0; i < vector.length; i++) {
            result += vector[i] * other.vector[i];
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder ch = new StringBuilder("[");
        for (int i = 0; i < vector.length; i++) {
            ch.append(vector[i]);
            if (i < vector.length - 1) {
                ch.append(", ");
            }
        }
        ch.append("]");
        return ch.toString();
    }

    /*public static void main(String[] args) {
        double[] num1 = {7.0, 8.0, 9.0};
        double[] num2 = {10.0, 11.0, 12.0};

        Vector vector1 = new Vector(num1);
        Vector vector2 = new Vector(num2);
        vector1.add(vector2);
        System.out.println("Ответ: " + vector1.toString());
        vector1.res(vector2);
        System.out.println("Ответ: " + vector1.toString());
        vector1.result(1.0);
        System.out.println("Ответ: " + vector1.toString());
        double dotProductResult = vector1.dotProduct(vector2);
        System.out.println("Ответ: " + dotProductResult);
        System.out.println("Начальный вариант веторов: ");
        System.out.println(vector1.toString());
        System.out.println(vector2.toString());
    }*/
}
