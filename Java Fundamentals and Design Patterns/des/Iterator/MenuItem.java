package Iterator;
/**
 * A MenuItem consists of a name, a description, a flag to indicate if the item is vegetarian,
 * and a price. 
 * You pass all these values into the constructor to initialize the MenuItem.
 * @author anoshin45
 *
 */
public class MenuItem {
	String name;
	String description;
	boolean vegetarian;
	double price;
	
	public MenuItem(String name, String description, boolean vegetarian, double price)
	{
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}
	public String getName() 
	{ 
		return name;
	}
	public String getDescription() 
	{ 
		return description;
	}
	public double getPrice() 
	{ 
		return price;
	}
	public boolean isVegetarian() 
	{ 
		return vegetarian;
	}
}
