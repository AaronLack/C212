import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/25/20
 * Class ClassTest, part of lab7 redo
 * I really screwed up the complex and standard class numbers problem so I redid it to make it easier to understand.
 * And I also redid the JUNIT testing which pass now. 
*/	


public class ComplexTest {

	@Test
	public void test() {
		PolarComplex standardTest = new PolarComplex(3,30);
		StandardComplex polarTest = new StandardComplex(2.6,1.5);
		StandardComplex add = new StandardComplex(5.2,3);
		PolarComplex add2 = new PolarComplex(6,29.98);
		
		StandardComplex mult = new StandardComplex(4.51,7.8);
		PolarComplex mult2 = mult.getPolarComplex();
		//toString
		assertEquals(standardTest.toString(),"3.0(cos(30.0) + isin(30.0))");
		assertEquals(polarTest.toString(),"2.6 + 1.5i");
		

		//getConjugate
		
		
		//getPolarComplex
		assertEquals(polarTest.getPolarComplex().isEqual(standardTest),true);
		assertEquals(standardTest.getPolarComplex().isEqual(standardTest),true);
		
		//getStandardComplex
		assertEquals(standardTest.getStandardComplex().isEqual(polarTest),true);
		assertEquals(polarTest.getStandardComplex().isEqual(polarTest),true);
		
		//isEqual
		assertEquals(standardTest.isEqual(polarTest),true);
		assertEquals(polarTest.isEqual(standardTest),true);
		
		assertEquals(standardTest.isEqual(standardTest),true);
		assertEquals(polarTest.isEqual(polarTest),true);
		
		
		//add
		assertEquals(standardTest.add(polarTest).isEqual(add),true);
		assertEquals(polarTest.add(standardTest).isEqual(add),true);
		
		assertEquals(standardTest.add(standardTest).isEqual(add),true);
		assertEquals(polarTest.add(polarTest).isEqual(add),true);
		
		//subtract
		assertEquals(add.subtract(standardTest).isEqual(polarTest),true);
		assertEquals(add2.subtract(polarTest).isEqual(standardTest),true);
		
		assertEquals(add.subtract(polarTest).isEqual(standardTest),true);
		assertEquals(add2.subtract(standardTest).isEqual(polarTest),true);
		
		//multiply
		assertEquals(polarTest.multiply(standardTest).isEqual(mult),true);
		assertEquals(standardTest.multiply(polarTest).isEqual(mult),true);
		
		assertEquals(polarTest.multiply(polarTest).isEqual(mult),true);
		assertEquals(standardTest.multiply(standardTest).isEqual(mult),true);
		
		//divide
		assertEquals(mult.divide(polarTest).isEqual(standardTest),true);
		assertEquals(mult2.divide(standardTest).isEqual(polarTest),true);
	}

}
