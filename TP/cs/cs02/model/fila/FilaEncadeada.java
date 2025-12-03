package TP.cs.cs02.model.fila;

import TP.cs.cs02.model.Node;

public class FilaEncadeada implements Fila {
    Node front;
    Node rear;
    int size;

    @Override
    public void enqueue(int value) {
        Node newNode = new Node(value);
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
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }

        int dequeuedValue = front.getValue();
        front = front.getNext();
        size--;

        if (isEmpty()) {
            rear = null;
        }

        return dequeuedValue;
    }

    @Override
    public int front() {
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

        Node current = front;
        while (current != null) {
            if (current.getNext() != null) {   
                message += "[" + current.getValue() + "] --> ";
            }else{
                message += "[" + current.getValue() + "]";
            }
            current = current.getNext();
        }

        return message;
    }
}
