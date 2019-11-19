
public class Code_1 {

	public static void main(String[] args) 
	{
		// Lamda expression implements an interface as a type of the interface.
		// Here, MyLamda is the type of nullValue
		MyLamda lamdaValue = () -> System.out.println("Hello world!");
		
		lamdaValue.print();
	}
}

interface MyLamda
{
	void print();
}
