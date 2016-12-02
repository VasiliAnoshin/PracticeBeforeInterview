package ds;
//Mergesort sorts in worst case in O(n log n) time. 
//Due to the required copying of the collection Mergesort is in the average case slower then Quicksort.

public class MergeSort {	
	//Help array
	int helper[];
	public int[] startMerge(int[] inputArray){		
		this.helper = new int[inputArray.length];
		mergeSort(inputArray, 0 , inputArray.length-1);
		return inputArray;
	}
	public void mergeSort(int[] numbers, int low, int high){
		//Recursion condition
		if(low<high)
		{
			int middle = (low + high)/2;
			//Sort the left Side
			mergeSort(numbers,low,middle);
			//Sort the right Side
			mergeSort(numbers,middle+1,high);
			//Merge them
			Merge(numbers , helper, low , high ,middle);
		}
	}	
	public void Merge(int[]inputArray, int[] helper, int low , int high , int middle ){
		//Copy both halfes into the helper array
		for(int i = low; i<=high; i++){
			helper[i] = inputArray[i];
		}
		//Create 3 pointers , one for leftSide the second for the rightSide and the current for inputArray
		int leftSide = low;
		int rightSide = middle + 1;
		int current = low;;
		//Iterate through helper array. Compare the left and right half. Copying back the smaller element from 
		//the two halves into the original array.
		while((leftSide<= middle) && (rightSide <= high)){
			if(helper[leftSide] <= helper[rightSide]){ // if left element is smaller then right
				inputArray[current] = helper[leftSide];
				leftSide++;
			}else{
				//if right element is smaller than left element
				inputArray[current]= helper[rightSide];
				rightSide++;
			}
			current++;
		}
		//Copy the rest of the left side of the array into target array . MergeSort stable algorihtm and in the final stage of recursion get two sorted halves .
		//If the right half is bigger it's already original array . 		
		int remaining = middle - leftSide;
		for(int i = 0; i<= remaining; i++){
			inputArray[current + i] = helper[leftSide + i];
		}
	}
}
