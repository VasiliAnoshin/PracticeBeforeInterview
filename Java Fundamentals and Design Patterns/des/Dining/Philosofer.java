package Dining;

public class Philosofer implements Runnable{
	private int bites = 10;
	private Chopstick left , right;
	static int counter = 1;
	
	public Philosofer(Chopstick left , Chopstick right){
		this.left = left;		
		this.right = right;
	}
	public void eat(){
		PickUp();
		PutDown();
	}	
	public void PickUp(){
		left.PickUp();
		Chew();
		right.PickUp();
	}
	public void PutDown(){
		right.PutDown();
		left.PutDown();		
	}
	//Do nothing (Jevat) .
	public void Chew(){
		System.out.println("Juyu" + counter++);
	} 

	@Override
	public void run() {
		for(int i =0; i< bites; i++){
			eat();
		}		
	}
}
