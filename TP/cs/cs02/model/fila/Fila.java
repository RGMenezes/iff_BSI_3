package TP.cs.cs02.model.fila;

public interface Fila {
    void enqueue(int elemento);
    int dequeue();
    int front();
    boolean isEmpty();
    String toString();
}
