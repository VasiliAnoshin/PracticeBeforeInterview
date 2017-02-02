package ReverseLL;
/**
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.
 *  For example,
 *	Given 1->1->2, return 1->2.
 *	Given 1->1->2->3->3, return 1->2->3.
 * @author BenFranklin 
 *  You got 291/300 points!
 *
 */

public class RemoveDuplicatedSortedList {
	public ListNode deleteDuplicates(ListNode a) {
	    ListNode runner = a;
	    if(runner == null){
	        return a;
	    }
	    
	    while(runner.next != null){
	        if(runner.val == runner.next.val){
	            runner.next = runner.next.next;
	            continue;
	        }
	        runner = runner.next;
	    }
	    return a;
	}
}
