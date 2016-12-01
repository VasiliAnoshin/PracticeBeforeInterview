package ds;

import javafx.util.converter.NumberStringConverter;

public class MergeSort {
	int helper[];
	public int[] startMerge(int[] numbers){
		int mediana  = numbers.length/2;
		this.helper = new int[numbers.length];
		mergeSort(numbers, mediana , 0 , numbers.length-1);
		return numbers;
	}
	public int[] mergeSort(int[] numbers, int median, int low, int high){
		if(low<high)
		{
			mergeSort(numbers,high/2, low, median);
			mergeSort(numbers,(high + median)/2 , median+1,high);
			Merge(numbers , helper, low , high ,median);
		}
		return numbers;
	}
	
	public int[] Merge(int[]numbers, int[] helper, int low , int high , int mediana ){
		for(int i = low; i<=high; i++){
			helper[i] = numbers[i];
		}
		
		int leftSide = low;
		int rightSide = mediana + 1;
		int current = low;;
		
		while((leftSide<= mediana) && (rightSide <= high)){
			if(helper[leftSide] <= helper[rightSide]){
				numbers[current] = helper[leftSide];
				leftSide++;
			}else{
				numbers[current]= helper[rightSide];
				rightSide++;
			}
			current++;
		}
		
		for(int i = leftSide; i<= mediana; i++){
			numbers[current] = helper[leftSide + i];
		}
		return numbers;
	}
}
