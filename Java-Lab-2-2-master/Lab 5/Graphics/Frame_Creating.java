package jswing_practice;

import javax.swing.*;

public class Frame_Creating 
{
	public static void main(String[] args)
	{
		// Creating frame
		JFrame jfrm = new JFrame("Susmoy Barman");
		jfrm.setVisible(true);
		// Setting the size of frame.
		jfrm.setBounds(100, 100, 400, 600);
		// Setting exit variable
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Creating Button.
		JButton button = new JButton("Click");
		// Adding the button to the frame.
		jfrm.add(button);
	}
}
