package Arrays;

public class initArrayinO1Main {

	public static void main(String[] args) {
		// Clear array with 0 
		SetAllVlauesToBeZerobyO1 ar = new SetAllVlauesToBeZerobyO1(4);
		ar.setValue(1,0);
		ar.setValue(2,1);
		ar.setValue(3,2);
		ar.setValue(4,3);
		
		ar.setAllBeZero();
		
		System.out.println(ar.getValue(1));		
		ar.setValue(5,1);
		System.out.println(ar.getValue(1));
		//=================================Start Array with 1 =======================
		InitializeAnArrayInO1 arr = new InitializeAnArrayInO1(4);
		arr.setValue(10, 0);
		arr.setValue(11, 0);
		arr.setValue(12, 0);
		arr.setValue(13, 0);
		
		arr.setAllValuesBe1();
		System.out.println(arr.getValue(1));	
	}
}
