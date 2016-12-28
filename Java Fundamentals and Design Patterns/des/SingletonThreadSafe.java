//ThreadSafe implementation of singleton .
public class SingletonThreadSafe {
	//When Interface was choosen to implement in that way it's loose lazy initialization
	private static final SingletonThreadSafe _instance = new SingletonThreadSafe();
	
	private SingletonThreadSafe(){
		
	}	
	public static SingletonThreadSafe getInstance(){
		return _instance;
	}
}
