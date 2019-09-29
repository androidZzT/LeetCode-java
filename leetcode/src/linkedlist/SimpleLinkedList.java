package linkedlist;

import java.util.ArrayList;

public class SimpleLinkedList<T> {
	private Node<T> head = null;
	private Node<T> prev = null;
	private Node<T> next = null;
	
	public SimpleLinkedList() {
		
	}
	
	static class Node<T> {
		Node<T> next;
		T value;
	}
	
	public void add(Node<T> oldNode,Node<T> newNode){
		insert(oldNode, newNode);
	}
	
	public void add(Node<T> newNode) {
		insert(next,newNode);
	}
	
	private void insert(Node<T> oldNode, Node<T> newNode) {
		if(head == null) {
			head = newNode;
			return;
		}
		if(oldNode == null) {
			next = newNode;
			return;
		}
		head.next = next;
	}
	
	public static void main(String[] args) {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
		Node<Integer> n = new Node();
		n.value = 1;
		list.add(n);
		Node<Integer> n2 = new Node();
		n2.value = 2;
		list.add(n2);
		String s = "Hello";
		String t = "Hello";
		System.out.println(s==t);
		final ArrayList<String> l = new ArrayList<>();
		l.add("s");
	}
	
}
