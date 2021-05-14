import java.util.Random;
import java.util.Scanner;

public class MatrixTest {
	
	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/16/20
	 * In this program, I will be testing my first matrix class!  
	 * I will put the logic for setting up the input and the size of the columns 
	 * I need to test these functions in a Matrix test file.    
	 */
	
	public static void main(String[] args) {
		// Instanciate Matrix in here and call methods.  
		// The main method I need to ask the user input.
		// All of the logic is in the matrix class and call it in main.  
		// obj is an object matrix. m is the class
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of rows ");
		int rowsInput = sc.nextInt();
		System.out.println("Please enter the number of columns: ");
		int columnsInput = sc.nextInt();
		System.out.println("Enter true or false to either get 1 or 0 respectively for matrix values ");
		
		boolean[][] m = new boolean[rowsInput][columnsInput];
		
		for (int i = 0; i< m.length; i++)
		{
			for (int j = 0; j < m[0].length; j++)
			{
				m[i][j] = sc.nextBoolean();
			}
		}
		
		Matrix obj = new Matrix(m);
		
		
		//Calls the two string method to get output
		//obj the object that replicates the matrix.  
		System.out.println(obj.toString());
		
		System.out.println("Transposes Matrix");
		//Make sure for all method calls you use to strings
		System.out.println(obj.transposeMatrix().toString());
		
		System.out.println("Is a square matrix?");
		//Checks for square matrix
		System.out.println(obj.isSquareMatrix());
		
		System.out.println("Rotates the matrix clockwise");
		//Rotates matrix clockwise
		System.out.println(obj.rotateClockwise().toString());
		
		System.out.println("Rotates the matrix counter-clockwise");
		//Rotates matrix counterclockwise
		System.out.println(obj.rotateCounterClockwise().toString());
		
		System.out.println("Percent True: ");
		System.out.println(obj.percentageTrue());
		
		Matrix obj2 = new Matrix(m);
		
		System.out.print("Is Equal: ");
		System.out.println(obj.isEqual(obj2));

	}

}
