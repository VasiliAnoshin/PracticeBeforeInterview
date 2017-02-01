/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	return 1->4->3->2->5->NULL.
 	Note:
	Given m, n satisfy the following condition:
	1 ≤ m ≤ n ≤ length of list. Note 2:
	Usually the version often seen in the interviews is 
	reversing the whole linked list which is obviously an easier version of this question. 
 *	
 * @author BenFranklin
 *
 */
package ReverseLL;

public class reverseIndexedLink {
	public ListNode reverseBetween(ListNode a, int m, int n) {
		int counter = 1;
		ListNode head = null;
		ListNode reversedList = null;
		ListNode runner = a;
		ListNode temp = null;
		
		while(true){
			if(counter==m){
				break;
			}
			counter++;
			head = runner;
			runner = runner.next;
		}
		
		while(true){
			if(counter == n){
				reversedList = runner;
				runner = runner.next;
				reversedList.next = temp;
				temp = reversedList;
				break;
			}
			reversedList = runner;
			runner = runner.next;
			reversedList.next = temp;
			temp = reversedList;
			counter++;
		}
		
		if(head != null){
			head.next =reversedList;
		}else{
			a =reversedList;
		}
		if(runner != null){
			while(reversedList.next != null){
				reversedList = reversedList.next;
			}
			reversedList.next = runner;
		}				
		return a;
	}
}
 class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
}