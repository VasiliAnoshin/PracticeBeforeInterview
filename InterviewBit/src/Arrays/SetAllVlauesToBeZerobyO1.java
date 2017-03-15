package Arrays;

public class SetAllVlauesToBeZerobyO1 {
	
	int[] value;
	int[] mask;
	int current;
	int pos;
	private int initValue;
	
	public SetAllVlauesToBeZerobyO1(int size){
		value = new int[size];
		mask  = new int[size];
		current = 0;
		initValue = 0;
	}
	
	public boolean setValue(int val){
		if(pos >= this.value.length){
			return false;
		}
		this.value[pos] = val;
		this.mask[pos]  = current;
		pos++;
		return true;
	}
				
	public int getValue(int pos){
		if(pos >= this.value.length){
			return -1;
		}
		//Any default value for clean. 
		if(mask[pos] != current){
			return initValue;
		}
		return this.value[pos];
	}
	
	public void setAllBeZero(){
		current++;
	}
}
