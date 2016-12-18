package ds;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
     private static final int DEFAULT_BUCKET_SIZE = 5;	
//Worst Case : O(n^2)       Space: O(n+k)
//BestCase   :	O(n+k) = O(n)
//AverageCase: O(n+k)
	
	//Fast example without sorting each bucket . We choose the same number of buckets as numbers .
	 public int[] BucketSort(int[] items)
     {
		 //check that there exist elements inside the list
		 if(items == null || items.length <2){
			 return items;
		 }
		 //Find elements with min and max values
		 int maxValue = items[0];
         int minValue = items[0];

         for (int i = 1; i < items.length; i++)
         {
             if (items[i] > maxValue)
                 maxValue = items[i];

             if (items[i] < minValue)
                 minValue = items[i];
         }
		 //create temporary Array of buckets in size that's enough for all posible values that represented in interval between min and max.
         //For each element we have bucket Lis<int> .when we fill such array elements replaced according to their value from low to high .
         int bucketCount = maxValue - minValue + 1;
         List<List<Integer>> bucket = new ArrayList<List<Integer>>(bucketCount);

         for (int i = 0; i < bucketCount; i++)
         {
        	 
             bucket.add(new ArrayList<Integer>());
         }
         // Distribute input array values into buckets
         for (int i = 0; i < items.length; i++) {
             bucket.get(items[i] - minValue).add(items[i]);
         }
         //Place them back into Array
         int position = 0;
         for (int i = 0; i < bucket.size(); i++)
         {
             if (bucket.get(i).size() > 0)
             {
                 for (int j = 0; j < bucket.get(i).size(); j++)
                 {
                     items[position] = bucket.get(i).get(j);
                     position++;
                 }
             }
         }
		 return items;
     }
	  //SparseArraySorting	second version   
	  public static void SparseSort(int[] array) {
		  sort(array, DEFAULT_BUCKET_SIZE);
	  }

	  public static void sort(int[] array, int bucketSize) {
	  if (array.length == 0) {
		  return;
	    }

	   // Determine minimum and maximum values
	   Integer minValue = array[0];
	   Integer maxValue = array[0];
	   for (int i = 1; i < array.length; i++) {
		    if (array[i] < minValue) {
		         minValue = array[i];
		    } else if (array[i] > maxValue) {
		          maxValue = array[i];
		    }
		}
		// Initialise buckets
		int bucketCount = (maxValue - minValue) / bucketSize + 1;
		List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
		for (int i = 0; i < bucketCount; i++) {
		     buckets.add(new ArrayList<Integer>());
		 }

		 // Distribute input array values into buckets
		 for (int i = 0; i < array.length; i++) {
		      buckets.get((array[i] - minValue) / bucketSize).add(array[i]);
		  }

		  // Sort buckets and place back into input array
		  int currentIndex = 0;
		  for (int i = 0; i < buckets.size(); i++) {
		       Integer[] bucketArray = new Integer[buckets.get(i).size()];
		       bucketArray = buckets.get(i).toArray(bucketArray);
		       java.util.Arrays.sort(bucketArray);
		       for (int j = 0; j < bucketArray.length; j++) {
		           array[currentIndex++] = bucketArray[j];
		        }
		    }
		}
		
}
