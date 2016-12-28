package ds;

public class LinkedList {
	Object data;
	Node Head;
	
	public LinkedList(){
		
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