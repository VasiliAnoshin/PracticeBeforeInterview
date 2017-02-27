import java.util.ArrayList;
import java.util.List;

/**
 * PersonCollections class .
 * @author BenFranklin
 *
 */
public class PersonCollection<T> {
	//Pointer to head of LinkedList
	private Node<T> personCollection;
	//linkedList size
	private int size;
	//list of Subscribers 
	private List<Observer> subscribers;
	
	public PersonCollection(){
		this.subscribers = new ArrayList();
		this.size = 0;
		this.personCollection = null;
	}
	/**
	 * Add - adds the person object which is given as input. This operation may be performed in WC time complexity of O(n) . 
	 * That's happened when the new object have lowest value and be in the end of the linked list . 
	 * @param person
	 */
	public synchronized void Add(T person){
		
	}
	/**
	 * Remove - removes the person object with the maximum value in LinkedList of personCollection and returns it.
	 * This operation performed in WC time complexity of O(1) because removes all the time value from the head of the list;
	 * @return T person
	 */
	public synchronized T Remove(){
		if (this.size == 0){
			return null;
		}
		
		T person = this.personCollection.getData();
	    Node<T> nextPersonInTheList = this.personCollection.getNext();
	    this.personCollection.setNext(null);
	    this.personCollection = nextPersonInTheList;	   
	    notifyToSubscribersThatPersonWasRemoved(person);
	    this.size--;
	    return person;		
	}
	/**
	 * Publish - publishes a notification to subscriber objects upon any Add/Remove.
	 * @param person
	 */
	 private void notifyToSubscribersThatPersonWasRemoved(T person) {
	     for (Observer subscriber : subscribers) {
	    	 subscriber.Remove(person);
	        }
	 }
	 private void notifyToSubscribersThatPersonWasAdded(Person person) {
	     for (Observer subscriber : subscribers) {
	    	 subscriber.Add(person);
	     }
	 }	 
	 /**
	  * Add subscriber to list of subscribers .
	  */
	 public synchronized void addSubscriber(Observer subscriber) {
		 if (subscriber != null) {
			 this.subscribers.add(subscriber);
	      }
	 }
}
