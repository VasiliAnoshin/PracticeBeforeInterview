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
		//==
	}

}
