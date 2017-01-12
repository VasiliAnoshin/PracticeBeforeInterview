

public class Motor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(TryCatchPrinciples.proveIt());
		System.out.println(TryCatchPrinciples.getANumber());
		
		//GUI app = new   GUI();
		//app.setVisible(true);
		
		enumExample en = new enumExample(enumExample.Company.GOOGLE);
		System.out.println("Enum representation : " + en.cName );
		for (enumExample.Company cName : enumExample.Company.values()) {
			System.out.println("Company Value: " + cName.value + " - Company Name: " + cName);
		}
		en.CompanyDetails();
	}

}
