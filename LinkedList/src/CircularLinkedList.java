	import java.util.Scanner;
	public class CircularLinkedList{
	
	private Node tail;
	private int size = 0;
	private static class Node {
	private int value;
	private Node next;
	public Node(int v, Node n) {
	value = v;
	next = n;
	}
	public Node(int v) {
	value = v;
	next = null;
	}
	}
		
	//Insert element at the Head
	public void addHead(int value) {
	Node temp = new Node(value, null);
	if (isEmpty()) {
	tail = temp;
	temp.next = temp;
	} else {
	temp.next = tail.next;
	tail.next = temp;
	}
	size++;
	}
	
	//ADD tail
	public void addTail(int value) {
	Node temp = new Node(value, null);
	if (isEmpty()) {
	tail = temp;
	temp.next = temp;
	} else {
	temp.next = tail.next;
	tail.next = temp;
	tail = temp;
	}size++;
	}
	
	//search an element
	public boolean searchList(int data) {
	Node temp = tail;
	for (int i = 0; i < size; i++) {
	if (temp.value == data)
	return true;
	temp = temp.next;
	}
	return false;
	}
	
	//print elements
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
	
	//remove element at head
	public int removeHead() throws IllegalStateException {
	if (isEmpty()) {
	throw new IllegalStateException("EmptyListException");
	}
	int value = tail.next.value;
	if (tail == tail.next)
	tail = null;
	else
	tail.next = tail.next.next;
	size--;
	return value;
	}
	
	//remove node
	public boolean removeNode(int key) {
	if (isEmpty()) {
	return false;
	}
	Node prev = tail;Node curr = tail.next;
	Node head = tail.next;
	if (curr.value == key)// head and single node case.
	{
	if (curr == curr.next)// single node case
	tail = null;
	else // head case
	tail.next = tail.next.next;
	return true;
	}
	prev = curr;
	curr = curr.next;
	while (curr != head) {
	if (curr.value == key) {
	if (curr == tail)
	tail = prev;
	prev.next = curr.next;
	return true;
	}
	prev = curr;
	curr = curr.next;
	}
	return false;
	}
	
	
	//delete the list
	public void deleteList() {
	tail = null;
	size = 0;
	}
	
	//check if the list is empty
	private boolean isEmpty() {
		if(tail==null)
			return true;
			return false;
	}
	
	public static void main(String[] args) {
		CircularLinkedList ll = new CircularLinkedList();
	ll.addHead(1);
	ll.addHead(2);
	ll.addHead(3);
	ll.addHead(1);
	ll.addHead(2);
	ll.addHead(3);
	ll.print();
	
	System.out.println();
	
	Scanner in=new Scanner(System.in);
	System.out.print("Enter the element to search: ");
	int x=in.nextInt();
	if(ll.searchList(x))
		System.out.println("Element present.");
	else
		System.out.println("Eement not present");
	
	ll.removeHead();
	System.out.print("After removing the head:" );
	ll.print();
	}
	}