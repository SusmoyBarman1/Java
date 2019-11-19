package Question_7;

import java.util.Scanner;

public class TicketSeller {
	
	int calculation()
	{
		Scanner in = new Scanner(System.in);
		
		int maxSell = 4;
		int numberOfTickets = 100;
		int count = 0;
		
		while(numberOfTickets>0)
		{
			System.out.print("How many tickets do you want to buy: ");
			int ticket = in.nextInt();
			
			if(ticket>100)
			{
				System.out.println("You can only buy 4 or less tickets!\nTry again!");
			}
			else
			{
				numberOfTickets = numberOfTickets - ticket;
				count++;
				System.out.println("Congratulations!, you got "+ticket+" tickets!\n");
			}
		}
		
		System.out.println("Number of buyers: "+count);
		return count;
	}

	/**
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int maxSell = 4;
		int numberOfTickets = 100;
		int count = 0;
		
		while(numberOfTickets>0)
		{
			System.out.print("How many tickets do you want to buy: ");
			int ticket = in.nextInt();
			
			if(ticket>4)
			{
				System.out.println("You can only buy 4 or less tickets!\nTry again!");
			}
			else
			{
				numberOfTickets = numberOfTickets - ticket;
				count++;
				System.out.println("Congratulations!, you got "+ticket+" tickets!\n");
			}
		}
		
		System.out.println("Number of buyers: "+count);
	}
	*/
}
