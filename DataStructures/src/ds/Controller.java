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
	}

}
