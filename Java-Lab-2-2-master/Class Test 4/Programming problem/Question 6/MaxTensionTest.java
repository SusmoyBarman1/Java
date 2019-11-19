package Question_6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxTensionTest {

	Scanner in = new Scanner(System.in);
	MaxTension mt = new MaxTension();

	@Test
	void test() {
		double m = 0.0098;
//		System.out.println("Enter the value of m: ");
		//m = in.nextDouble();
		
		assertEquals(40.0 , mt.calculation(m));
	}
	
	@Test
	void test1() {
		double m = 0.098;
//		System.out.println("Enter the value of m: ");
//		m = in.nextDouble();
		
		assertEquals(40.0 , mt.calculation(0.987654));
	}

}
