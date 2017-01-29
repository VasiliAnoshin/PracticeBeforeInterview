package Dining;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	private Lock lock;
	
	public Chopstick(){
		lock = new ReentrantLock();
	}
	
	public void PickUp(){
		this.lock.lock();
	}
	public void PutDown(){
		this.lock.unlock();
	}
	
}
