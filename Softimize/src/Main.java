import java.util.Comparator;

public class Main {
		
	public static void main(String[] args) {
		// Comparator that comapre by ID
	    Comparator<Person> personComparator = new Comparator<Person>() {	        
			public int compare(Person p1, Person p2) {
	            return p1.getId() - p2.getId();
	        }
	    };
	    PersonCollection<Person> persons = new PersonCollection<>(personComparator);
	    Person1 p = new Person1("Fil","Coutinho",1234,181);
	    Person1 p1 = new Person1("Cristiano","Ronaldo",1233,183);
	    Person1 p2 = new Person1("Andres","Iniesta",1232,180);
	    Person1 p3 = new Person1("Lionel","Messi",1230,189);
	    
	    persons.Add(p);
	    persons.Add(p1);
	    persons.Add(p2);
	    persons.Add(p3);
	    
	    Node<Person> temp = persons.getPersonHead();
	    while (temp != null) {
			System.out.print("->" +temp.getData().getFirstName() + " " + temp.getData().getLastName() + " id:" + temp.getData().getId());
			temp = temp.getNext();
		}
		// Comparator that comapre by Height
	    Comparator<Person> personComparatorByHeight = new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
	            return p1.getHeight() - p2.getHeight();
	        }
	    };
	    System.out.println("\n");
	    persons = new PersonCollection<>(personComparatorByHeight);
	    //Create and Add subscriber
	    Listener subscriber = new Listener<Person>();	
	    persons.addSubscriber(subscriber);
	    p = new Person1("Fil","Coutinho",1234,181);
	    p1 = new Person1("Cristiano","Ronaldo",1233,183);
	    p2 = new Person1("Andres","Iniesta",1232,180);
	    
	    p3 = new Person1("Lionel","Messi",1230,189);
	    
	    persons.Add(p);
	    persons.Add(p1);
	    persons.Add(p2);
	    persons.Add(p3);
	    
	    temp = persons.getPersonHead();
	    while (temp != null) {
			System.out.print("->" +temp.getData().getFirstName() + " " + temp.getData().getLastName() + " " + temp.getData().getHeight());
			temp = temp.getNext();
		}
	    persons.Remove();
	    temp = persons.getPersonHead();
	    System.out.println("\n");
	    while (temp != null) {
			System.out.print("->" +temp.getData().getFirstName() + " " + temp.getData().getLastName() + " " + temp.getData().getHeight());
			temp = temp.getNext();
		}
	    //Subscriber get data about the last removed person . 
	    Person person = (Person) subscriber.getPerson();
	    System.out.println("\nSubscriber : Instance that was removed is : " + person.getFirstName() + person.getLastName());
	}

}
