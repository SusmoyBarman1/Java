import javax.swing.JOptionPane;

import org.junit.Test;

public class Sound 
{
	double VELOCITY;
	double TIME;
	double distance;
	
	//Here we will use the formula s = vt, to compute the distance;
	
	//Constructor
	@Test
	void setValue(double v,double t)
	{
		VELOCITY = v;
		TIME = t;
		distance = VELOCITY * TIME;
	}

	//System.out.println("The expected distance = "+distance);
		
	void printValue()
	{
		JOptionPane.showMessageDialog(null, distance);
	}
}
