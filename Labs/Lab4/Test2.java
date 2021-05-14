import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 2/12/20
 * This is the JUNIT Tests for the Strings problem  
 */

public class Test2 {

	@Test
	public void test() {
		Strings test = new Strings();
		String output1 = test.equalStrings("abc","Def", "dabecf");
		assertEquals("True", output1);
		
		String output2 = test.equalStrings("abc","DEF", "WxyzKl");
		assertEquals("False", output2);
		
	}

}
