package assignment2;

import java.util.ArrayList;
import java.lang.IllegalStateException;

public class IDLList<E> {
	
	
	private class Node<E>{
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		public Node(E element) {
			this.data = element;
		}
		
		public Node(E elem, Node<E> prev, Node<E> next) {
			this.data = elem;
			this.next = next;
			this.prev = prev;
		}
	}
	
	
	private Node<E> tail;
	private Node<E> head;
	private int size;
	private ArrayList<Node<E>> indices;
	
	
	
	public IDLList() {
		tail = null;
		head = null;
		this.size = 0;
		indices = new ArrayList(size);
		indices.add(0, head);
		indices.add(tail);
		
		
	}
	
	public boolean add (int index, E elem) {
		Node<E> newElement = new Node<E>(elem, null, null);

		if (index == 0 && indices.get(index+1) == null) {
			indices.add(index, newElement);
			newElement.next=null;
			newElement.prev=null;
			head = newElement;
			size++;
			return true;
		}

		if (index == 0) {
			indices.add(index, newElement);
			indices.get(index+1).prev=newElement;
			newElement.next=indices.get(index+1);
			newElement.prev=null;
			head = newElement;
			size++;
			return true;
		}
		else if (index==size) {
			indices.add(index, newElement);
			indices.get(index-1).next=newElement;
			newElement.next = null;
			newElement.prev=indices.get(index-1);
			tail = newElement;
			size++;
			return true;
			
		}
		
		else {
		
		indices.add(index, newElement);
		indices.get(index-1).next=newElement;
		indices.get(index+1).prev=newElement;
		newElement.prev=indices.get(index-1);
		newElement.next=indices.get(index+1);
		size++;
		return true;
		}
	}
	
	public boolean add (E elem) {
		Node<E> newElement = new Node<E>(elem, null, null);
		if (size==0) {
			head = new Node<E>(null, null, null);
		}
		head.prev = newElement;
		newElement.next = head;
		head = newElement;
		size++;
		indices.add(0, head);
		tail = indices.get(size-1);
		indices.set(size-1, tail);
		
		return true;
		
	}
	
	public boolean append(E elem) {
		Node<E> newElement = new Node<E>(elem, null, null);
		if (size==0) {
			tail = new Node<E>(null, null, null);
		}
		tail.next = newElement;
		newElement.prev = tail;
		tail = newElement;
		size++;
		indices.add(size-1, tail);
		head = indices.get(0);
		indices.set(0, head);
		
		
		
		return true;
		
		
	}
	
	public E get(int index) { return indices.get(index).data; }
	
	public E getHead() {
		return get(0);
	}
	
	public E getLast() {
		return get(size-1);
	}
	
	public int size() {
		return size;
	}
	
	public E remove() {
		if (head.data== null) {
			throw new IllegalStateException("Error: No element at head");
			
		}
		else{
			
			Node<E> temp = head;
			head.next.prev=null;
			head=head.next;
			indices.remove(0);
			size--;
			return temp.data;
		}
	}
	
	public E removeLast() {
		if (tail.data==null) {
			throw new IllegalStateException("Error: No element at tail");
		}
		else {
			Node<E> temp = tail;
			tail.prev.next = null;
			tail = tail.prev;
			indices.remove(size-1);
			size--;
			return temp.data;
		}
		
	}
	
	public E removeAt(int index) {
		try {
		E temp = get(index);
		indices.get(index).prev.next = indices.get(index).next;
		indices.get(index).next.prev = indices.get(index).prev;
		indices.remove(index);
		size--;
		return temp;
		}
		catch(Exception e){
			throw new IllegalStateException("Error: No element at index");
		}
		
	}
	
	public boolean remove(E elem) {
		for (int i = 0; i< indices.size();i++) {
			if (indices.get(i).data.equals(elem)){
				indices.get(i).prev.next = indices.get(i).next;
				indices.get(i).next.prev = indices.get(i).prev;
				indices.remove(i);
				size--;
				return true;
			}
		}
		return false;
	}
	
	
	
	public String toString() {
		Node<E> current = head;
		StringBuilder s1 = new StringBuilder("[");
		if (current != null) {
			s1.append(current.data);
			current = current.next;
			
		}
		while (current != null) {
			if (current.data == null) {
				break;
			}
			s1.append(", ");
			s1.append(current.data);
			current = current.next;
		}
		s1.append("]");
		return s1.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
