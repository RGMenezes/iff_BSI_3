package TP.cs.cs04.model.fila;

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

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Fila sequencial: empty";
        }
        String message = "Fila sequencial: ";

        message += "[" + elements[front] + "]";
        for (int i = proportionalPosition(front); i != proportionalPosition(rear); i = proportionalPosition(i)) {
            message += " <-- [" + elements[i] + "]";
        }
        return message;
    }
    
    private int proportionalPosition(int positionValue) {
        return (positionValue + 1) % elements.length;
    }
}
