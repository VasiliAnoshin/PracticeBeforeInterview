
public class SingleDoubleChecking {
	/*keyword volatile is used to mark a Java variables as being 
	  stored in main memory . Every read of volatile variable will be read from 
	  computer main memory and not from CPU cache. It mean also that every write 
	  will be in main memory and not in the CPU cache .
	  
	  The Java volatile keyword guarantees visibility of changes to variables across threads. 
	  This may sound a bit abstract.
	  In a multithreaded application where the threads operate on non-volatile variables, 
	  each thread may copy variables from main memory into a CPU cache while working on them, 
	  for performance reasons.
      If your computer contains more than one CPU, each thread may run on a different CPU. 
	*/
	private static volatile SingleDoubleChecking singleton = null;
	//private constructor for avoid creating this class
	private SingleDoubleChecking(){
		
	}
	//lazy initialization 
	public static SingleDoubleChecking getInstance(){
		if (singleton == null) {
			//perform sync on whole class , also we should avoid making 
			//method syncronized i'ts make the process more slow for one time initialization 
			synchronized (Singleton.class) {
				//DoubleCheck is needed when two threads entered to the critical section and one of them create
				// object , the second wait until first does't release . And the second check for the second thread to avoid double object initization.
				if (singleton == null) {
					singleton = new SingleDoubleChecking();
				}
			}
		}
		return singleton;
	}
}
