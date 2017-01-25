package ThreadsSyncCode;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	private int count =0;
	/**
	  This class give posibility to lock the object several times . And there is a problem when 
	  for example you you get exeption in increment variable. Thread does't reach unlock stage. the solution is 
	  to set threads in try finally . 
	 */
	private Lock lock = new ReentrantLock();
	//Condition set condition on lock 
	private Condition cond = lock.newCondition();
	
	private void increment(){
		for(int i=0; i<10000; i++){
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException{				
		lock.lock();
		System.out.println("Waiting ...");
		//It set await for lock object as every object has monitor lock. 
		//And wit untill cond return signal that 1st thread can continue.
		cond.await();
		System.out.println("Woken Up");
		
		try{
			increment();
		}finally{
			lock.unlock();
		}
	}
	
	public void secondThread() throws InterruptedException{
		Thread.sleep(1000);
		lock.lock();
		
		System.out.println("Press the returned key ...");
		new Scanner(System.in).nextLine();
		System.out.println("Got returned key");
		cond.signal();
		try{
			increment();
		}finally{
			lock.unlock();
		}			
	}	
	public void finished(){
		System.out.println("Count is : " + count);
	}	
}
