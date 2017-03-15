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
	
	public static void main(String[] args) {
		int[] solutionArray = {-7, 1, 5, 2, -4, 3, 0};
		System.out.println(isExis(solutionArray));
	}
}
