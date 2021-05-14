import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixJUNIT {

	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/16/20
	 * This is the JUNIT test for my Matrix class 
	 * Make a manual test matrix and test all the methods here.    
	 */

	    @Test
		public void test() {
		//Here is a sample matrix I can test instead of imputting values.  
		boolean matrixTest[][] =  new boolean[2][3];
		matrixTest[0][0] = true;
		matrixTest[0][1] = true;
		matrixTest[0][2] = true;
		matrixTest[1][0] = false;
		matrixTest[1][1] = false;
		matrixTest[1][2] = false;
				
		//Create two objects from the matrix test
		Matrix obj = new Matrix(matrixTest);
		Matrix obj2 = new Matrix(matrixTest);
		
		//Test the methods
		Matrix test = new Matrix(matrixTest);
		String output = test.toString();
		assertEquals(output, "[1,1,1\n0,0,0]");
		
		String output2 = test.transposeMatrix().toString();
		assertEquals("[1,0\n1,0\n1,0]", output2);
		
		boolean output3 = test.isSquareMatrix();
		assertEquals(false,output3);
		
		String output4 = test.rotateClockwise().toString();
		assertEquals("[0,1\n0,1\n0,1]", output4);
		
		String output5 = test.rotateCounterClockwise().toString();
		assertEquals("[1,0\n1,0\n1,0]", output5);
		
		String output6  = test.percentageTrue();
		assertEquals("50.0% True", output6);
		
		boolean output7 = test.isEqual(obj2);
		assertEquals(true, output7);
		
	}

}
