import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * PersonCollections class .
 * @author Vasili Anoshin
 *
 */
public class PersonCollection<T> {
	//Pointer to head of LinkedList
	private Node<T> personCollectionHead;
	//linkedList size
	private int size;
	//list of Subscribers 
	private List<Observer> subscribers;
	private Comparator<T> personComparator;
	
	public PersonCollection(Comparator<T> comparator ){
		this.subscribers = new ArrayList();
		this.size = 0;
		this.personCollectionHead = null;
		this.personComparator = comparator;
	}
	/**
	 * Add - adds the person object which is given as input. This operation may be performed in WC time complexity of O(n) . 
	 * That's happened when the new object have lowest value and be in the end of the linked list . 
	 * @param person
	 */
	public synchronized void Add(T person){
		Node<T> currentPersonInList = personCollectionHead;
		Node<T> newPerson = new Node<T>(person);
		//If currentPerson is empty
		if(currentPersonInList == null){
			currentPersonInList = new Node<T>(person);
			currentPersonInList.setNext(personCollectionHead);
			personCollectionHead = currentPersonInList;
		}else{
			//if currentPerson is not empty
            Node<T> parent = null;
            while (currentPersonInList != null) {
                if (personComparator.compare(person, currentPersonInList.getData()) > 0) {                    
                    newPerson.setNext(currentPersonInList);
                    if (parent != null) {
                        parent.setNext(newPerson);
                    } else {
                        this.personCollectionHead = newPerson;
                    }
                    parent = null;
                    break;
                }
                parent = currentPersonInList;
                currentPersonInList = currentPersonInList.getNext();
            }            
            //if the new person in the tail (Last element in the list)
            if (parent != null) {
                parent.setNext(newPerson);
            }			
		}
		this.size++;
		notifyToSubscribersThatPersonWasRemoved(person);
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
		
		T person = this.personCollectionHead.getData();
	    Node<T> nextPersonInTheList = this.personCollectionHead.getNext();
	    this.personCollectionHead.setNext(null);
	    this.personCollectionHead = nextPersonInTheList;	   
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
	 
	 public Node<T> getPersonHead(){
		 return this.personCollectionHead;
	 }
}
