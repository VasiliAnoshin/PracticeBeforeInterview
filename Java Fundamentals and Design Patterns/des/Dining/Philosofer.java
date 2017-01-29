package Dining;

public class Philosofer implements Runnable{
	private int bites = 10;
	private Chopstick left , right;
	static int counter = 1;
	public Object lock = new Object();
	
	public Philosofer(Chopstick left , Chopstick right){
		this.left = left;		
		this.right = right;
	}
	public void eat(){
		if (PickUp()){
			Chew();
			PutDown();
		}
	}	
	public boolean PickUp(){
		//attempt to pick up
		if (!left.pickUp()){
			return false;
		}
		if(!right.pickUp()){
			left.PutDown();			
			return false;
		}
		return true;
	}
	public void PutDown(){
		right.PutDown();
		left.PutDown();		
	}
	//Do nothing (Jevat) .
	public void Chew(){
		synchronized(lock){
			System.out.println("Juyu" + counter++);
			}
		} 

	@Override
	public void run() {
		for(int i =0; i< bites; i++){
			eat();
		}		
	}
}
