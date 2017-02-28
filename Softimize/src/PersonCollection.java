import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * PersonCollections class .
 * @author BenFranklin
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
		Node<T> currentPerson = personCollectionHead;
		//If currentPerson is empty
		if(currentPerson == null){
			currentPerson = new Node<T>(person);
			currentPerson.setNext(personCollectionHead);
			personCollectionHead = currentPerson;
		}else{
			  //if currentPerson is nor empty
            Node<T> parent = null;
            while (currentPerson != null) {
                if (personComparator.compare(person, currentPerson.getData()) > 0) {

                    Node<T> newNode = new Node<T>(person);
                    newNode.setNext(currentPerson);

                    if (parent != null) {
                        parent.setNext(newNode);
                    } else {
                        this.personCollectionHead = newNode;
                    }

                    parent = null;
                    break;
                }
                parent = currentPerson;
                currentPerson = currentPerson.getNext();
            }

            //in case that the new person is the smallest
            if (parent != null) {
                Node<T> newNode = new Node<T>(person);
                parent.setNext(newNode);
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
}
