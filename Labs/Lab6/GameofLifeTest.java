
public class GameofLifeTest {
	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/23/20
	 * This is the test for my GameofLife class.  
	 * Hard-code the test matrix based on what Adeel has in the lab 6
	 * Default values are false, so make sure you initialize correct positions into true.  
	 * Then make a new object with it.  
	 * Make two test methods.  
	 */
	
	
	public static void main(String[] args) {
		
		//Create an object
		//Default values are false, set the values and hard code them to true 
		//based on the figure in number 3
		boolean[][] initialBoard = new boolean[6][7];
		
		initialBoard[1][2] = true;
		initialBoard[2][3] = true;
		initialBoard[3][1] = true;
		initialBoard[3][2] = true;
		initialBoard[3][3] = true;
		
		GameofLife obj = new GameofLife(initialBoard);
		System.out.println("Original Matrix: ");
		System.out.println(obj.toString());
		
		//Since void method, no println. just attach object with function and parameters
		System.out.println("Test 1");
		obj.grow(10,1);
		
		System.out.println("Test 2");
		obj.grow(100,20);

	}

}
