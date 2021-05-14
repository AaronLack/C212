import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Header
 * Lab 3 Exercises
 * @Author: Aaron Lack, alack
 * Last edited: 2/5/20
 * This is the JUNIT Tests for all of my problems required for testing.  
 * I put all of the test cases in one file, and they turn green.  
 * I also tested them individually and commented other test cases out to verify that all are correct
 * For functions with multiple conditions (if/else), I put in more than one test case.  
 */

public class Lab3ExercisesTest {

	@Test
	public void test() {
		
		Lab3Exercises test = new Lab3Exercises();
		int output = test.my1089puzzle(123);
		assertEquals(1089,output);
		
		String output2 = test.formatPhoneNumber("7082463400",true);
		assertEquals("(708)246-3400",output2);
		
		String output3 = test.formatPhoneNumber("7082463400", false);
		assertEquals("708-246-3400",output3); 
		
		String output4 = test.grade('A');
		assertEquals("Your grade is in between a 93.0 and 100",output4);
		
		String output5 = test.grade('B');
		assertEquals("Your grade is in between a 83.0 and 92.99",output5);
		
		String output6 = test.grade('C');
		assertEquals("Your grade is in between a 73.0 and 82.99",output6);
		
		String output7 = test.grade('D');
		assertEquals("Your grade is in between a 63.0 and 72.99", output7);
		
		String output8 = test.grade('F');
		assertEquals("Your grade is less that a 63.0", output8);
		
		String output9 = test.intToHex(193);
		assertEquals("C1",output9);
		
		String output10 = test.intToHex(2014);
		assertEquals("7DE", output10);
	
		
	}

}
