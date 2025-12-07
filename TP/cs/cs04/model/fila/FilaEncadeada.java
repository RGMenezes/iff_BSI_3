package TP.cs.cs04.model.fila;

import TP.cs.cs04.model.Node;

public class FilaEncadeada<T> implements Fila<T> {
    Node<T> front;
    Node<T> rear;
    int size;

    @Override
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }

        T dequeuedValue = front.getValue();
        front = front.getNext();
        size--;

        if (isEmpty()) {
            rear = null;
        }

        return dequeuedValue;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        return front.getValue();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Fila encadeada: empty";
        }
        String message = "Fila encadeada: ";

        Node<T> current = front;
        while (current != null) {
            if (current.getNext() != null) {   
                message += "[" + current.getValue() + "] --> ";
            } else {
                message += "[" + current.getValue() + "]";
            }
            current = current.getNext();
        }

        return message;
    }
}
