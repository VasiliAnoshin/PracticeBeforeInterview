import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Chapter1ArraysAndString {
	
	/** <<<<<<<<<<<<============ QUESTION FROM INTERVIEW BIT =================================>>>>>>>>>>>>>>
	Given a non-negative number represented as an array of digits,
	add 1 to the number ( increment the number represented by the digits ).
	The digits are stored such that the most significant digit is at the head of the list.
	Example:
	If the vector has [1, 2, 3]
	the returned vector should be [1, 2, 4]
	as 123 + 1 = 124.
	 */
	public ArrayList<Integer> plusOneOne(ArrayList<Integer> A) {
		int size;
	    int carry = 1;
	    int num;
	    
	    size = A.size();
	    
	    for (int i = size - 1; i >= 0; i--) {
	        
	        num = A.get(i);
	        num += carry;
	        carry = 0;
	        
	        if (num == 10) {
	            num = 0;
	            carry = 1;
	        }
	        
	        A.set(i, num);
	        
	    }
	    
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    
	    if (carry == 1)
	        res.add(1);
	    
	    for (int x : A) {
	    	//case where is no elements in the array .
	        if (x == 0 && res.size() == 0)
	            continue;
	        res.add(x);
	    }
	    
	    return res;
	}
	//2d Approach : 
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		long result = 0;
		ArrayList<Integer> data = new ArrayList<Integer>();
		if(a == null|| a.size()==0){
			return a;
		}
		result = a.get(0);
		for(int i = 0 ; i< a.size() -1; i++){
			result = result*10 + a.get(i+1);
		}
		
		result = result + 1;
		
		long temp = 0;
		for(int i =0 ; 0 < result; i++){
			temp = result % 10;
			result = result/10;
			data.add(i, (int) temp);
		}
		
		Collections.reverse(data);
		return data;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chapter1ArraysAndString ch1 = new Chapter1ArraysAndString();
		ch1.plusOne(new ArrayList<Integer>(Arrays.asList(9, 9, 9, 9, 9 )));
        ch1.plusOne(new ArrayList<Integer>(Arrays.asList(0)));
        ch1.plusOne(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 3, 2, 1, 1, 2, 5, 9, 6, 5)));
        ch1.plusOneOne(new ArrayList<Integer>(Arrays.asList(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9)));
	}

}
