package TP.cs.cs02.model.pilha;

import TP.cs.cs02.model.Node;

public class PilhaEncadeada implements Pilha {
    Node top;
    int size;

    @Override
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        int poppedValue = top.getValue();
        top = top.getNext();
        size--;
        return poppedValue;
    }

    @Override
    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Pilha encadeada: empty";
        }
        String message = "Pilha encadeada: ";

        Node current = top;
        while (current != null) {
            if (current.getNext() != null) {   
                message += "[" + current.getValue() + "] <-- ";
            } else {
                message += "[" + current.getValue() + "]";
            }
            current = current.getNext();
        }

        return message;
    }
}