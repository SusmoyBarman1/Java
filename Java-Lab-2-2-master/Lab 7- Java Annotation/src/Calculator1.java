/** <h1> Calculator </h1>
 * 
 * The calculator program will do some operations on the numeric values
 * Here, a + b means, a and b are two numbers which will add.
 * The program will take several inputs
 * for every input, it will give a single output.
 * 
 * <p>
 * <b>Note:</b> Only use +,-,*,/ and % operators.
 * 
 * @author Susmoy Barman
 * @version 1.0
 * @since 29-10-2018
 *
 */


public class Calculator1 
{
	/**
	 * This method will add two number.
	 * Give two number. No matter double or integer.
	 * Show the usage of various javadoc Tags.
	 * 
	 *@param numA is the first parameter to addNum method.
	 *@param numB is the second parameter to addNum method.
	 *@return This method will return the sum of numA and numB
	 */
	
	public double addNum(double numA,double numB)
	{
		return numA + numB;
	}
	
	/**
	 * This method will subtract two number.
	 * Give two number. No matter double or integer.
	 * Show the usage of various javadoc Tags.
	 * 
	 *@param numA is the first parameter to subNum method.
	 *@param numB is the second parameter to subNum method.
	 *@return This method will return the subtraction of numA and numB
	 */
	
	public double subNum(double numA,double numB)
	{
		return numA - numB;
	}
	
	/**
	 * This method will multiply two number.
	 * Give two number. No matter double or integer.
	 * Show the usage of various javadoc Tags.
	 * 
	 *@param numA is the first parameter to multiplyNum method.
	 *@param numB is the second parameter to multiplyNum method.
	 *@return This method will return the multiplication of numA and numB
	 */
	
	public double multiplyNum(double numA,double numB)
	{
		return numA * numB;
	}
	
	/**
	 * This method will divide two number.
	 * Give two number. No matter double or integer.
	 * Show the usage of various javadoc Tags.
	 * 
	 *@param numA is the first parameter to divNum method.
	 *@param numB is the second parameter to divNum method.
	 *@return This method will return the division of numA and numB
	 */
	
	public double divNum(double numA,double numB)
	{
		return numA / numB;
	}
	
	/**
	 * This method will find the modulus of numA over numB.
	 * Give two number. No matter double or integer.
	 * Show the usage of various javadoc Tags.
	 * 
	 *@param numA is the first parameter to modNum method.
	 *@param numB is the second parameter to modNum method.
	 *@return This method will return the modulus of numA over numB
	 */
	
	public double modNum(double numA,double numB)
	{
		return numA % numB;
	}
}
