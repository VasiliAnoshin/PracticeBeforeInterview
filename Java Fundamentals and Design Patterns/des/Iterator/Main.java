package Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu(); 
		DinerMenu dinerMenu = new DinerMenu();
		
		Waitress waitress = new Waitress(dinerMenu, pancakeHouseMenu);
		waitress.printMenu();
	}

}
