package Iterator;

import java.util.ArrayList;

//Waitress acts as a client
public class Waitress {
	PancakeHouseMenu pancakeHouseMenu;
	ArrayList breakfastItems;
	DinerMenu dinerMenu;
	MenuItem[] lunchItems;
	
	public Waitress(){
		pancakeHouseMenu = new PancakeHouseMenu();
		breakfastItems = pancakeHouseMenu.getMenuItems();
		dinerMenu = new DinerMenu();
		lunchItems = dinerMenu.getMenuItems();
	}
	//Bad Implementation as each time we add another Baker we should add a lot of duplicate loops. 
	public void printMenu(){
		for (int i = 0; i < breakfastItems.size(); i++) 
		{
			MenuItem menuItem = (MenuItem)breakfastItems.get(i);
			System.out.print(menuItem.getName() + " "); 
			System.out.println(menuItem.getPrice() +  " "); 
			System.out.println(menuItem.getDescription());
		}
		for (int i = 0; i < lunchItems.length; i++) 
		{ 
			MenuItem menuItem = lunchItems[i]; 
			System.out.print(menuItem.getName() + " "); 
			System.out.println(menuItem.getPrice() +  " "); 
			System.out.println(menuItem.getDescription());
		}
	}
	//prints all vegetarian menu items
	public void printVegetarianMenu(){}
	
}
