package Arrays;

import java.lang.reflect.Array;

public class InitializeAnArrayInO1{
	
	private int[] vec;
	private int[] from;
	private int[] to; 
	private int top;
	private int size;
	private int initValue;
	
	public InitializeAnArrayInO1(int _size){
		top = 0;
		vec  = new int[_size];
		from = new int[_size];
		to 	 = new int[_size];	
		this.size = _size;
		this.initValue = 0;
	}
	public int getValue(int pos){
		if (pos > size){
			return -1;
		}		
		if (from[pos] < top && to[from[pos]] == pos){
			return vec[pos];
		}else{
			return initValue;
		}
	}
	
	//public int setValue(int val){
	//	vec[top] = val;
	//	from[top] = top;
//		to[from[top]] = top;
//	}
}
