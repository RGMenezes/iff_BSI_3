package TP.cs.cs04.model.pilha;

public interface Pilha<T> {
    void push(T value);
    T pop();
    T top();
    boolean isEmpty(); 
    String toString();
    int size();
}
