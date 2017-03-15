package Arrays;

import java.lang.reflect.Array;

public class InitializeAnArrayInO1{
	
	private int[] vec;
	private int[] mask;
	private int timeStamp;
	private int size;
	private int initValue;
	
	public InitializeAnArrayInO1(int _size){
		timeStamp = 0;
		vec  = new int[_size];
		mask = new int[_size];
		
		this.size = _size;
		this.initValue = 1;
	}
	public int getValue(int pos){
		if (pos >= size){
			return -1;
		}		
		if (mask[pos] != timeStamp){
			return vec[pos];
		}else{
			return initValue;
		}
	}	
	public void setValue(int val, int pos){
		vec[pos] = val;
		mask[pos] = timeStamp;
	}
	public void setAll(){
		this.timeStamp++;	
	}	
}