package TP.cs.cs02.model.fila;

public class FilaSequencial implements Fila {
    private int[] elements;
    private int front;
    private int rear;
    private int size;
    private final static int CAPACITY = 20;

    public FilaSequencial() {
        this.elements = new int[CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }
    public FilaSequencial(int capacity) {
        this.elements = new int[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    @Override
    public void enqueue(int value) {
        if (size == elements.length) {
            throw new IllegalStateException("Fila cheia");
        }
        rear = proportionalPosition(rear);
        elements[rear] = value;
        size++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        int dequeuedValue = elements[front];
        front = proportionalPosition(front);
        size--;
        return dequeuedValue;
    }

    @Override
    public int front() {
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
        String message = "Pilha sequencial: ";

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
