package TP.cs.cs02.model;

public class Node {
	private int value;
	private Node next;
	
	public Node(int value) {
		this.value =  value;
		this.next = null;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}