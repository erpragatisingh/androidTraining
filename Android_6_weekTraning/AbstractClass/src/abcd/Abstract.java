package abcd;

public class Abstract extends abc{
	
	
	public static void main(String[] args) {
		Abstract aa= new Abstract();
		aa.display();
		aa.abcd(20);
	}
	

	@Override
	public void abcd(int x) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		System.out.println(x);
	}

}

abstract class abc{
	public void display() {
		// TODO Auto-generated method stub
System.out.println("soo");

	}
	
	abstract public void abcd(int x);
}
