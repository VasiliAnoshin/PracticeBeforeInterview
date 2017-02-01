package Factory;
/**
 * This Pattern for create objects (creationl pattern). 
 * Factory Pattern or Factory Method Pattern says that just define an interface or 
 * abstract class for creating an object but let the subclasses decide which class to instantiate. 
 * In other words, subclasses are responsible to create the instance of the class.
 * 
 * The Factory Method Pattern is also known as Virtual Constructor.
 * 
 * Usage of Factory Design Pattern
 * When a class doesn't know what sub-classes will be required to create
 * When a class wants that its sub-classes specify the objects to be created.
 * When the parent classes choose the creation of objects to its sub-classes.

 * 
 * @author BenFranklin
 *
 */

public class FactoryPatternDemo {
	
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		//get an object of Circle and call its draw method
		 Shape shape1 = shapeFactory.getShape(Shapes.CIRCLE);
		 
		 shape1.Draw();
		 
		 //get an object of Rectangle and call its draw method.
	     Shape shape2 = shapeFactory.getShape(Shapes.RECTANGLE);

	      //call draw method of Rectangle
	      shape2.Draw();

	      //get an object of Square and call its draw method.
	      Shape shape3 = shapeFactory.getShape(Shapes.SQUARE);

	      //call draw method of circle
	      shape3.Draw();

	}

}
