/**
 * Listener class is actually subscriber that implement Observer interface .
 * @author VasiliAnoshin
 *
 * @param <T>
 */

public class Listener<T> implements Observer{
	
	private T person;
	
	public Listener() {
        this.person = null;
    }	
	public void Add(Object _person) {
		this.person = (T) _person;
		
	}
	public void Remove(Object _person) {
		this.person = (T)_person;
	}	
	public T getPerson() {
        return this.person;
    }
}
