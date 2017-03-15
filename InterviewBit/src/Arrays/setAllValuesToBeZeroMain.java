package Arrays;

public class setAllValuesToBeZeroMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetAllVlauesToBeZerobyO1 ar = new SetAllVlauesToBeZerobyO1(4);
		ar.setValue(1,0);
		ar.setValue(2,1);
		ar.setValue(3,2);
		ar.setValue(4,3);
		
		ar.setAllBeZero();
		
		System.out.println(ar.getValue(1));		
		ar.setValue(5,1);
		System.out.println(ar.getValue(1));

	}

}
