package ds;

public class Controller {

	private static int[] theArray = new int[10];
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
		ms.startMerge(engie.theArray);
		engie.printArrayInHorizontalMode();
		//=================================
		QuickSort qs = new QuickSort();
		
	}

}
