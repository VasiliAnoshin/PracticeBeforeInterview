package LinkedList;

public class App {

	public static void main(String[] args) {
		Reverse reverseList = new Reverse();
		Node start = new Node(5);
		start.Next = new Node(4);
		start.Next.Next = new Node(3);
		start.Next.Next.Next = new Node(2);
		start.Next.Next.Next.Next = new Node(1);
		Node Copy = start;
		//Before reversed method: 
		while(Copy!= null){
			System.out.print(Copy.Data + "->" );
			Copy =  Copy.Next;
		}
		
		Node reversedList = reverseList.Run(start);
		//after 
		System.out.println("");
		while(reversedList!= null){
			System.out.print(reversedList.Data + "->" );
			reversedList =  reversedList.Next;
		}
		
		//===============================================================
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
				
		reverseIndexedLink rev = new reverseIndexedLink();
		ListNode reversedList2 = rev.reverseBetween(node, 2, 4);
		System.out.println("");
		while(reversedList2!= null){
			System.out.print(reversedList2.val + "->" );
			reversedList2 =  reversedList2.next;
		}
		
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(2);
		node2.next.next = new ListNode(3);
		reverseIndexedLink rev1 = new reverseIndexedLink();
		
		ListNode reversedList3 = rev1.reverseBetween(node2, 1, 2);
		System.out.println("");
		while(reversedList3!= null){
			System.out.print(reversedList3.val + "->" );
			reversedList3 =  reversedList3.next;
		}		
		//==================RotatedListAmazon ==================
		System.out.println("\nRotate List");
		rotateListFromAmazon rlist = new rotateListFromAmazon();
		ListNode node3 = new ListNode(91);
		node3.next = new ListNode(34);
		node3.next.next = new ListNode(18);
		node3.next.next.next = new ListNode(83);
		node3.next.next.next.next = new ListNode(38);
		node3.next.next.next.next.next = new ListNode(82);
		node3.next.next.next.next.next.next = new ListNode(21);
		node3.next.next.next.next.next.next.next = new ListNode(69);
		
		ListNode node4 = new ListNode(1);
		ListNode rotatedList = rlist.rotateRight1(node3 , 9);
		
		System.out.println("Ready to print");
		while(rotatedList!= null){
			System.out.print(rotatedList.val + "->" );
			rotatedList =  rotatedList.next;
		}
	}
}