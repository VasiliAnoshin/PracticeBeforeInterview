
public class Dog{
	String Name =null;
	public Dog(String name){
		this.Name = name;
	}
	public String getName(){
		return this.Name;
	}
	public String setName(String name){
		this.Name = name;
		return Name;
	}
	
	public void foo(Dog someDog) {
		 someDog.setName("Max");     // AAA
		 someDog = new Dog("Fifi");  // BBB
		 someDog.setName("Rowlf");   // CCC
	}
}
