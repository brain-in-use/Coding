//import LinkedList.Node;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
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
	public Node(int v) {value = v;
	next = null;
	prev = null;
	}
	}
	
		
		//INSERTING AT HEAD
	public void addHead(int value) {
		Node newNode = new Node(value, null, null);
		if (size == 0) {
		tail = head = newNode;
		} else {
		head.prev = newNode;
		newNode.next = head;
		head = newNode;
		}
		size++;
		}
			
		
		
		//Printing the node
		public void print() {
			Node temp = head;
			while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
			}
			}
		
		//SORTED INSERT
		public void sortedInsert(int value) {
			Node temp = new Node(value);
			Node curr = head;
			if (curr == null)// first element
			{
			head = temp;
			tail = temp;
			}
			if (head.value <= value)// at the begining
			{
			temp.next = head;
			head.prev = temp;
			head = temp;
			}
			
			while (curr.next != null && curr.next.value > value)// treversal
			{
			curr = curr.next;
			}
			
			if (curr.next == null)// at the end
			{
			tail = temp;
			temp.prev = curr;
			curr.next = temp;} else { // all other
			temp.next = curr.next;
			temp.prev = curr;
			curr.next = temp;
			temp.next.prev = temp;
			}
			}
	
		//REMOVE HEAD
		public int removeHead() {
			if (isEmpty())
			throw new IllegalStateException("EmptyListException");
			int value = head.value;
			head = head.next;
			if (head == null)
			tail = null;
			else
			head.prev = null;
			size--;
			return value;
			}
		

	private boolean isEmpty() {
		if(head==null&&tail==null)
			return true;
			return false;
		}
	
	//REMOVE Node BY VALUE
	public boolean removeNode(int key) {
		Node curr = head;
		if (curr == null) // empty list
		return false;
		if (curr.value == key) // head is the node with value key.
		{
		head = head.next;
		size--;
		if (head != null)
		head.prev = null;
		else
		tail = null; // only one element in list.
		return true;
		}
		while (curr.next != null) {
		if (curr.next.value == key) {
		curr.next = curr.next.next;
		if (curr.next == null) // last element case.
		tail = curr;
		else
		curr.next = curr;
		size--;
		return true;
		}
		curr = curr.next;
		}
		return false;}

		//REMOVE DUPLICATE
	public void removeDuplicate() {
		Node curr = head;
		Node deleteMe;
		while (curr != null) {
		if ((curr.next != null) && curr.value == curr.next.value) {
		deleteMe = curr.next;
		curr.next = deleteMe.next;
		curr.next.prev = curr;
		if (deleteMe == tail) {
		tail = curr;
		}
		} else {
		curr = curr.next;
		}
		}
		}
	
		//reverse doubly linked list
	public void reverseList() {
		Node curr = head;
		Node tempNode;
		while (curr != null) {
		tempNode = curr.next;
		curr.next = curr.prev;
		curr.prev = tempNode;
		if (curr.prev == null) {
		tail = head;
		head = curr;
		return;
		}
		curr = curr.prev;
		}
		return;
		}
	
	

	public static void main(String[] args) {
		DoublyLinkedList dll=new DoublyLinkedList();
		dll.addHead(7);
		dll.addHead(5);
		dll.addHead(8);
		dll.print();
		
		System.out.println();
		
		DoublyLinkedList dll2=new DoublyLinkedList();
		dll2.addHead(9);
		dll2.sortedInsert(1);
		dll2.sortedInsert(8);
		dll2.sortedInsert(2);
		dll2.sortedInsert(4);
		dll2.sortedInsert(7);
		dll2.sortedInsert(4);
		dll2.sortedInsert(7);
		dll2.print();
		System.out.println();
		System.out.print("After removing the head: ");
		dll2.removeHead();
		dll2.print();
		System.out.print("\nAfter removing element 8: ");
		dll2.removeNode(8);
		dll2.print();
		dll2.removeDuplicate();
		System.out.print("\nAfter removing duplicate node: ");
		dll2.print();
		dll2.reverseList();
		System.out.print("\nAfter reversing the list: ");
		dll2.print();
	}

}
