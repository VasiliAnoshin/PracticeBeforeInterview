package Dining;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Chopstick p1 = new Chopstick();
		Chopstick p2 = new Chopstick();
		Chopstick p3 = new Chopstick();
		Chopstick p4 = new Chopstick();
		Chopstick p5 = new Chopstick();
		
		Philosofer f1 = new Philosofer(p5,p1);
		Philosofer f2 = new Philosofer(p1,p2);
		Philosofer f3 = new Philosofer(p2,p3);
		Philosofer f4 = new Philosofer(p3,p4);
		Philosofer f5 = new Philosofer(p4,p5);
		
		//Start dinning		
		f2.start();
		f3.start();
		f1.start();
		f4.start();
		f5.start();
		
		f1.join();
		f2.join();
		f3.join();
		f4.join();
		f5.join();
		
		System.out.println("The Dinner is over : ");
		
	}

}
