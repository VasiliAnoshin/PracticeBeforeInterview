
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
		
	}

}
