package LinkedList;
/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 *  leaving only distinct numbers from the original list.
	For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.
 * @author benFranklin
 *
 */
public class RemoveDuplicatesfromSortedList2 {
	
	public ListNode deleteDuplicates(ListNode a) {
	    ListNode temp;
	    ListNode head = a;
	    ListNode prev = null;
	    int dup = 0;
	    while(head.next != null){
	        if(head.val != head.next.val){
	        	prev = head;
	        	head = head.next;
	            continue;
	        }else{
	            dup = head.val;
	            while(head.val == dup && head.next != null){
	                head = head.next;
	                if(prev !=null){
	                    prev.next = head;
	                }
	                if(dup == a.val){
	                    a = head;
	                }
	            }
	            if(head.next == null){
	                if(dup == a.val){
	                    a = null;
	                }
	                head = null;
	                prev.next =null;
	                break;
	            }
	        }
	    }
	    return a;
	}
	//Official solution 
	public ListNode deleteDuplicates2(ListNode head){
		   if(head == null) return head;
	        ListNode helper = new ListNode(0);
	        helper.next = head;
	        ListNode pre = helper, cur = head;
	        while(cur!=null)
	        {
	            while(cur.next!=null && pre.next.val==cur.next.val)
	                cur = cur.next;
	            if (pre.next == cur) 
	                pre = pre.next;
	            else 
	                pre.next = cur.next;
	            cur = cur.next;
	        }
	        return helper.next;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node3 = new ListNode(1);
		node3.next = new ListNode(1);
		node3.next.next = new ListNode(1);
		node3.next.next.next = new ListNode(2);
		node3.next.next.next.next = new ListNode(3);
		node3.next.next.next.next.next = new ListNode(3);
		node3.next.next.next.next.next.next = new ListNode(3);
		node3.next.next.next.next.next.next.next = new ListNode(4);
		node3.next.next.next.next.next.next.next.next = new ListNode(4);
		RemoveDuplicatesfromSortedList2 rl = new RemoveDuplicatesfromSortedList2();
		//srl.deleteDuplicates(node3);
		
		ListNode rotatedList = rl.deleteDuplicates(node3);
		
		System.out.println("Ready to print");
		while(rotatedList != null){
			System.out.print(rotatedList.val + "->" );
			rotatedList =  rotatedList.next;
		}
		
		ListNode node4 = new ListNode(1);
		node4.next = new ListNode(1);
		node4.next.next = new ListNode(1);
		node4.next.next.next = new ListNode(2);
		node4.next.next.next.next = new ListNode(3);
		node4.next.next.next.next.next = new ListNode(3);
		
		ListNode rotatedList2 = rl.deleteDuplicates2(node4);
		System.out.println("Ready to print");
		while(rotatedList2 != null){
			System.out.print(rotatedList2.val + "->" );
			rotatedList2 =  rotatedList2.next;
		}
		
	}

}
