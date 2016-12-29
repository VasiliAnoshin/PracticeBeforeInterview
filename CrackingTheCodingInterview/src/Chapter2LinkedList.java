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
		// first approach using additional DataStructure for this purpose HashSet
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
		linkedList.display();
		linkedList.removeDuplicateElements();
		linkedList.display();
	}

}
