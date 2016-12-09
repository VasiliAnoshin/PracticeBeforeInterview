import java.util.*;


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
	//==================================================================================================
	//10.1
    //You are given two sorted arrays , A and B , where A has a large enough buffer at the end to hold B.
	//Write a method to merge B into A in sorted order. Suppose that A not started from 0.
	public int[] SortedMerge(int[] A , int[] B){
		int endIndexA =0;
		//check if A & B is not empty array
		if(A == null){
			System.arraycopy(B, 0, A, 0, B.length-1);			
			return A;
		}else if (B == null){
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
	//========================================================================================================	
	//10.2 another implementation: 
	public String[] sortAnagrams(String[] anagramsArray){
		HashMap<String,List<String>> dictionary = new HashMap<String,List<String>>();
		//Group words by anagram . The same words have the same anagrams but in the different order.  
		for(String word : anagramsArray){
			String key = sortChars(word);
			//For each key create bucket (for this purpose will choose LinkedList). 
			if(dictionary.get(key)==null){
				List<String> node = new LinkedList<String>();
				node.add(word);				
				dictionary.put(key, node);
			}else{
				dictionary.get(key).add(word);
			}
		}
	//Iterate through the same keys and put the same anagrams one after other 
		List<String> tempList = new ArrayList<String>();
		//Iterator give possibility to iterate over the linList elements 
		for (Iterator<String> it = dictionary.keySet().iterator(); it.hasNext(); ){
			//GEt LinkedList from the bucket
			List<String> ll = (LinkedList<String>) dictionary.get(it.next());
			for( int j = 0; j < ll.size(); j++){
				tempList.add(ll.get(j));
			}
		}
		//prepare returned array
		for(int cur = 0; cur < tempList.size(); cur++){
			anagramsArray[cur] = tempList.get(cur);
		}
		return anagramsArray;		
	}
	//Sort the word according to alphabet .
	public String sortChars(String str){
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
//=================================================================================	
	//10.3 given sorted array of n integers that has been rotated an unknown number of times, write code to find 
	//an element in the array. Searching an Element in a Rotated Sorted Array
	
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
		sort.printArrayInHorizontalMode(sort.SortedMerge(A, B));
		//run 10.2 solution
		String[] anagramSorting = new String[]{"aba","abb","acc","cca","aab"};
		Arrays.sort(anagramSorting,new AnagramComparator());
		//run another form of 10.2 solution 
		String [] arr = sort.sortAnagrams(anagramSorting);
		
		//run 10.3 solution
	
	}	
}
//10.2 write a method to sort an array of strings so that all the anagrams are next to each other. The idea is to turn each of them to be an array of chars and then sort and compare them. 	
//For  this purpose will use comparator that will compare two strings and set them one after the other . 
class AnagramComparator implements Comparator<String>{
	public String sortChars(String str){
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	public int compare(String s1 , String s2){
		return sortChars(s1).compareTo(sortChars(s2));
	}
}
