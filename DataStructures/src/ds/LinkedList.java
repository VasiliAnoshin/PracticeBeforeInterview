package ds;

public class LinkedList {
	Object data;
	Node head;
	int size;
	
	public LinkedList(Object data){
		head = null;
	}
	
	public void insert(Object data){
		Node newNode = new Node(data);
		newNode.Next = head;
		head = newNode;
		size++;
	}
	
}

class Node{
	Object Data;
	Node   Next;
	
	public Node(Object _data){
		this.Data = _data;
		this.Next = null;
	}
}