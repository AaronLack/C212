import java.util.Random;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 2/13/20
 * In this program, I will write a method that returns a string and takes in to parameters.  
 * First, I will set up an integer array of size 20.  
 * I will then feed the random inputs into the array.  
 * Next, I need to print out the values of the random dice rolls stored into an array.  
 * I then need to compare the one with the highest consecutive rolls for a certain value
 * I think it would be easiest to use substring to get the rolls into ().  
 */

public class LongestRun {

	public static String DiceRolls() {
		Random randRolls = new Random();
		int[] rolls = new int[20];
		
		//get 20 random dice rolls;
		for (int i = 0; i < 20; i++)
		{
			//This lets the program start from 1-6, if I were to put 7, 0 would be a value, which is bad
			int diceNumbers = randRolls.nextInt(6) + 1;
			rolls[i] = diceNumbers;	
		}
		
		//print out the result of the random rolls
		for (int i = 0; i < rolls.length; i++)
		{
			if (i < rolls.length -1)
			{
				System.out.print(rolls[i] + ", ");
			}
			else 
			{
				System.out.print(rolls[i]);
			}
		}	
		
		//initialize variables
		//counter is an empty placeholder variable.  
		//longestStreak keeps track of the most consecutive values rolled.  
		//endIndex is the final index of dice rolls.  startIndex is the beginning index.  
		int counter = 0;
		int longestStreak = 0;
		int endIndex = 0;
		int startIndex = 0;
		
		for (int i=0; i<19; i++)
		{
			int value = rolls[i+1];
			if (rolls[i] == value)
			{
				counter +=1;
				if (counter > longestStreak)
				{
					longestStreak = counter;
					endIndex = i+1;
					startIndex = i - longestStreak;
				}
			}
			else
			{
				counter = 0;
			}
		}
		
		System.out.println();
		
		//Put the final output into a string so we can easily add commas and ( ).  
		String finalOutput = "";
		for (int i=0; i < rolls.length; i++)
		{
			if(i-1 == startIndex)
			{
				finalOutput += "(" + rolls[i] + ", ";
			}
			else if (endIndex != i)
			{
				finalOutput += rolls[i] + ", ";
			}
			else
			{
				finalOutput += rolls[i] + ") ";
			}
		}
		
		return finalOutput.substring(0, finalOutput.length());
	}
	
	public static void main(String[] args) {
		System.out.println(DiceRolls());

	}

}
