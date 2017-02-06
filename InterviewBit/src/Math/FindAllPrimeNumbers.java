package Math;

import java.util.ArrayList;
import java.util.List;

public class FindAllPrimeNumbers {
//Find prime numbers 
public ArrayList<Integer> sieve(int a) {
	if(a == 0){
		return null;
	}
	List<Integer> list = new ArrayList();
	boolean isTrue;
	for(int i = 2; i<= a; i++){
		isTrue = true;
		long sqr_root = (long) Math.sqrt(i);
		for(int j = 2; j <= sqr_root; j++){
			if( i%j == 0){
				isTrue=false;
				break;
			}
		}
		if(isTrue){
			list.add(i);
		}
	}	   
	    return (ArrayList)list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAllPrimeNumbers a = new FindAllPrimeNumbers();
		List b = a.sieve(100);
		for(int i = 0; i < b.size(); i++){
			
			System.out.println(b.get(i));
		}
	}

}
