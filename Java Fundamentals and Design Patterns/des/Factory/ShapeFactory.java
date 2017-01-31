package Factory;


public class ShapeFactory {
	public Shape getShape(Shapes shapeType){
		switch(shapeType){
			case CIRCLE : 
				return new Circle();

			case RECTANGLE:
				return new Rectangle();
				
			case SQUARE:
				return new Square();
						
			default :
				return null;
		}
	}
}
