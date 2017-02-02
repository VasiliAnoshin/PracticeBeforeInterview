package ReverseLL;
/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
	For example:
	Given 1->2->3->4->5->NULL and k = 2,
	return 4->5->1->2->3->NULL.
 * @author BenFranklin
 *
 */
public class rotateListFromAmazon {
	//First aaproch it solve the problem but in inefficient way . 
	public ListNode rotateRight(ListNode a, int b) {
		if(a==null){return null;}
		if(a.next == null){return a;}
		ListNode head = a;
		ListNode temp = null;
		ListNode newHead = null;
		
		for(int i = 0; i< b ; i++){
			temp = rotateOnce(head);
			newHead = head;
			head =temp;
			head.next = newHead;
		}
		return head;
	}
	
	public ListNode rotateOnce(ListNode node){
		ListNode prev = null;
		while(node.next != null){
			prev = node;
			node = node.next;
		}
		prev.next = null;
		return node;
	}
	/**
	 * Since n may be a large number compared to the length of list.
	 *  So we need to know the length of linked list. After that, move 
	 *  the list after the (l-n % l )th node to the front to finish the rotation.
	 *	Ex: {1,2,3} k = 2 Move the list after the 1st node to the front
	 *	Ex: {1,2,3} k = 5, In this case Move the list after (3-5 % 3=1)st node to the front.
	So the code has three parts.
	    1) Get the length
	    2) Move to the (l-n%l)th node
	    3) Do the rotation
	 */
	public ListNode rotateRight1(ListNode a, int b) {
		
	}
}