package Strategy;

public class Context {
	Strategy strategy;
	public Context(Strategy _strategy){
		this.strategy = _strategy;
	}	
	
	public int executeStrategy(int num1, int num2){
	    return strategy.doOperation(num1, num2);
	}
	
}
