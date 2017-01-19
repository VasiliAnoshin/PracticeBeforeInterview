
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
public class Thread1 {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	}
}

