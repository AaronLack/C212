
public class Matrix {

	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/16/20
	 * In this program, I will be making my first matrix class!  
	 * I will write pseudocode on how to tackle each function.  
	 * I need to test these functions in a Matrix test file.    
	 */
	
	private boolean [][] matrix;
	private final int NUMROW;
	private final int NUMCOL;
	
	//Anything is a matrix if the dimensions are 1 or above for rows and columns. 
	//No decimals, negatives, or zero allowed.  
	//This will check for these cases.  This is a constructor. 
	//m is a parameter that is also a 2d array boolean object
	public Matrix(boolean[][]m) {
		matrix = m;
		//up and down
		NUMROW = m.length;
		//rows (left and right)
		NUMCOL = m[0].length;	
	}
	
	//If value input == True: add 1 to string
	//Else: add 0 to string
	//2 for loops to check if true, add 1. else 0. After each number add a comma, and put this all in result
	//print a new line for each column.  at [0][0], add a [ and at length of rows and columns, add a ].  
	//check out substring.  
	// i is height, j is length
	public String toString() {
		String result = "[";
		
		for (int i = 0; i< NUMROW; i++)
		{
			for (int j = 0; j < NUMCOL; j++)
			{
				if (matrix[i][j] == true)
				{
					
					result += "1";
				}
				else
				{
					result += "0";
				}
				
				if (j != NUMCOL - 1)
				{
					result += ",";
				}

			}
			
			if (i != NUMROW - 1)
			{
				result += "\n";
			}
			else
			{
				result += "]";
			}
		}
		return result;
		
	}
	//For the dimenstions, switch NUMROW and NUMCOL to NUMCOL and NUMROW
	//For this transpose, I need to switch i and j
	public Matrix transposeMatrix() {
		boolean [][] transMatrix = new boolean [NUMCOL][NUMROW];
		for (int i = 0; i< NUMROW; i++)
		{
			for (int j = 0; j < NUMCOL; j++)
			{
				transMatrix[j][i] = this.matrix[i][j];
			}
		}
		//This creates the new matrix object from the transpose matrix method
		return new Matrix(transMatrix);

	}
	
	//No if/else statements needed to return true or false.  
	public boolean isSquareMatrix() {
		return NUMROW == NUMCOL;
	}
	
	//Make anew matrix object and switch the values again and put it at the opposite end of the array (index wise). 
	public Matrix rotateClockwise() {
		boolean [][] clockwiseMatrix = new boolean[NUMCOL][NUMROW];
		for (int i =0; i<NUMROW; i++)
		{
			for (int j = 0; j<NUMCOL; j++)
			{
				clockwiseMatrix[j][NUMROW-1-i] = this.matrix[i][j];
			}
		}
		
		return new Matrix(clockwiseMatrix);
		
	}
	
	//The transpose method already rotates the values counter clockwise, so just call transpose :)
	public Matrix rotateCounterClockwise() {
		return transposeMatrix();
	}
	
	//Make a variable that keeps tracks of the trues in the rows and columns
	//Then make an area variable that multiplies the rows and columns
	//Divide it by the number trues
	//Return the number trues + a percent sign.  
	public String percentageTrue() {
		double numberTrues = 0;
		for (int i = 0; i<NUMROW; i++)
		{
			for (int j = 0; j<NUMCOL; j++)
			{
				if (matrix[i][j] == true)
				{
					numberTrues++;
				}
					
			}
		}
		double area = NUMROW*NUMCOL;
		double result = (double) (numberTrues/area) * 100;
		return result + "% True";
		
	}
	
	//This: refers to the object as a whole, object calling to the method
	//this. (dot): can call a method onto it
	public boolean isEqual (Matrix m) {
		if (this.NUMROW != m.NUMROW || this.NUMCOL != m.NUMCOL)
		{
			return false;
		}
		for (int i = 0; i<NUMROW; i++)
		{
			for (int j = 0; j<NUMCOL; j++)
			{
				if(this.matrix[i][j] != m.matrix[i][j])
				{
					return false;
				}
			}
		}
		return true;
		
	}
	
	
}
