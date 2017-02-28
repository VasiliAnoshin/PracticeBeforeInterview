
public class Main {
	 private class Person1 implements Person {

	        @Override
	        int getId() {
	            return 1
	        }

	        @Override
	        String getFirstName() {
	            return "test1"
	        }

	        @Override
	        Date getDateOfBirth() {
	            return new Date(2016, 12, 01);
	        }
	    }

	    private class Person2 implements Person {

	        @Override
	        int getId() {
	            return 2
	        }

	        @Override
	        String getFirstName() {
	            return "test2"
	        }

	        @Override
	        Date getDateOfBirth() {
	            return new Date(2016, 12, 02);
	        }
	    }

	    private class Person3 implements Person {

	        @Override
	        int getId() {
	            return 3
	        }

	        @Override
	        String getFirstName() {
	            return "test3"
	        }

	        @Override
	        Date getDateOfBirth() {
	            return new Date(2016, 12, 03);
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
