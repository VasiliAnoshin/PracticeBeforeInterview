/*
 * If you use enums instead of integers (or String codes), 
 * you increase compile-time checking and avoid errors from passing in invalid constants, 
 * and you document which values are legal to use.
 */

public class enumExample {
/*
 Enums are lists of constants. When you need a predefined list of values which 
 do represent some kind of numeric or textual data, you should use an enum. 
 For instance, in a chess game you could represent the different types of pieces as an enum:
 */
	enum ChessPiece {
		PAWN,
		ROOK,
		KNIGHT,
		BISHOP,
		QUEEN,
		KING;
	}
	
	public enum Company{
		EBAY(10), PAYPAL(20) , GOOGLE(30), YAHOO(40) , ATI(50);
		
		public int value;
		
		private Company(int value){
			this.value = value;
		}
	}
	
	Company cName;
	
	public enumExample(Company name){
		this.cName = name;
	}
	
	public void CompanyDetails(){
		switch(cName){
			case EBAY:
				System.out.println("Biggets market in the world");
				break;
			case PAYPAL:
				System.out.print("Simplest way to manage money");
				break;
			case GOOGLE:
			case YAHOO:
				System.out.println("1st Web 2.0 Company.");
				break;
	 
			default:
				System.out.println("Google - biggest search giant.. ATT - my carrier provider..");
				break;
		}
	}
	
}
