package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *  Given an array of integers, sort the array into a wave like array and return it, 
 *  In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 *  Example:
 *  Given [1, 2, 3, 4]
 *	One possible answer : [2, 1, 4, 3]
 *	Another possible answer : [4, 1, 3, 2]
 *	NOTE : If there are multiple answers possible, return the one thats lexicographically smallest. 
 *	So, in example case, you will return [2, 1, 4, 3] 
 */
public class VaweArray {
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
		Integer[] bar = a.toArray(new Integer[a.size()]);		
		Arrays.sort(bar);
		Integer temp;
		
		for(int i =1; i < bar.length; i++){
			if(i%2==1){
				temp = bar[i];
				bar[i] = bar[i-1];
				bar[i-1] = temp;
			}
			if(i%2==0 && bar[i+1] != null){
				temp = bar[i];
				bar[i] = bar[i+1];
				bar[i+1] = temp;
				i++;
			}
		}		
		return new ArrayList<Integer>(Arrays.asList(bar));
	}
	
}
