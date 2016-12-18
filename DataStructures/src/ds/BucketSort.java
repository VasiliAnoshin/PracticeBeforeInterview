package ds;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
//Worst Case : O(n^2)       Space: O(n+k)
//BestCase   :	O(n+k)
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
	
}
