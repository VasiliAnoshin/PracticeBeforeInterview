package Strategy2implementation;
//Define a family of algorithms , encapsulate each one, and make them interchangeable. 
//The strategy pattern lets the algorithm vary independently from clients that use it .
public class Main {

	public static void main(String[] args) {
		Animal sparky = new Dog();
		Animal tweety = new Bird();
		
		System.out.println("Dog: " + sparky.tryToFly());
		
		System.out.println("Bird: " + tweety.tryToFly());
		
		// This allows dynamic changes for flyingType
		
		sparky.setFlyingAbility(new ItFlys());
		
		System.out.println("Dog: " + sparky.tryToFly());
	}

}
