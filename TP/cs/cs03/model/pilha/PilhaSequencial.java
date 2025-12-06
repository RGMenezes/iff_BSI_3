package TP.cs.cs03.model.pilha;

public class PilhaSequencial<T> implements Pilha<T> {
    private T[] elements;
    private int top;
    private static final int DEFAULT_SIZE = 20;
    
    @SuppressWarnings("unchecked")
    public PilhaSequencial() {
        elements = (T[]) new Object[DEFAULT_SIZE];
        top = -1;
    }

    @SuppressWarnings("unchecked")
    public PilhaSequencial(int size) {
        elements = (T[]) new Object[size];
        top = -1;
    }

    @Override
    public void push(T value) {
        if (top == elements.length - 1) {
            throw new IllegalStateException("Pilha cheia");
        }
        elements[++top] = value;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return elements[top--];
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return elements[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Pilha sequencial: empty";
        }
        String message = "Pilha sequencial: ";

        for (int i = top; i >= 0; i--) {
            if (i == 0) {
                message += "[" + elements[i] + "]";
            } else {
                message += "[" + elements[i] + "] <-- ";
            }
        }

        return message;
    }
}