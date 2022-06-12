import java.util.Scanner;

public class DoublyCircularLinkedList {
	
	//Creating Doubly Circular Linked List
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	private static class Node {
	private int value;
	private Node next;
	private Node prev;
	public Node(int v, Node nxt, Node prv) {
	value = v;
	next = nxt;
	prev = prv;
	}
	public Node(int v) {
	value = v;
	next = this;
	prev = this;
	}
	}
	
	//INSERT NODE AT HEAD
	public void addHead(int value) {
		Node newNode = new Node(value, null, null);
		if (size == 0) {
		tail = head = newNode;
		newNode.next = newNode;
		newNode.prev = newNode;
		} else {
		newNode.next = head;
		newNode.prev = head.prev;
		head.prev = newNode;
		newNode.prev.next = newNode;
		head = newNode;
		}
		size++;
		}

	
		//INSERT NODE AT TAIL
	public void addTail(int value) {
		Node newNode = new Node(value, null, null);
		if (size == 0) {
		head = tail = newNode;
		newNode.next = newNode;
		newNode.prev = newNode;
		} else {
		newNode.next = tail.next;
		newNode.prev = tail;
		tail.next = newNode;
		newNode.next.prev = newNode;
		tail = newNode;
		}
		size++;
		}
	
	//REMOVE HEAD
	public int removeHead() {
		if (size == 0)
		throw new IllegalStateException("EmptyListException");
		int value = head.value;
		size--;
		if (size == 0) {
		head = null;
		tail = null;
		return value;
		}
		Node next = head.next;
		next.prev = tail;
		tail.next = next;
		head = next;
		return value;
		}
	
	//REMOVE TAIL
	public int removeTail() {
		if (size == 0)
		throw new IllegalStateException("EmptyListException");
		int value = tail.value;
		size--;
		if (size == 0) {
		head = null;
		tail = null;
		return value;
		}
		Node prev = tail.prev;
		prev.next = head;
		head.prev = prev;
		tail = prev;
		return value;
		}
	
	//SEARCH A VALUE
	public boolean searchList(int data) {
		Node temp = tail;
		for (int i = 0; i < size; i++) {
		if (temp.value == data)
		return true;
		temp = temp.next;
		}
		return false;
		}
	
	//PRINT THE LIST
	public void print() {
	if (isEmpty()) {
	return;
	}
	Node temp = tail.next;while (temp != tail) {
	System.out.print(temp.value + " ");
	temp = temp.next;
	}
	System.out.print(temp.value);
	}
	
	//check if the list is empty
		private boolean isEmpty() {
			if(tail==null)
				return true;
				return false;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyCircularLinkedList dcll= new DoublyCircularLinkedList();
		dcll.addHead(2);
		dcll.addHead(5);
		dcll.addHead(1);
		dcll.addHead(4);
		dcll.addHead(3);
		dcll.addTail(9);
		dcll.print();
		System.out.println();
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the element to search: ");
		int x=in.nextInt();
		if(dcll.searchList(x))
			System.out.println("Element present.");
		else
			System.out.println("Eement not present");
		
		dcll.removeHead();
		System.out.println("After removing the head: "+dcll.removeHead());
		dcll.print();
	}

}
