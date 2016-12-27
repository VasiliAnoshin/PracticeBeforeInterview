
public final class Singleton {
	//pattern singleton provides that class have only one instance and get access to class.
	private static Singleton instance;
	//simple Implementation 
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		if (instance == null){
			instance = new Singleton();
		}
		return instance;
	}
}
