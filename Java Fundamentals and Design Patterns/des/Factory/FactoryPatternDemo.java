package Factory;

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
