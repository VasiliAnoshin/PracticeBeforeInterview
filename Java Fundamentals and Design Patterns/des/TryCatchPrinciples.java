
public class TryCatchPrinciples {
	
	//Rule 1 
	//Finally runs before try return a value 
	public static int proveIt()
    {
    	try {  
            	return 1;  
    	}  
    	finally {  
    	    System.out.println("finally block is run before method returns.");
    	}
    }
	/*Very unique situations when finally will not run after return
     The finally block will not be called after return in a couple of
     unique scenarios: 
     1) If System.exit() is called first,
     2) If the JVM crashes.
    */
	
	//Rule 2 :
	/*The code above will actually return the “43” instead of the “7”,
	 * because the return value in the finally block (“43”) will override the return
	 * value in the try block (“7”).
	 */
	@SuppressWarnings("finally")
	public static int getANumber(){
	    try{
	        return 7;
	    } finally {
	        return 43;	    
	    }
	}
	//Rule 3
	/*
	 Also, if the finally block returns a value, it will override any
	 exception thrown in the try/catch block. Here is an example:
	 */
	@SuppressWarnings("finally")
	public static int getANumberWithException(){
	    try{
	        throw new NoSuchFieldException();
	    } finally {
	        return 43;
	    }
	}
	
	//A return statement in the finally block is a bad idea
}
