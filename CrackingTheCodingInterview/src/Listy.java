
public class Listy {

	private int[] elementsArray;
	private int curPosition = 0;
	public Listy(){
		elementsArray = new int[100];
		initializeArray();
		//generateRandomArray();
	}
	public void addElement(int value){
		elementsArray[curPosition] = value;
		curPosition++;		
	}
	private void initializeArray(){
		for(int i =0; i < elementsArray.length/2; i++){
			elementsArray[i] = i;
		}
		for(int i =elementsArray.length/2; i < elementsArray.length; i++){
			elementsArray[i] = -1;
		}
	}
	public int elementAt(int index){
		return elementsArray[index];
	}
	
	private void generateRandomArray()
	{
		for(int i = 0;i < elementsArray.length/2; i++)
		{
			elementsArray[i] = (int)(Math.random()*(100)) + 0;
		}
	}
}
