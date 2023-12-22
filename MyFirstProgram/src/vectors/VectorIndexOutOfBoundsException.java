package vectors;

public class VectorIndexOutOfBoundsException extends RuntimeException {
    private int index;

    public VectorIndexOutOfBoundsException(String message, int index) {
        super(message);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
