package LinkedList;

/**
 * Write a function to reverse a linked list
   Given pointer to the head node of a linked list, the task is to 
   reverse the linked list.
  
   Examples:
   Input : Head of following linked list  
       1->2->3->4->NULL
   Output : Linked list should be changed to,
       4->3->2->1->NULL
 * @author BenFranklin
 *
 */
public class Reverse {
	
	public Node Run(Node list){
		Node start = list;
		Node reversed = null ;
		Node temp = null;
		
		//check if list is null
		
		if(start == null){
			return null;
		}		
		while(start != null){
			reversed  = start; 
			start = start.Next;
			reversed.Next = temp;
			temp = reversed;									
		}		
		return reversed;
	}
}