import java.util.HashSet;

public class Chapter2LinkedList {
	public LinkedListT2 getInstance(){
		return new LinkedListT2();
	} 

	public class LinkedListT2 {
		private Object data;
		private Node head;
		int size;
		
		public LinkedListT2(){
			head = null;
		}
		//Insert into begining of the list
		public void insert(Object data){
			Node newNode = new Node(data);
			newNode.Next = head;
			head = newNode;
			size++;
		}
		//delete from the begining
		public Node deleteNodeAtBegin(){
			if(size == 0){
				return null;
			}
			Node tmp = head;
			head = head.Next;
			size--;
			return tmp;
		}
		//delete from the end
		public void deleteAtTheEnd(){
			Node tmp = head;
			if(size == 0){
				return ;
			}		
			if (tmp.Next == null){
				head = null;
			}else{
				while(tmp.Next.Next != null){				
					tmp = tmp.Next;
				}
				tmp.Next = null;
				size--;
			}
		}
		//Return Pointer to this node according to Cormen book or Null if does't exist
		public Node Search(Object obj){
			Node temp = head;
			while(temp != null){
				if (temp.Data == obj){
					return temp;
				}else{
					temp = temp.Next;
				}
			}		
			return null;
		}
		//return index of this node 
		public int SerchNodeIndex(Object data){
			Node node = head;
			int counter = 1;
			while (node != null){
				if (node.Data == data){
					return counter;
				}else{
					node = node.Next;
					counter++;
				}
			}
			return -1;
		}
		public void insertNodeAtIndex(Object data , int position){
			if(position == 1){
				insert(data);
			}				
			if(position > size || position <= 0){
				System.out.println("\n ALERT ");
				System.out.print(" Wrong position inserted for " + data);
			}
			if(position > 1 && position <= size ){
				Node temp = head;
				Node insertedNode = new Node(data);
				
				for(int i = 1 ; i < position ; i++){
					temp = temp.Next;
				}
				Node tail = temp.Next;
				temp.Next = insertedNode;
				insertedNode.Next = tail;
				size++;
			}			
		}		
		public void display() {
			System.out.println("");
			Node currNode = head;
			while (currNode != null) {
				System.out.print("->" + currNode.Data);
				currNode = currNode.Next;
			}
		}
		public int Length(){
			return size;
		}
		//#2.1 Write code to remove duplicates from an unsorted List 
		// first approach using additional DataStructure for this purpose HashSet COMPLEXITY O(N) + Additional Space is used
		public void removeDuplicateElements(){
			Node temp = head;
			HashSet<Object> hs = new HashSet();
			hs.add(temp.Data);
			while(temp.Next!=null){
				if(hs.contains(temp.Next.Data)!= true){
					hs.add(temp.Next.Data);
					temp = temp.Next;
				}else{
					temp.Next = temp.Next.Next;
				}
			}
		}
		//#2.1 Without additional dataStructure
		public void removeDuplicates(){
			Node first = head;
			Node second = head;
			
			while(first.Next !=null){
				while(second.Next !=null){
					if(second.Next.Data == first.Data){
						second.Next = second.Next.Next;						
					}else{
					second = second.Next;
					}
				}
				first = first.Next;
				second =first;
			}
		}
		//#2.2 Without additional dataStructure
		//Implement an algorithm to find the kth to last of a singly linkedList
		public Node GetTheNElementFromTheEnd(int k ){
			if(k <= 0){
				return null;
			}
			
			Node first = head;
			Node second = head;
			//Let's make interval between two Nodes in length of k
			for(int i =0 ; i< k ; i++){				
				// if there is no interval in such length return null
				if (second == null){
					return null; 
				}
				second = second.Next;
			}
			
			while (second != null){
				second = second.Next;
				first = first.Next;
			}
			return first;
		}
		//#2.3 Implement an algorithm to delete the middle of the linkedList given link to this node only
		public boolean DeleteNodeFromtheMiddle(Node nod){
			if (nod == null || nod.Next!=null){
				return false;
			}
			
			nod.Data = nod.Next.Data;
			nod.Next= nod.Next.Next;
			return true;
		}
		//#2.4 write code to partition a a linkedList around a value x , such that all nodes 
		//less than x come before all nodes greater than or equal to x .
		public Node partirion(int number ){
			//Create two LinkedList's
			Node head = null;
			Node tail = null;
			
			//Pointer to LinkedList
			Node temp = this.head;
			//LinkedList partition into the RightSide and theLeftSide 
			// In LeftSide all the values are lower then pivot , in the rightSide all the values are greater than pivot
			while(temp != null){
				//Pointer to the next node in LinkList
				Node next = temp.Next;
				if((int)temp.Data < number ){
					temp.Next = head;
					head = temp;
				}else{
					temp.Next = tail;
					tail = temp;
				}
				temp = next;
			}
			//If head is null return the tail 
			if (head == null){
				return tail;
			}
			Node tempNode = head;
			//We should merge two parts of the list . Iterating until the end of the head and merge them .
			while(tempNode.Next!=null){
				tempNode = tempNode.Next;				
			}
			tempNode.Next = tail;
			return head;
		}
		
		//============================= Interview question ===============================
		//given access to the head.
		public boolean deleteTheMiddleOfTheLinkedList(){
			//check that there is exist elements in the List
			if(head == null){
				return false;
			}
			//Two pointers one run as usually and the second run in two nodes each times. 
			Node first  = head;
			Node second = head;
			// Critical case if LinkedList has more than 1 elements
			if(head.Next != null){
				second = second.Next.Next;
				if(second == null){
					first.Next = first.Next.Next;
					return true;
				}
			}else {
				return false;
			}
			//find and determine the middle of the LinkedList
			while(second.Next != null){
				first = first.Next;
				second = second.Next;
				if(second.Next == null){
					break;
				}else{
					second = second.Next;
				}				
			}
			//Remove the node from the List
			Node temp = first.Next;
			first.Next = temp.Next;
			return true;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chapter2LinkedList chapter2 = new Chapter2LinkedList();
		Chapter2LinkedList.LinkedListT2 linkedList = chapter2.getInstance();
		//====================CHAPTER 2.1 ==========================================
		linkedList.insert("Daniel");
		linkedList.insert("Golcman");
		linkedList.insert("Salomon");
		linkedList.insert("Yoni");
		linkedList.insert("Daniel");
		linkedList.insert("Daniel");
		linkedList.insert("Golcman");
		linkedList.display();
		//linkedList.removeDuplicates();
		System.out.println();
		System.out.println("Third node from the end : " + linkedList.GetTheNElementFromTheEnd(1).Data);
		linkedList.display();
		//======================
		linkedList.deleteTheMiddleOfTheLinkedList();
		linkedList.display();
		linkedList.deleteTheMiddleOfTheLinkedList();
		linkedList.display();
		linkedList.deleteTheMiddleOfTheLinkedList();
		linkedList.display();
		linkedList.deleteTheMiddleOfTheLinkedList();
		linkedList.deleteTheMiddleOfTheLinkedList();
		linkedList.display();
		linkedList.deleteTheMiddleOfTheLinkedList();
		linkedList.display();			
		linkedList.insert("Yoni");
		linkedList.insert("Daniel");
		linkedList.display();
		linkedList.DeleteNodeFromtheMiddle(linkedList.Search("Yoni"));
		linkedList.display();
		//===================== Partition 
		Chapter2LinkedList newLinkList = new Chapter2LinkedList();
		Chapter2LinkedList.LinkedListT2 linkedList2 = newLinkList.getInstance();
		linkedList2.insert(4);
		linkedList2.insert(8);
		linkedList2.insert(19);
		linkedList2.insert(45);
		linkedList2.insert(6);
		Node temp = linkedList2.partirion(9);
		System.out.println();
		while (temp != null) {
			System.out.print("->" + temp.Data);
			temp = temp.Next;
		}		
	}

}
