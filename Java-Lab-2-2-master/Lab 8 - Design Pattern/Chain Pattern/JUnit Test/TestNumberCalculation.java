package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chainPattern.AddNumbers;
import chainPattern.Chain;
import chainPattern.DivNumbers;
import chainPattern.MultiplyNumbers;
import chainPattern.Numbers;
import chainPattern.SubNumbers;

class TestNumberCalculation {
	
	Chain chainCalc1 = new AddNumbers();
	Chain chainCalc2 = new SubNumbers();
	Chain chainCalc3 = new MultiplyNumbers();
	Chain chainCalc4 = new DivNumbers();

	@BeforeEach
	void setUp() throws Exception {
		
		chainCalc1.setNextChain(chainCalc2);
		chainCalc2.setNextChain(chainCalc3);
		chainCalc3.setNextChain(chainCalc4);
	}

	@Test
	public void testAdd() {
		Numbers request = new Numbers(4,2,"add");
		double number = chainCalc1.calculate(request);
		
		assertEquals(6.0,number);
	}
	
	@Test
	public void testSub() {
		Numbers request = new Numbers(4,2,"pow");
		double number = chainCalc1.calculate(request);
		
		assertEquals(2.0,number);
	}
	
	@Test
	public void testMul() {
		Numbers request = new Numbers(4,2,"multiply");
		double number = chainCalc1.calculate(request);
		
		assertEquals(8.0,number);
	}
	
	@Test
	public void testDiv() {
		Numbers request = new Numbers(4,2,"div");
		double number = chainCalc1.calculate(request);
		
		assertEquals(2.0,number);
	}

}
