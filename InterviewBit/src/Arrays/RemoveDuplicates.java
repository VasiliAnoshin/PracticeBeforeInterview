package Arrays;

import java.util.HashSet;
import java.util.Iterator;

public class RemoveDuplicates {

	public static int[] removeDuplicates(int[] arr){
	    HashSet<Integer> set = new HashSet<>();
	    final int len = arr.length;
	    for(int i = 0; i < arr.length; i++){
	        set.add(arr[i]);
	    }

	    int[] whitelist = new int[set.size()];
	    int i = 0;
	    for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
	        whitelist[i++] = it.next();
	    }
	    return whitelist;
	}
	
	public static void main(String[] args) {
		int[] arr = removeDuplicates(new int[] {1,2,3,4,4,4,4,4});
		for(int i =0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}

}
