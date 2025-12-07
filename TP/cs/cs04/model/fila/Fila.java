package TP.cs.cs04.model.fila;

public interface Fila<T> {
    void enqueue(T value);
    T dequeue();
    T front();
    boolean isEmpty(); 
    String toString();
}
