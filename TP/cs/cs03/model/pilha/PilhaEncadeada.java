package TP.cs.cs03.model.pilha;

import TP.cs.cs03.model.Node;

public class PilhaEncadeada<T> implements Pilha<T> {
    Node<T> top;
    int size;

    @Override
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        T poppedValue = top.getValue();
        top = top.getNext();
        size--;
        return poppedValue;
    }

    @Override
    public T top() {
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

        Node<T> current = top;
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