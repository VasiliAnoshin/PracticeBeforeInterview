package Dining;

class Philosofer extends Thread{
	private int bites = 10;
	private Chopstick left , right;
	
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
		left.PutDown();
		right.PutDown();
	}
	//Do nothing (Jevat) .
	public void Chew(){
		
	} 
	//public void run(){
	//	for(int i =0; i< bites; i++){
	//		eat();
	//	}
	//}
}
