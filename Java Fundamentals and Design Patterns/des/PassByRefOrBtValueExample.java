//http://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value?page=1&tab=votes#tab-top
public class PassByRefOrBtValueExample {	
		public static void foo(Dog d) {
	    d.getName().equals("Max"); // true

	    d = new Dog("Fifi");
	    d.getName().equals("Fifi"); // true
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Dog aDog = new Dog("Max");
		 foo(aDog);

		 if (aDog.getName().equals("Max")) { //true
		     System.out.println( "Java passes by value." );
		 }else if (aDog.getName().equals("Fifi")) {
		     System.out.println( "Java passes by reference." );
		 }
		 
		 //is not a Dog; it's actually a pointer to a Dog.
		 Dog myDog = new Dog("Rover");
		 myDog.foo(myDog);
		 System.out.println(myDog.Name);
		
		
	}

}

