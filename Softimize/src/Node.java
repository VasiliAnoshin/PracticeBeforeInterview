/**
 * PersonCollection presented as LinkedList where each item hold Person data. 
 * 
 * @author BenFranklin
 */
public class Node<T> {
	
	// reference to the next node in the chain, or null if there isn't one.
	private Node<T> next;
	// data carried by this node. could be of any type you need.
	private T data;
	//Node Constructor
	public Node(T dataValue){
		this.data =  dataValue;
		next = null;
	}
	// another Node constructor if we want to specify the node to point to.
	public Node(T dataValue, Node<T> nextValue) {
		next = nextValue;
		data = dataValue;
	}
	// these methods should be self-explanatory
	public T getData() {
		return data;
	}
	public Node<T> getNext() {
		return next;
	}	
	public void setNext(Node<T> nextValue) {
		next = nextValue;
	}
	public void setData(T dataValue) {
		data = dataValue;
	}
}