

public class Chapter10Sorting {

public void printArrayInHorizontalMode(int[] arraySize){
		
		for(int i =0; i< arraySize.length; i++){
			System.out.print("-------");			
		}
		System.out.print("\n");
		for(int i =0; i <  arraySize.length; i++){
			System.out.print("| " + i + " | ");	
		}
		System.out.print("\n");		
		for(int i=0; i<  arraySize.length; i++)
		{
			System.out.print("-------");	
		}
		System.out.print("\n");
		for(int i=0; i<  arraySize.length; i++)
		{
			System.out.print("| "+ arraySize[i] + " | ");
		}
		System.out.print("\n");
		for(int i=0;i< arraySize.length;i++){
			System.out.print("-------");}
		}
	//10.1
    //You are given two sorted arrays , A and B , where A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order .
		//Suppose that A not started from 0.
	public int[] SortedMerge(int[] A , int[] B){
		int endIndexA =0;
		//check if A & B is not empty array
		if(A == null){
			System.arraycopy(B, 0, A, 0, B.length-1);			
			return A;
		}else if (B ==null){
			return A;
		}
		//Find the end of A
		for(int i = 1 ; i < A.length; i++){
			if(A[i] == 0 ){
				endIndexA =i;
				break;
			}
		}		
		int endIndexB = B.length -1;
		int mergedArray = endIndexA + endIndexB;
		endIndexA--;
		
		while(endIndexB >= 0){
			if(B[endIndexB] >= A[endIndexA]){
				A[mergedArray] = B[endIndexB];
				endIndexB--;
			}else{
				A[mergedArray] =A[endIndexA];
				endIndexA--;
			}
			mergedArray--;
		}
		return A;
	} 
	//10.2 write a method to sort an array of strings so that all the anagrams are next to each other.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chapter10Sorting sort = new Chapter10Sorting();
		int[] A = new int[10];
		A[0] =3;
		A[1] =4;
		A[2] =5;
		A[3] =6;
		int[] B = new int[]{4,5,6,7};
		//run 10.1 solution
		//sort.printArrayInHorizontalMode(sort.SortedMerge(A, B));
		//run 10.2 solution
		
		//run 10.3 solution
		
		
	}

}
