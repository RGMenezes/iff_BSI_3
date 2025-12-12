package TP.cs.cs03.model.fila;

public class FilaSequencial<T> implements Fila<T> {
    private T[] elements;
    private int front;
    private int rear;
    private int size;
    private final static int CAPACITY = 20;

    @SuppressWarnings("unchecked")
    public FilaSequencial() {
        this.elements = (T[]) new Object[CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    @SuppressWarnings("unchecked")
    public FilaSequencial(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    @Override
    public void enqueue(T value) {
        if (size == elements.length) {
            throw new IllegalStateException("Fila cheia");
        }
        rear = proportionalPosition(rear);
        elements[rear] = value;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        T dequeuedValue = elements[front];
        front = proportionalPosition(front);
        size--;
        return dequeuedValue;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        return elements[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "Fila sequencial: empty";
        }

        StringBuilder sb = new StringBuilder("Fila sequencial: ");

        int i = front;
        while (true) {
            sb.append("[").append(elements[i]).append("]");
            if (i == rear) break;
            sb.append(" <-- ");

            i = proportionalPosition(i);
        }

        return sb.toString();
    }
    
    private int proportionalPosition(int positionValue) {
        return (positionValue + 1) % elements.length;
    }
}
