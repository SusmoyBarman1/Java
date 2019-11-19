import java.util.Scanner;

public class Calculator_Test 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Calculator1 cal = new Calculator1();
		int check = 1;
		
		while(true)
		{
			System.out.println("Welcome to calculator.");
			System.out.println("To add, Press 1.");
			System.out.println("To subtract, Press 2");
			System.out.println("To multiply, Press 3.");
			System.out.println("To divide, Press 4");
			System.out.println("To find modulus, Press 5");
			System.out.println("To exit, Press 0");
			
			check = in.nextInt();
			if(check==0)
			{
				break;
			}
			System.out.print("Give two numbers: ");
			
			if(check==1)
			{
				double numA = in.nextDouble();
				double numB = in.nextDouble();
				double ans = cal.addNum(numA, numB);
				System.out.println("The addition of "+numA+" and "+numB+": "+ans+"\n\n");
			}
			else if(check==2)
			{
				double numA = in.nextDouble();
				double numB = in.nextDouble();
				double ans = cal.subNum(numA, numB);
				System.out.println("The subtraction of "+numA+" and "+numB+": "+ans+"\n\n");
			}
			else if(check==3)
			{
				double numA = in.nextDouble();
				double numB = in.nextDouble();
				double ans = cal.multiplyNum(numA, numB);
				System.out.println("The multiplication of "+numA+" and "+numB+": "+ans+"\n\n");
			}
			else if(check==4)
			{
				double numA = in.nextDouble();
				double numB = in.nextDouble();
				double ans = cal.divNum(numA, numB);
				System.out.println("The division of "+numA+" and "+numB+": "+ans+"\n\n");
			}
			else if(check==5)
			{
				double numA = in.nextDouble();
				double numB = in.nextDouble();
				double ans = cal.modNum(numA, numB);
				System.out.println("The modulus of "+numA+" over "+numB+": "+ans+"\n\n");
			}
		}
	}
}
