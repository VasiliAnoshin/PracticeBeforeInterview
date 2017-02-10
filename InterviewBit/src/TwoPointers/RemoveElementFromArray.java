package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Remove Element:
 *	Given an array and a value, remove all the instances of that value in the array. 
 *	Also return the number of elements left in the array after the operation.
 *	It does not matter what is left beyond the expected length.
 * @author anoshin45
 *
 */

public class RemoveElementFromArray {
	public int removeElement(ArrayList<Integer> a, int b) {
		a.removeAll(Arrays.asList(b));
		return a.size();			   
	}
}
