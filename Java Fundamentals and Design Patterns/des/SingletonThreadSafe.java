//ThreadSafe implementation of singleton .
public class SingletonThreadSafe {
	//When Interface was choosen to implement in that way it's loose lazy initialization
	private static final SingletonThreadSafe _instance = new SingletonThreadSafe();
	
	private SingletonThreadSafe(){
		
	}
	//when two threds entered critical section them will return initialized once time object. 
	//static variables initialized before .
	public static SingletonThreadSafe getInstance(){
		return _instance;
	}
}
