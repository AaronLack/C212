import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Map;

import org.junit.Test;

public class Lab11Test {
	
	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 4/22/20
	 * Class Lab11Test, my JUNIT tests for both shortestDistance and Stocks
	 * Some of the JUNIT tests, you can look at what is expected and outputed and change the values, and they 
	 * should be the same, but sometimes your different. 
	 * Feel free to coment out one junit test to do the other one for grading purposes, 
	 * I put them in one file for convienence. 
	 */

	@Test
	public void test() throws FileNotFoundException {
		ShortestDistance test = new ShortestDistance("Pueblo");
		Map<String, DistanceTo> testMap = test.findShortestDistance();
		for(String s : testMap.keySet()) {
			DistanceTo value = testMap.get(s);
			String output = value.getTarget() + " to " + s.toString() + ": " +  value.getDistance();
			String output2 = value.getTarget() + " to " + s.toString() + ": " +  value.getDistance();
			assertEquals("Pueblo to Pendleton: 5", output);
			assertEquals("Pueblo to Pensacola: 8", output2);
		}
		
		//Stock Junit test
		Stocks test2 = new Stocks();
		test2.buy("Apple", 100, 10);
		test2.sell("Apple", 12);
		test2.stockMarketSimulator();
		assertEquals(200,test2);

	}

}
