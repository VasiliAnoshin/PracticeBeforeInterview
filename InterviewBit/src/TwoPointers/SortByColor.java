package TwoPointers;
/**
 * Given an array with n objects colored red, white or blue, 
   sort them so that objects of the same color are adjacent, 
   with the colors in the order red, white and blue.
   Here, we will use the integers 0, 1, and 2 to represent the color red,
   white, and blue respectively.
   Note: Using library sort function is not allowed.
   Example :
   Input : [0 1 2 0 1 2]
   Modify array so that it becomes : [0 0 1 1 2 2]
 */
import java.util.ArrayList;


public class SortByColor {
	public void sortColors(ArrayList<Integer> a) {
		if(a.size()==0){
			return;
		}
		int white = 0;
		int red = (a.size())-1;
		int mid = 0;
		int temp = 0;
		
		while(mid <= red){
			switch(a.get(mid)){
				case 0:
				{
					temp = a.get(white);
					a.set(white, a.get(mid));
					a.set(mid, temp);
					white++;
					mid++;
					break;
				}
				case 1:
				{
					mid++;
					break;
				}
				case 2:
				{
					temp = a.get(mid);
					a.set(mid, a.get(red));
					a.set(red , temp);
					red--;					
					break;
				}
			}
		}
		
		
	}
	
public void sortColors2(ArrayList<Integer> A) {
	    
	    int white = 0;
	    int red = A.size() - 1;
	    
	    for (int mid = 0; mid <= red;) {
	        if (A.get(mid) == 0) {
	            int temp = A.get(white);
	            A.set(white, 0);
	            A.set(mid, temp);
	            white++;
	            mid++;
	        } else if (A.get(mid) == 2) {
	            int temp = A.get(red);
	            A.set(red, 2);
	            A.set(mid, temp);
	            red--;
	        } else {
	        	mid++;
	        }
	    }
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortByColor sort = new SortByColor();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(0);
		temp.add(1);
		temp.add(2);
		temp.add(0);
		temp.add(1);
		temp.add(2);
		sort.sortColors(temp);
		for(int i =0; i < temp.size();i++){
			System.out.println(temp.get(i));
		}

	}

}
