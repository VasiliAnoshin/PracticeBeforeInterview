package ThreadsSyncCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	private int id;
	
	public Processor(int id){
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting: " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
		System.out.println("Completed: " + id);
		
	}
}

public class ThreadPoolExample {

	public static void main(String[] args) {
		//Like number of workres in the factory - 2 workers
		//executing 3 threads each time .  
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for(int i =0; i < 5; i++ ){
			executor.submit(new Processor(i));
		}
		//Initiates an orderly shutdown in which previously submitted tasks are executed,
		//but no new tasks will be accepted.
		executor.shutdown();
		System.out.println("All tasks submitted.");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed.");
		}
}
