/* This is my JUNIT test for Lab2Integer.java
 * @Author Aaron Lack, alack
 * Last Edited: 1/28/20
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class Lab2IntegerTest {

	@Test //For my Lab 2 integer program
	public void test() {
		Lab2Integer test = new Lab2Integer(); 

		assertEquals("65 66 67 90 88 97 98 99 121 117 48 57 50 36 42 62 124 92 32 9", Lab2Integer.characters());
	}

}
