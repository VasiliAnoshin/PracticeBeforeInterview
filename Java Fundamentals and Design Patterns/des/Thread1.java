import java.util.Scanner;

//First way to start thread in Java is extend Thread
class Runner extends Thread{

	public void run(){
	
		for (int i =0 ; i < 15 ; i++){
			System.out.println("Hello " + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
								
		}		
	}
}
// The second way is to impelent Runnable interface 
class Runner2 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i =0 ; i < 15 ; i++){
			System.out.println("Hello " + i);
			
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}								
		}				
	}
	
}
/**
 * #2 Volatile example . There is run method inside Processor that run forever on boolean running variable .
 * The main thread execute this code and creating new thread p1 from this point they started to run asyncronically.
 * If variable "running" not included volatile word there is exist some case when 
 * p1 make copy of this var and run forever . 
 */

class Processor extends Thread{
	private volatile boolean running  = true;
	
	public void shutdown(){
		this.running = false;
	}
	public void run(){
		while (running){
			System.out.println("Hello worlds");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class Thread1 {	
	public static void main(String[] args) {
		//Example shows two different ways to create threads , 1) by extending the thread 2)by implement Runnable interface 
		
		Runner runner1 = new Runner();
		Runner runner2 = new Runner();
		
		runner1.start();
		runner2.start();
		
		Thread t1 = new Thread(new Runner2());
		Thread t2 = new Thread(new Runner2());		
		t1.start();
		t2.start();
		
		/**
		 * The third way to implement Thread running is 
		 */
		Thread t3 = new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i =0 ; i < 15 ; i++){
					System.out.println("Hello " + i);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}										
				}				
			}						
		});		
		t3.start();		
		Processor p1 = new Processor();
		p1.start();
		//2 Volataile example , please press "Enter" to stop execution of the program . 
		System.out.println("Please enter some value ");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();		
		p1.shutdown();
	}
}

