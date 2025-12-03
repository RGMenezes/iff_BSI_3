package TP.cs.cs02.model.pilha;

public interface Pilha {
    void push(int value);
    int pop();
    int top();
    boolean isEmpty(); 
    String toString();
}
