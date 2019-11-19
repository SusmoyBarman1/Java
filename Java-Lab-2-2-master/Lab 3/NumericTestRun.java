
public class NumericTestRun{
	public static void main(String[] args)
	{
		NumericTest isEven = (n) -> (n % 2) == 0;
		NumericTest isNegative = (n) -> (n < 0);
		System.out.println(isEven.computeTest(5));
		System.out.println(isNegative.computeTest(-5));
		
		MyGreeting mg = (name) -> "Good Morning " + name + "!";
		System.out.println(mg.processName("Susmoy"));
		
		MyGreeting morningGreeting = (str) -> "Good Morning " + str + "!";
		MyGreeting eveningGreeting = (str) -> "Good Evening " + str + "!";
		
		System.out.println(morningGreeting.processName("Luis"));
		System.out.println(eveningGreeting.processName("Jessica"));
	}
}
