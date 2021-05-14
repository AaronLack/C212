
public class GameofLife {
	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/21/20
	 * First, I instantiate the board.  
	 */
	private boolean[][] board;
	
	//Constructor, you initialize the instance variable to the parameter variable
	public GameofLife (boolean[][] initialBoard) {
		board = initialBoard;
	}
	
	//In this method, I need to define variables that state when an area is occupied or empty.  
	//Then, I need to figure out how to get those values on the board.  
	public String toString() {
		boolean occupied = true;
		boolean empty = false;
		
		String result = "";
		for(int i = 0; i < this.board.length; i++)
		{
			//[0] makes it so that any dimension is taken so no out of bounds error
			for(int j = 0; j < this.board[0].length; j++)
			{
				//j and i for row column for the game
				if (this.board[i][j] == occupied)
				{
					result += "o"; 
				}
				else
				{
					result += "+";
				}
			}
			//New line to format it
			result += "\n";
		}
		return result;
	}
	
	//Call the toString program to update the board properly
	//Also call the checkNeighbor funtion and write conditions based off of "M"
	public void grow(int generation, int freqPrint) {
		//Iterates through multiple generations
		for(int h = 0; h < generation; h++)
		{
			for(int i = 0; i < this.board.length; i++)
			{
				//[0] makes it so that any dimension is taken so no out of bounds error
				for(int j = 0; j < this.board[0].length; j++)
				{
					if (checkNeighbor(i,j) == 3)
					{
						board[i][j] = true;
					}
					if (checkNeighbor(i,j) == 2 && board[i][j] == true)
					{
						board[i][j] = true;
					}
					if (checkNeighbor(i,j) == 1 || checkNeighbor(i,j) == 0 || checkNeighbor(i,j) > 3)
					{
						board[i][j] = false;
					}
					
				}
			}
			//This prints the final generation so that there is not a ton of 2d arrays printed
			if (h % freqPrint == 0)
			{
				System.out.println(toString());
			}
		}	
		
	}
	
	//Check every corner of x,y and update it tracker
	//x is row, y is column
	//Account for edge cases as well.  
	private int checkNeighbor(int row, int col) {
		int tracker = 0;
		
		//LEFT AND RIGHT
		
		//Check to the left of x,y
		if (col != 0 && board [row][col-1] == true)
		{
			tracker += 1;
		}
		//Check to the right of x,y
		if (col != board[0].length-1 && board [row][col+1] == true)
		{
			tracker += 1;
		}
		
		
		//TOP
		
		//Checks very top left corner of board (0,0)
		if (row != 0)
		{
			//Checks very top left corner of board isn't (0,0)
			if (col != 0)
			{
				//Check the top left corner
				if (board [row-1][col-1] == true)
				{
					tracker += 1;
				}
			}
			
			//Check top middle
			if (board [row-1][col] == true)
			{
				tracker += 1;
			}
			
			//Condition for very top right corner
			if (col != board[0].length-1)
			{
				//Check top right
				if (board [row-1][col+1] == true)
				{
					tracker += 1;
				}
			}
			 
		}
		
		//BOTTOM
		
		
		//Call array first to get the element
		//board.length gets just the column
		if (row != board.length-1)
		{	
			//Check if x,y isnt 0,length of board
			if(col != 0)
			{
				//Check the bottom left
				if (board [row+1][col-1] == true)
				{
					tracker += 1;
				}
			}
			
			//Check the bottom middle
			if (board [row+1][col] == true)
			{
				tracker += 1;
			}
			
			if(col != board[0].length-1)
			{
				//Check the bottom right
				if (board [row+1][col+1] == true)
				{
					tracker += 1;
				}
			}
		}
		
	return tracker;
	}

}
