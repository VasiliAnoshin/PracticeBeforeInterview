package ds;

public class QuickSort {
//Test for Git workingFlow via Mac
	
	void quickSort(int[] numbers, int left , int right){
		int index = partition(numbers, left,right);		
		if(left < index-1){
			//Sort LeftHalf
			quickSort(numbers,left,index-1);			
		}
		if(index < right){
			quickSort(numbers,index, right);
		}
	}
	
	public int partition(int[] arr, int left, int right){
		int pivot = arr[(left + right)/2];
		while(left<=right){
			//find element on left that should be on right
			while(arr[left]<pivot){
				left++;
			}
				while(arr[right]>pivot){
					right--;
				}
				//Swap element, and move left and right indices
				if(left <= right){
					swap(arr,left,right);
					left++;
					right--;
				}
		}
				
		return left;
	}
	
	public void swap(int[]numbers, int left , int right){
		 int temp = numbers[left];
         numbers[left] = numbers[right];
         numbers[right] = temp;
	}
	
}
