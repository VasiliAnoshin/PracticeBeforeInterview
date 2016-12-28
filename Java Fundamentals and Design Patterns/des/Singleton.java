//as we don't need to create any instance of the object class can be final .
public final class Singleton {
	//pattern singleton provides that class have only one instance and get access to class.
	private static Singleton instance;
	//private constructor avoid object creation 
	private Singleton(){
		
	}
	//This method is not thredSafe and that's why it will fail in multithreaded environment.
	// to avoid this fail we can add syncronized keyword after word static in the method
	public static Singleton getInstance(){
		//The instantiation is not performed until an object asks for an instance; 
		//this approach is referred to as lazy instantiation. Lazy instantiation avoids instantiating 
		//unnecessary singletons when the application starts.
		if (instance == null){
			instance = new Singleton();
		}
		return instance;
	}
}
