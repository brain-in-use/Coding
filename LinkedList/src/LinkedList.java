import java.util.*;
public class LinkedList {
	
	//creating single Linked List
private static class Node{
	private int value;
	private Node next;
	public Node(int v,Node n) {
		value = v;
		next=n;
	}
}
	private Node head;
	private int size=0;
	
	//Insert element at the Head
	public void addHead(int value) {
		head = new Node(value, head);
		size++;
		}
	
	//Traversing(PRINTING) the list
	public void print() {
		Node temp = head;
		while (temp != null) {
		System.out.print(temp.value + " ");
		temp = temp.next;
		}
		}
	
	//Add Node at tail(End)
	public void addTail(int value) {
		Node newNode = new Node(value, null);
		Node curr = head;
		if (head == null) {head = newNode;
		}
		while (curr.next != null) {
		curr = curr.next;
		}
		curr.next = newNode;
		}
	
	//Sorted Insert
	public void sortedInsert(int value) {
		Node newNode = new Node(value, null);
		Node curr = head;
		if (curr == null || curr.value > value) {
		newNode.next = head;
		head = newNode;
		return;
		}
		while (curr.next != null && curr.next.value < value) {
		curr = curr.next;
		}
		newNode.next = curr.next;
		curr.next = newNode;
		}
	
	//Search element in Linked List
	public boolean searchList(int data) {
		Node temp=head;
		while(temp !=null) {
			if(temp.value==data)
				return true;
			temp=temp.next;
		}
		return false;
		
	}
	
	//remove at head
	public int removeHead() throws IllegalStateException {
		if (isEmpty())
		throw new IllegalStateException("EmptyListException");
		int value = head.value;
		head = head.next;
		size--;
		return value;
		}
	
//	Delete node from the linked list given its value.
	public boolean deleteNode(int delValue) {
		Node temp = head;
		if (isEmpty())
		return false;
		if (delValue == head.value) {
		head = head.next;
		size--;
		return true;
		}
		while (temp.next != null) {
		if (temp.next.value == delValue) {
		temp.next = temp.next.next;
		size--;return true;
		}
		temp = temp.next;
		}
		return false;
		}
	//Check if the list is empty
	private boolean isEmpty() {
		if(head==null)
		return true;
		return false;
	}
	
	//Delete List
	public void deleteList() {
		head = null;
		size = 0;
		}

	//REVERSE THE LIST(Different from book)
	public Node reverse(Node head) {
		Node curr = head;
		Node prev = null;
		
		while (curr != null) {
		Node temp = curr.next;
		curr.next = prev;
		prev = curr;
		curr = temp;
		}
		return prev;
		}
	
	//REMOVE DUBLICAT ELEMENT
	public void removeDuplicate() {
		Node curr = head;
		while (curr != null) {
		if (curr.next != null && curr.value == curr.next.value) {
		curr.next = curr.next.next;
		} else {
		curr = curr.next;
		}
		}
		}
	
	
	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		//ll.addHead(3);
		//ll.addHead(1);
		//ll.addHead(3);
		//ll.print();
		
		//System.out.println();
		
		//ll.addTail(1);
//		ll.addTail(2);
//		ll.addTail(3);
//		ll.print();
		
		//System.out.println();
		ll.sortedInsert(7);
		ll.sortedInsert(2);
		ll.sortedInsert(1);
		ll.sortedInsert(4);
		ll.sortedInsert(10);
		ll.sortedInsert(1);
		ll.sortedInsert(8);
		ll.sortedInsert(2);
		ll.sortedInsert(13);
		ll.print();
		System.out.println();
		System.out.print("Enter the value to search: ");
		Scanner in=new Scanner(System.in);
		int data=in.nextInt();
		System.out.println(ll.searchList(data));
		ll.removeHead();
		System.out.print("After removing the head: ");
		ll.print();
		System.out.println();
		System.out.print("Enter the element to delete: ");
		data=in.nextInt();
		ll.deleteNode(data);
		in.close();
		ll.print();
		System.out.println();
		
//		ll.deleteList();
//		ll.print();
		
		ll.head=ll.reverse(ll.head);
		System.out.print("After reverse:");
		ll.print();
		ll.removeDuplicate();
		System.out.println();
		System.out.print("After removing duplicate elements: ");
		ll.print();
		
		
	}

}
