package TP.cs.cs04.model.pilha;

import TP.cs.cs04.model.Node;

public class PilhaEncadeada<T> implements Pilha<T> {
    Node<T> top;
    int size = 0;

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
            return null;
        }
        T poppedValue = top.getValue();
        top = top.getNext();
        size--;
        return poppedValue;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            return null;
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

    @Override
    public int size() {
        return size;
    }
}