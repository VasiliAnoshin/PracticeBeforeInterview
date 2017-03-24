package Arrays;

import java.util.ArrayList;
import java.util.List;
	
  class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }

/**
 *  Case 1: It is smaller than all the intervals in the list
 *  Case 2: It is greater than all the intervals in the list
 *  Case 3: It overlaps some intervals in the list 
 *  @author anoshin45
 *
 */
public class MergeIntervals {
	 public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

	        ArrayList<Interval> result = new ArrayList<Interval>();
	 
	        for(Interval interval: intervals){
	            if(interval.end < newInterval.start){
	                result.add(interval);
	            }else if(interval.start > newInterval.end){
	                result.add(newInterval);
	                newInterval = interval;        
	            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
	                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
	            }
	        }
	 
	        result.add(newInterval); 
	 
	        return result;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval inter = new Interval(1,2);
		Interval inter1 = new Interval(3,5); 
		Interval inter2 = new Interval(6,7); 
		Interval inter3 = new Interval(8,10); 
		Interval inter4 = new Interval(12,16);
		Interval inter5 = new Interval(4,9);
		List<Interval> intervalList = new ArrayList<Interval>();
		MergeIntervals merg = new MergeIntervals();
		intervalList.add(inter);
		intervalList.add(inter1);
		intervalList.add(inter2);
		intervalList.add(inter3);
		intervalList.add(inter4);		
		ArrayList<Interval> arr= merg.insert((ArrayList<Interval>) intervalList, inter5);
		for(int i =0 ; i < arr.size(); i++){
			System.out.println("[" +arr.get(i).start + "," + arr.get(i).end +"] ,");
		}
		
		ArrayList<Interval> arr1= merg.insert(new ArrayList(), new Interval(1,1));
		for(int i =0 ; i < arr1.size(); i++){
			System.out.println("[" +arr1.get(i).start + "," + arr1.get(i).end +"] ,");
		}
		
		List<Interval> intervalList1 = new ArrayList<Interval>();
		intervalList1.add(new Interval(3,5));
		intervalList1.add(new Interval(8,10));
		ArrayList<Interval> arr2= merg.insert((ArrayList<Interval>) intervalList1, new Interval(1,12));
		for(int i =0 ; i < arr2.size(); i++){
			System.out.println("[" +arr2.get(i).start + "," + arr2.get(i).end +"] ,");
		}
	}

}
