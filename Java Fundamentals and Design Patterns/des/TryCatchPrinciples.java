
public class TryCatchPrinciples {
	
	//Rule 1 
	//Finally runs after return 
	public static int proveIt()
    {
    	try {  
            	return 1;  
    	}  
    	finally {  
    	    System.out.println("finally block is run before method returns.");
    	}
    }
}
