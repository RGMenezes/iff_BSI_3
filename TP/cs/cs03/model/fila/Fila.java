package TP.cs.cs03.model.fila;

public interface Fila<T> {
    void enqueue(T value);
    T dequeue();
    T front();
    boolean isEmpty(); 
    String toString();
}
