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
	public int searchInRotatedArray(int[] rotatedArray, int number , int start , int end){
		int middle = (start + end) /2;
		int result = -1;
		//If number was found return this number
		if(rotatedArray[middle] == number){
			return middle;
		};
		if (start > end){
			return -1;
		}
		// Solution idea : If array was rotated that's mean that's left/right parts are rotated . 
		//If we divide the array in two halves we can see which part is rotated . 
		//if right part is sorted
		if(rotatedArray[end] > rotatedArray[middle]){
			if((number > rotatedArray[middle] ) &  (number <= rotatedArray[end])){
				result = searchInRotatedArray(rotatedArray, number, middle +1 , end);
			}else{
				result = searchInRotatedArray(rotatedArray, number,  start , middle -1);
			}
		}//if left part is sorted
		if(rotatedArray[start] < rotatedArray[middle]){
			if((number >= rotatedArray[start] ) &  (number < rotatedArray[middle])){
				result = searchInRotatedArray(rotatedArray, number, start , middle -1);
			}else{
				result = searchInRotatedArray(rotatedArray, number, middle +1 , end);
			}
		}//This part is responsible for two cases : 
		// if you get the number that doesn't exist in array in the end of recursion you will get
		// the same place in the array. Such that first two conditions does not relevant. 
		// The second case is : {2,2,2,3,4,2} - such that middle of this array is equal to 
		// the beginning and the end of the array. 
		if(rotatedArray[start] == rotatedArray[middle]){
			if(rotatedArray[middle] != rotatedArray[end]){
				result = searchInRotatedArray(rotatedArray , number , middle +1 , end);			
			}else {
				// if both halves are equals 
				result = searchInRotatedArray(rotatedArray , number , middle +1 , end);
				if(result!= -1){
					result = searchInRotatedArray(rotatedArray , number , start , middle +1);
				}else{
					return result;
				}
			}			
		}
		return result;
	}
	//10.4=========================================================================
	/* Theoretical question
	 * Given an array like Data Structure Listy which lacks a size method. It does a , however, have an elementAt(i) 
	 * that return element in index i in O(1) time. If i is beyonds the bounds of the data structure is return -1. 
	 * For this reason the data structure has only positive integers . Listy contains sorted , positive integers , find the index in which 
	 * element x occurs. 
	 */	  
	public int getSortedSearchNoSize(Listy list , int value){
		int index =1;
		while(list.elementAt(index)!= -1 & list.elementAt(index) < value){
			index*=2;
		}		
		return binarySearchModificated(list , value, index/2 ,index);
	}//It is small modification of BinarySearch . 
	public int  binarySearchModificated(Listy list , int value , int low ,int high){
		int result;
		int mid;
		while (low <= high ){
			mid = (low + high)/2; 
			if(list.elementAt(mid) == value){
				result = list.elementAt(mid);
				break;
			}else if(list.elementAt(mid) < value){
				low = mid +1;
			}else if (list.elementAt(mid) > value || list.elementAt(mid) == -1){
				high = mid -1;
			}
		}				
		return -1;
		
	}
	//10.5=========================================================================	
	// given a sorted array of strings that is interspersed with empty strings , write a method to find 
	//location of a given string . input : ball {"all", "" , "" , "" , ball , "" , "" , "car" , "" , "" ,"dad" , "" , ""} 
	 public int CheckBeforeTheSearch(String[] arr , String value){
		 if(arr == null || value == "null" || value =="" ){
			 return -1;
		 }
		 return SparseSearch(arr,value);
	 }//Iterative solution
	 public int SparseSearch(String[] arr , String value){
		 int low = 0;;
		 int high = arr.length -1;
		 int result = -1;
		 int mid = 0;		 
		 while(low <= high){
			 mid = (low + high)/2;
			 //If middle value not equal emptyString
			 if(arr[mid] != ""){
				 //If value is bigger then the middleValue set low bound to be mid + 1
				 if(arr[mid].compareTo(value)<0){
					 low = mid+1;
				 //if value is lower then the middleValue set a highBound to be mid -1  	 
				 }else if(arr[mid].compareTo(value) > 0){
					 high = mid-1;
				 }else{
					 result = mid;
					 break;
				 }
			 }else{
				 //if value is empty we will use a technique of finding the next available slot in the array . 
				 // move the counter both left and right and check if this slot is not empty . 
				 int left = mid - 1;
				 int right = mid +1;
				 while(true){
					 //Condition to check that we have no available slots in array. 
					 if(left < low && right > high){
						 return result;
					 }else if(!arr[left].isEmpty()){
						 //Assign the new low/upper bound of array
						 if(arr[left].compareTo(value)==0){
							 return left;							 
						 }else if(arr[left].compareTo(value)<0){
							 low = right;
							 break;
						 }else if(arr[left].compareTo(value)>0){
							 high = right;							 
						 }						 
					 }else if(!arr[right].isEmpty()){
						 //Assign new mid from right
						 if(arr[right].compareTo(value) == 0){
							 return right; 
						 }else if(arr[right].compareTo(value)<0){
							 low = left;
							 break;
						 }else if(arr[right].compareTo(value)>0){
							 high = left;
							 break;
						 	}					
						 }
					 right++;
					 left--;
				 }
			 }
		 }		 
		 return result;
	 }
	 
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
		//String [] arr = sort.sortAnagrams(anagramSorting);
		int[] arrayForSort = new int[]{15,16,19,20,25,1,3,4,5,7,10,14};
		//run 10.3 solution
		int resFor103 = sort.searchInRotatedArray(arrayForSort, 14 ,0,arrayForSort.length -1);
		System.out.print("\n");
		System.out.println("#10.3 : Index of entered number is : " + resFor103);
		//run 10.4 solution (array should be sorted)
		Listy resFor104 = new Listy();
		System.out.println(sort.getSortedSearchNoSize(resFor104, 10));
		//run10.5 solution 
		String str1 = "a";
		String str2 ="s";
		System.out.println("Comparing two string : str1 is a str2 is s , result is " + str1.compareTo(str2));
		System.out.println("Comparing two string : str1 is s str2 is a , result is " + str2.compareTo(str1));
		str2 ="a";
		System.out.println("Comparing two string : str1 is a str2 is a , result is " + str2.compareTo(str1));
		String[] stringArray = new String[]{"at","","","","ball","","","car","","","dad","",""};
		System.out.println(sort.CheckBeforeTheSearch(stringArray, "cra"));
		
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

