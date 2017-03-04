package Iterator;

import java.util.ArrayList;

public class PankaceMenuIterator implements Iterator {
	private ArrayList<MenuItem> menuItems;
	int position = 0;
	
	public PankaceMenuIterator(ArrayList<MenuItem> menuItems){
		this.menuItems = menuItems;
	}

	@Override
	public boolean hasNext() {
		if (position >= menuItems.size() || menuItems.get(position) == null) {
			return false; 
		} else {
			return true; 
		}		
	}

	@Override
	public Object next() {
		MenuItem menuItem = menuItems.get(position);
		position = position + 1;
		return menuItem;		
	}
}
