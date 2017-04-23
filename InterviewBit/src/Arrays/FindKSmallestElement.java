package Arrays;

public class FindKSmallestElement {
	 public static int findKthLargest(int[] nums, int k) {
	        int start = 0, 
	        end = nums.length - 1, 
	        index = nums.length - k;
	        
	        while (start < end) {
	            int pivot = partion(nums, start, end);
	            if (pivot < index){ 
	            	start = pivot + 1;
	            }
	            else if (pivot > index) 
	            	end = pivot - 1;
	            else
	            	return nums[pivot];
	        }
	        return nums[start];
	    }
	    
	    private static int partion(int[] nums, int start, int end) {
	        int pivot = start, temp;
	        while (start <= end) {
	            while (start <= end && nums[start] <= nums[pivot]){
	            	start++;
	            }
	            while (start <= end && nums[end] > nums[pivot]) {
	            	end--;
	            }
	            if (start > end) 
	            	break;
	            temp = nums[start];
	            nums[start] = nums[end];
	            nums[end] = temp;
	        }
	        temp = nums[end];
	        nums[end] = nums[pivot];
	        nums[pivot] = temp;
	        return end;
	    }
	    
	    public static int findKthSmallest(int[] nums, int k) {
	        int start = 0, 
	        end = nums.length - 1, 
	        index = k;
	        
	        while (start < end) {
	            int pivot = partion(nums, start, end);
	            if (pivot < index){ 
	            	start = pivot + 1;
	            }
	            else if (pivot > index) 
	            	end = pivot - 1;
	            else
	            	return nums[pivot];
	        }
	        return nums[start];
	    }
	public static void main(String[] args) {
		int[] arr = new int[]{3, 4, 7, 9, 12, 2, 1, 120};
		findKthLargest(arr,3);		
		System.out.println(findKthSmallest(arr,5));
	}
	
}
