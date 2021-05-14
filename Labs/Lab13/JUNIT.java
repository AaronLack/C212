import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 5/3/20
 * Class JUNIT, for lab 13
 * All of my JUNIT tests are found here in this file. 
 */

public class JUNIT {

	@Test
	public void test() {
		//Median Test
		StopWatch timer = new StopWatch();
		Median check = new Median();
		check.addNumbers();
		
		boolean output = check.compareTime();
		assertEquals(output, true);
		
		boolean output2 = check.equals();
		assertEquals(output2, true);
		
		//Radix Tests
		 int arr[] = {27, 8, -39, 100, -2, 0, 69, -17, 12};
		 Radix rad = new Radix();
		 int[] result = rad.radix(arr);
		 
		 int[] sortedArray = {-39, -17, -2, 0, 8, 12, 27, 69, 100};
		 for(int i = 0; i < sortedArray.length; i++) {
			 int output3 = result[i];
			 assertEquals(output3, sortedArray[i]);
		 }
	}

}
