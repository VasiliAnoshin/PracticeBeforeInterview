package ds;

public class SinkingSort {
	//SelectionSort (Comparison Based Sort) : 
	//Selection sort is also pretty good for smaller arrays of maybe 10 to 20 elements. Then it run faster then Quicksort. 
	// But QuickSort use less memory . 
	public int[] selectionSort(int[] arrOfNumbers){
		int min ;
		for(int current = 0; current < arrOfNumbers.length - 1; current++ ){
			min = current;
			for(int j = current + 1; j< arrOfNumbers.length; j++ ){
				if(arrOfNumbers[min] > arrOfNumbers[j]){
					min = j;
				}			
			}
			swap(arrOfNumbers , current , min); 
		}
		return arrOfNumbers;
	}
	//Swap operation 
	public void swap(int[]numbers, int left , int right){
		int temp = numbers[right];
        numbers[right] = numbers[left];
        numbers[left] = temp;
	}
		
	//BubbleSort Analysis : Complexity O(n^2) , the best case O(n) if the array is already sorted .	
	// number of comparison is n + n-1 + n-2 + ..... = n*(n-1)/2 arithmetic progression							
	public int[] BubbleSort(int[] arrOfNumbers){
		for(int i = arrOfNumbers.length - 1; i>0 ; i--){
			for(int j = 0 ; j < i ; j++){
				if (arrOfNumbers[j] > arrOfNumbers[j+1]){
					swap(arrOfNumbers , j , j+1); 
				}
			}
		}
		return arrOfNumbers;		
	}			
}

