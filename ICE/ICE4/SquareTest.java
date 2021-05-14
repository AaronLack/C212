import java.util.ArrayList;
import java.util.Random;

/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/27/20
	 * In this program, I will test my methods from Square class
	 * I will make a 5 new objects to make sure my test cases work.  
	 * I need to make sure that I create an arrayList of random side lengths and starting positions
	 * I will do this by defining the 3 instance variables with a random range
	 * Then I will add the items to the array list. 
	 * Finally, I will use a loop to print out stuff nicely.  
	 * 
	 */


public class SquareTest {
	
	public static void main(String[] args) {
		
		Random generator = new Random();
		
		//Make 5 squares, use the .add method to put in array list, 
		//and make random numbers 10-50 for each square respectively
		ArrayList<Square> squares = new ArrayList<Square>();
		Square first = new Square(generator.nextInt(11),generator.nextInt(11),generator.nextInt(11));
		squares.add(first);
		
		Square second = new Square(generator.nextInt(21),generator.nextInt(21),generator.nextInt(21));
		squares.add(second);
		
		Square third = new Square(generator.nextInt(31),generator.nextInt(31),generator.nextInt(31));
		squares.add(third);
		
		Square fourth = new Square(generator.nextInt(41),generator.nextInt(41),generator.nextInt(41));
		squares.add(fourth);
		
		Square fifth = new Square(generator.nextInt(51),generator.nextInt(51),generator.nextInt(51));
		squares.add(fifth);
		
		//For loop to print stuff nicely
		for(int i = 0; i < squares.size(); i++)
		{
			System.out.println(squares.get(i).toString());
		}
		
	}

}
