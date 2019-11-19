package Question_6;

import java.util.Scanner;

public class MaxTension 
{
	
	double calculation(double m)
	{
		double r = 3;
		double maxTension = 60;
		double[] v = new double[4];
		//double m = 0;
		
		v[0] = 1;
		v[1] = 10;
		v[2] = 20;
		v[3] = 40;
		
		double T = 0;
		double rem = 0;
		int check = 1;
		
//		System.out.println("Enter the value of m: ");
//		m = in.nextDouble();
		
		double max = 0;
		
		for(int i=0;i<4;i++)
		{
			T = (m * (v[i]*v[i])) / r;
			//System.out.println("T = "+T);
			if(T>maxTension)
			{
				break;
			}
			if(max<T)
			{
				max = T;
				rem = v[i];
			}
		}
		
		System.out.println("Without breaking the rope ,the maximum speed is: "+rem);
		return rem;
	}
	
	/**
	static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
	
		double r = 3;
		double maxTension = 60;
		double[] v = new double[4];
		double m = 0;
		
		v[0] = 1;
		v[1] = 10;
		v[2] = 20;
		v[3] = 40;
		
		double T = 0;
		double rem = 0;
		int check = 1;
		
		while(check != 0)
		{
			System.out.println("Enter the value of m: ");
			m = in.nextDouble();
			
			double max = 0;
			
			for(int i=0;i<4;i++)
			{
				T = (m * (v[i]*v[i])) / r;
				//System.out.println("T = "+T);
				if(T>maxTension)
				{
					break;
				}
				if(max<T)
				{
					max = T;
					rem = v[i];
				}
			}
			
			System.out.println("Without breaking the rope ,the maximum speed is: "+rem);
			
			System.out.print("If you want to quit, press 0, Otherwise 1: ");
			check = in.nextInt();
		}
	}
	*/
}
