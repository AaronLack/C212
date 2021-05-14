import static org.junit.Assert.*;



/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 2/9/20
 * This is the JUNIT Tests for the Roman numeral problem  .
 */

public class Test {

	@org.junit.Test
	public void test() {
		
		RomanNumeral test = new RomanNumeral();
		int output = test.RomanNumeralToNumber("MCMLXXVIII");
		assertEquals(1978, output);
		
	}

}
