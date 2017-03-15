package Arrays;

public class GFGEqulibriumArray {
	//Not efficient solution 
	static int isExis(int[] arr){
		 int i, j;
	        int leftsum, rightsum;	 
	        /* Check for indexes one by one until an equilibrium
	           index is found */
	        for (i = 0; i < arr.length; ++i) 
	        {
	            leftsum = 0;  // initialize left sum for current index i
	            rightsum = 0; // initialize right sum for current index i
	 
	            /* get left sum */
	            for (j = 0; j < i; j++)
	                leftsum += arr[j];
	 
	            /* get right sum */
	            for (j = i + 1; j < arr.length; j++)
	                rightsum += arr[j];
	 
	            /* if leftsum and rightsum are same, then we are done */
	            if (leftsum == rightsum)
	                return i;     		
	        }
	        return -1;
	}
	//Efficient approach
	static int getEquilIndex(int[] arr){
		int leftSum = 0 , rightSum = 0;		
		//count the right side
		for(int i = 1; i< arr.length; i++){
			rightSum +=arr[i];
		}				
		for(int i= 0; i < arr.length; i++){
			if(rightSum == leftSum){
				return i;
			}else{
				leftSum += arr[i];
				rightSum-=arr[i+1];
			}						
		}
		return -1;		
	}
	//GetAllExists pointers 
	static int[] getEquilIndexes(int[] arr){
		int[] result = new int[arr.length];
		int pos = 0;
		int leftSum = 0 , rightSum = 0;		
		//count the right side
		for(int i = 1; i< arr.length; i++){
			rightSum +=arr[i];
		}				
		for(int i= 0; i < arr.length; i++){
			if(rightSum == leftSum){
				result[pos] = i;
				pos++;
				if(i != arr.length-1){
					leftSum += arr[i];
					rightSum-=arr[i+1];
				}
			}else{
				leftSum += arr[i];
				rightSum-=arr[i+1];
			}						
		}
		return result;		
	}
	
	public static void main(String[] args) {
		int[] solutionArray = {-7, 1, 5, 2, -4, 3, 0};
		System.out.println(isExis(solutionArray));
		//========================
		System.out.println(getEquilIndex(solutionArray));
		//=================================
		int[] result = getEquilIndexes(solutionArray);
		for(int i=0;i< result.length; i++){
			if(result[i]!= 0){
				System.out.println(result[i]);
			}
		}
	}
}