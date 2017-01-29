package Dining;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chopstick p1 = new Chopstick();
		Chopstick p2 = new Chopstick();
		Chopstick p3 = new Chopstick();
		Chopstick p4 = new Chopstick();
		Chopstick p5 = new Chopstick();
		
		Thread f1 = new Thread(new Philosofer(p5,p1));
		Thread f2 = new Thread(new Philosofer(p1,p2));
		Thread f3 = new Thread(new Philosofer(p2,p3));
		Thread f4 = new Thread(new Philosofer(p3,p4));
		Thread f5 = new Thread(new Philosofer(p4,p5));
		
		//Start dinning		
		f2.start();
		f3.start();
		f1.start();	
		f4.start();
		f5.start();
		
		try {
			f1.join();
			f2.join();
			f3.join();
			f4.join();
			f5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("There was interruptions in thread");
			e.printStackTrace();
		}
				
		System.out.println("The Dinner is over : ");
		
	}

}
