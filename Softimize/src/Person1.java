import java.sql.Date;
/**
 * Class Person1 that implement interface Person.
 * @author VasiliAnoshin
 *
 */
public class Person1 implements Person {
	private int ID;
	private String fistName;
	private String lastName;
	private int height;
	
	public Person1(String _fistName, String _lastName , int _ID , int _height){
		this.fistName = _fistName;
		this.lastName = _lastName;
		this.ID = _ID;
		this.height = _height;
	}
	
    public int getId() {
        return ID;
    }
    
    public String getFirstName() {
        return fistName;
    }

	public String getLastName() {
		return lastName;
	}


	public Date getDateOfBirth() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getHeight() {
		return this.height;
	}
}