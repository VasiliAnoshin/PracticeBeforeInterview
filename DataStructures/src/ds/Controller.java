package ds;

public class Controller {

	public static int[] theArray = new int[10];
	private int arraySize = 10;
	
	public void generateRandomArray()
	{
		for(int i = 0;i < arraySize; i++)
		{
			theArray[i] = (int)(Math.random()*(100)) + 0;
		}
	}
	
	public void printArrayInVerticalMode(){
		System.out.println("----------");
		for(int i =0; i< arraySize; i++){			
			System.out.print("| " + i + " | ");
			System.out.println(theArray[i] + " |");
			System.out.println("----------");
		}
	}
	public void printArrayInHorizontalMode(){
		
		for(int i =0; i< arraySize; i++){
			System.out.print("-------");			
		}
		System.out.print("\n");
		for(int i =0; i < arraySize; i++){
			System.out.print("| " + i + "  | ");	
		}
		System.out.print("\n");		
		for(int i=0; i< arraySize; i++)
		{
			System.out.print("-------");	
		}
		System.out.print("\n");
		for(int i=0; i< arraySize; i++)
		{
			System.out.print("| "+ theArray[i] + " | ");
		}
		System.out.print("\n");
		for(int i=0;i<arraySize;i++){
			System.out.print("-------");
		}
		System.out.print("\n");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller engie = new Controller();
		engie.generateRandomArray();        
		engie.printArrayInHorizontalMode();	
		MergeSort ms = new MergeSort();     
		//=================================
		engie.printArrayInHorizontalMode();	
		ms.startMerge(Controller.theArray);
		engie.printArrayInHorizontalMode();
		//=================================
		QuickSort qs = new QuickSort();
		int arr[] = new int[]{7,5,6,4,67,68};
		int arr2[] = new int[]{5,7,10,9,8,6};
		qs.quickSort(arr2,0,arr2.length-1);
		//==================================
		System.out.println("SelectionSort , start sorting : ");
		SinkingSort sort = new SinkingSort();
		engie.generateRandomArray();        		
		sort.selectionSort(Controller.theArray);
		engie.printArrayInHorizontalMode();
		//==================================
		System.out.println("Bubblesort , start sorting : ");
		engie.generateRandomArray();        		
		sort.BubbleSort(Controller.theArray);
		engie.printArrayInHorizontalMode();
		//==================================================
		System.out.println("BinarySearch , start sorting : ");
		BinarySearch bs = new BinarySearch();
		int[] bsArray = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		System.out.println(bs.RecursicveApproach(bsArray, 16, 0, bsArray.length-1));
		System.out.println("BinarySearch (iterative approach), start sorting : ");
		System.out.println(bs .IterativeApproach(bsArray, 0));
		//====================================================
		System.out.println("BucketSort , start sorting : ");
		BucketSort array = new BucketSort();
		bsArray = new int[]{5,6,7,8,3,4,9,3,4,67,5,33,12,44};
		//array.BucketSort(bsArray);
		array.SparseSort(bsArray);
		//=====================================================
		LinkedListT linkList = new LinkedListT();
		linkList.insert("Golcman");
		linkList.insert("Vasili");
		linkList.insert("Salomon");
		linkList.insert("Daniel");
		linkList.display();
		linkList.insertNodeAtIndex("Yoni", 1);
		linkList.display();
		linkList.insertNodeAtIndex("Stanislav", 5);
		linkList.display();
		linkList.insertNodeAtIndex("Iehezkel", 8);
		linkList.display();
		linkList.deleteAtTheEnd();
		linkList.display();
		linkList.deleteNodeAtBegin();
		linkList.display();
		System.out.println();
		System.out.println(linkList.SerchNodeIndex("Golcman"));
		//=============================BST============================
		BinarySearchTree bst = new 	BinarySearchTree();
		bst.insert(9);
		bst.insert(17);
		bst.insert(5);
		bst.insert(7);
		bst.insert(4);
		bst.insert(19);
		bst.insert(10);
		bst.insert(10); //here should print false 
		bst.display(bst.root);
		//Check if this element exist in the BST
		System.out.println("\n==========================");
		System.out.println("Check if element exist in the tree , return -1 if it does't : " + bst.find(17));
		bst.delete(20);
		bst.delete(10);
		bst.delete(17);
		bst.delete(7);
		bst.delete(5);
		bst.delete(4);
		bst.delete(9);
		bst.insert(1);
		bst.delete(1);
		bst.display(bst.root);
	}

}
