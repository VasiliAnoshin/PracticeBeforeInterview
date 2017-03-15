import java.util.Random;

public class RandomArrayShuffle {
	
	static void shuffleArray(int[] ar){
	Random rand = new Random();
	int a ;
	for (int i = ar.length - 1; i > 0; i--){
	      int index = rand.nextInt(i + 1);
	      // Simple swap
	      a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	}
	
	public static void main(String[] args) {
		// Fisher–Yates shuffle:
		int[] solutionArray = {1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1};
		shuffleArray(solutionArray);
		for (int i = 0; i < solutionArray.length; i++){
				System.out.print(solutionArray[i] + " ");
		}
		System.out.println();
	}

}
