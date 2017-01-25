package ThreadsSyncCode.ThreadLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**The problem in this code that without syncronized method both StageOne and StageTwo increment
   the variable but exist racecondition and both lists don't include 2000 elements. 
   But the still a problem : when we set sync method on both StageOne and StageTwo each time when one 
   of them take control on object (every object in java has monitor lock )  take controle on whole object .
   To prevent this we create two variables that lock1 and lock2 separately that preventing to enter the stricted area .
**/
//START FROM APP class
public class Worker {
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	private Random random = new Random();
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	public void stageOne(){
		//its a good practice to lock the other object and not a list . Beacuse when we modify a list itself
		//we can point to another object by new and lock can be worthless .
		synchronized(lock1){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}
	public void stageTwo(){
		synchronized(lock2){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}	
	public void process(){
		for(int i =0; i < 1000; i++){
			stageOne();
			stageTwo();
		}
	}
	public void main() {
		// TODO Auto-generated method stub
		System.out.println("Starting ...");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				process();				
			}			
		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				process();				
			}			
		});
		t1.start();
		t2.start();
				
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Time take:  " + (end - start));
		System.out.println("List1: "+ list1.size() + ";" + "List2: " +list2.size());
	}

}
