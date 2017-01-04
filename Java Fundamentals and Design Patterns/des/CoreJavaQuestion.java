
public class CoreJavaQuestion {
	 //# For 3-d question : 
	 static int a = 1111;
	 static
	 {
	        a = a-- - --a;
	 }
	    
	 {
	       a = a++ + ++a;
	 }
	 	
	public static class B{
		B b = new B();		
		public int show(){
			return(true?null:0);
		}		
	}				
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1: What is ouput of the following : Uncomment
		   try{
			   B test = new CoreJavaQuestion.B();
			   test.show();
		   }catch(StackOverflowError b){
			   System.out.println(b);
		   }		   
		/*
		 * It will lead to exception . It cause as result of how Javainitialize object . 
		 * Before constructor Java initialize instance variable first static and then non-static.
		 * Here  B b= new B(); variable is object and assigned to new object of same class.
		 * B b= new B(); statement leads to recursive execution of constructor will create infinite 
		 * objects so at run time an exception will be raised 
		 */
		
		//2: What is output of A :  ? 
		  A obj=null;
	      obj.show();
	    //We can call static methods using reference variable which is pointing to null 
	    //because static methods are class level so we can either call using class name and reference variable which is pointing to null.
	    //3: what is the output  
	      System.out.println(a);
	      //4: what will be the output : 
	      try{
	    	  A obj2= new A();
	    	  obj2.GetValue();
	      }catch(NullPointerException a){
	    	  System.out.println(a);
	      }
	      //The output of wbove code is always true ; NullPointerException happen because: the result of above code -  int i =(int)null; . And primitive value can't hold null but Integer yes can . 
	      //5 what is the output : 
	      Integer i1 = 128;	      
	      Integer i2 = 128;	    
	      System.out.println(i1 == i2);	    
	      Integer i3 = 127;
	      Integer i4 = 127;	    
	     System.out.println(i3 == i4);
	      
	}
	public static class A{
		 
		public static void show()
		{			 
			  System.out.println("Static method called");
		}
		int GetValue()
		{
		        return (true ? null : 0);
		}
		 
}

}
