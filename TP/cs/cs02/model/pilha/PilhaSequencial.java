package TP.cs.cs02.model.pilha;

public class PilhaSequencial implements Pilha{
    private int[] elements;
    private int top;
    private static final int DEFAULT_SIZE = 20;
    
    public PilhaSequencial() {
        elements = new int[DEFAULT_SIZE];
        top = -1;
    }
    public PilhaSequencial(int size) {
        elements = new int[size];
        top = -1;
    }

    @Override
    public void push(int value) {
        if (top == elements.length - 1) {
            throw new IllegalStateException("Pilha cheia");
        }
        elements[++top] = value;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return elements[top--];
    }

    @Override
    public int top() {
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