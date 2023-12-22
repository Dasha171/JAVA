package vectors;
public class LinkedListVector{
    private Node head;
    private int size;

    public LinkedListVector(int initialSize) {
        head = null;
        size = 0;
        if (initialSize <= 0) {
            throw new IllegalArgumentException("Initial size must be greater than 0");
        }

        for (int i = 0; i < initialSize; i++) {
            addElement(0.0);
        }
    }

    public double getElement(int index) {
        if (index < 0 || index >= size) {
            throw new VectorIndexOutOfBoundsException("Индекс выходит за пределы размера вектора", index);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int getSize() {
        return size;
    }

    public double getNorm() {
        double norm = 0;
        Node current = head;
        while (current != null) {
            norm += current.data * current.data;
            current = current.next;
        }
        return Math.sqrt(norm);
    }

    public void addElement(double value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new VectorIndexOutOfBoundsException("Индекс выходит за пределы размера вектора", index);
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    private class Node {
        double data;
        Node next;

        Node(double data) {
            this.data = data;
            this.next = null;
        }
    }


}
