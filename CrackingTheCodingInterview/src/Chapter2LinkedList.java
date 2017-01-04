import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Chapter2LinkedList {
	private static boolean Person;
	public LinkedListT2 getInstance(){
		return new LinkedListT2();
	} 
	public Person getPerson(String name){
		return new Person(name);
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
		//#2.5 Sum List .Two numbers represented by a LinkedList -each node contains a
		//single digit Start from tail . 7->1->6 + 5->9->2 = that is 617 + 295 = 912. 		
        public Node sumLinkedList(Node list1 , Node list2 , int carry){
        	//Exit condition 
        	if(list1 == null && list2 == null && carry == 0 ){
        		return null;
        	}
        	//First we should to add two left numbers but add them in the end that's why we will use recursion approach 
        	//In each recursion level we give carry from the previous operation . And start create new list only when end is reached .        	
        	int value = carry;
        	Node result = null;
        	//Compute the number from data of two nodes include carry. 
        	if(list1 !=null){
        		value += (int)list1.Data; 
        	}
        	if(list2 != null){
        		value += (int)list2.Data;
        	}        	
        	
        	result = new Node(value % 10);
        	
        	if(list1 != null || list2 != null){
        	result.Next =	sumLinkedList((list1 == null ? null : list1.Next),
						(list2 == null ? null : list2.Next),
						value >= 10 ? 1:0);        	
			}  
        	return result; 
        }
       
        //TODO 2.5 PART 2 Not implemented . important exercise . 
    	//=========================== Second part preparation ============================
        public int Length(Node nod){
        	Node temp = nod;
        	int length = 0;
        	if(temp == null){
        		return 0;
        	}
        	while(temp != null){
        		length++;
        		temp = temp.Next;
        	}
        	
        	return length;
        }
    	class Node{
    		Object Data;
    		Node   Next;
    		
    		public Node(Object _data){
    			this.Data = _data;
    			this.Next = null;
    		}
    	}
    	
    	//2.6 Given a circular LinkedList implement an algorithm which returns the node in the begining 
    	//of the loop : For example A -> B -> C -> D-> E -> C Should return C .
    	//Classic interview question isLinkedList have loop . 
    	public boolean LinkHasLoop(Node node){
    		if(node == null ){
    			return false;
    		}
    		//Creating two runners   		
    		Node slow = node;
    		Node fast = node;
    		    		
    		while(true){   			
    			if(fast.Next == null){ 
    				return false;
    			}else{
    				//2hop
    				fast = fast.Next.Next;
    			}
    			//1 hop
    			slow = slow.Next;
    			if(fast != null) {
    				if(fast.Data == slow.Data){
    					return true;
    				}
    			}else
    			{
    				return false;
    			}    			
    		}
    	}
    	//Find the begining of the loop , there is same solution with addition action. 
    	//when we get collision point we should to complement the number of steps that 
    	// fast pointer was inside the loop - there is the same number as first did from begining to start of the loop.    	
    	public Node LoopBegining(Node startNode){
    		if(startNode == null ){
    			return null;
    		}
    		//Creating two runners , both of them point onto start Of the Loop. 		
    		Node slow = startNode;
    		Node fast = startNode;
    		    		
    		while(true){   			
    			if(fast.Next == null){ 
    				return null;
    			}else{
    				//2hop
    				fast = fast.Next.Next;
    			}
    			//1 hop
    			slow = slow.Next;
    			if(fast != null) {
    				//Collision found 
    				if(fast.Data == slow.Data){
    					break;
    				}
    			}else 
    			{
    				return null;
    			}
    		}
    		//In this point two pointers are point into the same node in the LinkList ,
    		//change speed of the fast to jump by one node each time and slow to start jump from the begining .
    		fast = startNode;
    		while(slow != fast){
    			slow = slow.Next;
    			fast = fast.Next;
    		}
    		return slow;
    	}
    	/*
    	 * 2.7 Check if the LinkedList is palindrome has two solutions . 
    	 * 1) By reversing the LinkedList and check the first half of the new LinkedList is equal to first Half of the old LinkedList .
    	 * 2)Implemented solution :  By using Fast/Slow technique
    	 */
    	public boolean isPalindrom(Node node){
    		Node left = node;
    		Node right = node;
    		//check if there is empty list or one element in the list
    		if(node == null || node.Next==null){
    			return false;
    		}
    		//creating a stack LIFO .
    		Stack info = new Stack();
    		right = right.Next;
    		info.push(left);    		
    		while(true){    			
    			if(right.Next != null){
    				right = right.Next.Next;
    			}else{
    				//check if number of elements in the list is even -> point to the middle
    				left = left.Next;
    				break;
    			}
    			
    			if(right != null){
    				left = left.Next;
    				info.push(left);
    			}else{
    				//if number of the elements is odd. 
    				left =left.Next.Next;
    				break;
    			}
    		}
    		
    		while(!info.empty()){
    			Node temp = (Node) info.pop();
    			if(temp.Data == left.Data){
    				left = left.Next;
    				continue;
    			}else{
    				return false;
    			}
    		}
    		return true;
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

	public static void main(String[] args) {
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
		Chapter2LinkedList.LinkedListT2.Node temp = linkedList2.partirion(9);
		System.out.println();
		while (temp != null) {
			System.out.print("->" + temp.Data);
			temp = temp.Next;
		}
		
		//======================SumOfTwoLists
		Chapter2LinkedList.LinkedListT2 List1T = newLinkList.getInstance();		
		Chapter2LinkedList.LinkedListT2 List2T = newLinkList.getInstance();		
		
		List1T.insert(6);
		List1T.insert(1);
		List1T.insert(7);
		
		List2T.insert(2);
		List2T.insert(9);
		List2T.insert(5);
		List2T.insert(1);
	    Chapter2LinkedList.LinkedListT2.Node  nod = linkedList2.sumLinkedList(List1T.head, List2T.head ,0);
		
	    
	    //==============================Interview question======================================	
	    //Foreach loop check : how it behave if remove one of his elements . 
	    Person a = new Person("dan");
	    Person b = new Person("Sal");
	    Person[] arr = new Person[2];
	    arr[0] = a;
	    arr[1] = b;
	    ArrayList arr2 = new ArrayList();
	    arr2.add(a);
	    arr2.add(b);
	    
	    /*
	     * If remove an element during iterator it lead to exeption . Java documentation : 
	     * The iterators returned by this class's iterator and listIterator methods are fail-fast:
	     *  if the list is structurally modified at any time after the iterator is created, 
	     *  in any way except through the iterator's own remove or add methods, the iterator 
	     *  will throw a ConcurrentModificationException. Thus, in the face of concurrent 
	     *  modification, the iterator fails quickly and cleanly, rather than risking arbitrary,
	     *  non-deterministic behavior at an undetermined time in the future.
	     */
	    for(Object per : arr2){
	    	//arr2.remove(per);
	    }
	    
		//=========================================End of Interview qestion 
	    Chapter2LinkedList.LinkedListT2 linkedList3 = chapter2.getInstance();
	    linkedList3.insert("A");
	    linkedList3.insert("A");
	    linkedList3.insert("B");
	    linkedList3.insert("B");
	    System.out.println("\n");
	    System.out.println(linkedList3.isPalindrom(linkedList3.head));
	    
	}	

	

}
