package ds;

public class BinarySearch {
	
	public int RecursicveApproach(int[] arr ,int value , int start , int end ){
		int result = -1;
		//Condition for exit from recursion 
		if (start > end ){
			return -1;
		}
		int mid = (start + end)/2; 
		if(arr[mid] == (value)){
			return mid;
		}else if(arr[mid]>value){
			result = RecursicveApproach(arr,value,start,mid -1);
		}else if(arr[mid] < value){
			result = RecursicveApproach(arr,value,mid+1,end);
		}
		return result;
	}
	public int IterativeApproach(int[] arr , int value){
		int start = 0;
		int end = arr.length-1;
		int mid ;
		int result = -1;
		//Condition to check for exit from the loop
		while(start <= end){
			mid = (start+ end)/2;
			//check if the value is great then the middle if it is set high value to middle-1
			if(arr[mid] > value){
				end = mid - 1;
			//set start value to be mid + 1
			}else if(arr[mid] < value){
				start = mid +1;			
			}else{
				result = mid;
				break;
			}
		}
		return result;
	}	
}
