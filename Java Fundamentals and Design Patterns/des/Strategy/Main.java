package Strategy;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Context context = new Context(new PlusOperation());		
	    System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

	    context = new Context(new minusOperation());		
	    System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

	    context = new Context(new OperationMultiply());		
	    System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}

}
