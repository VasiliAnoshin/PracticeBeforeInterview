package Iterator;

import java.util.ArrayList;

//Waitress acts as a client
public class Waitress {
	PancakeHouseMenu pancakeHouseMenu;	
	DinerMenu dinerMenu;
	
	public Waitress(DinerMenu _dinerMenu,PancakeHouseMenu _pancakeHouseMenu){
		pancakeHouseMenu = _pancakeHouseMenu;
		dinerMenu = _dinerMenu;
	}
	
	public void printMenu(){		
		Iterator pancakeIterator = pancakeHouseMenu.createIterator(); 
		Iterator dinerIterator = dinerMenu.createIterator();
		System.out.println("MENU\n----\nBREAKFAST"); 
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
		
	}
	private void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem)iterator.next(); 
			System.out.print(menuItem.getName() + " , " ); 
			System.out.print(menuItem.getPrice() + " -- "); 
			System.out.println(menuItem.getDescription());
			}
	}
	
	//prints all vegetarian menu items
	public void printVegetarianMenu(){}
	
}
