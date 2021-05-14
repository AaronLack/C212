import java.util.Random;

public class RandomNumber {
	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/12/20
	 * First, write a method of a void type and then call it in main
	 * The final output needs to be stored inside an empty string. Values 0-10 will also be defined starting at 0. 
	 * Then, I will make a loop with that variable to generate 10 numbers of values 0-10. 
	 * Inside that loop, I will write a switch case statements that updates all the counter values. 
	 * I will create an if statement that states the frequency of all the numbers.
	 * The one with the highest frequency will get deleted.  
	 * I also need to add commas to the numbers, and taking care of any comma issues ex: ,, for removal.   
	 */
	
	public static void randomNumbers() {
		//Empty strings to store the values
		String randomNumbers = "";
		String finalNumbers = "";
		
		//11 counter variables, 0-10 to keep track of the output
		int counterZero = 0;
		int counterOne = 0;
		int counterTwo = 0;
		int counterThree = 0;
		int counterFour = 0;
		int counterFive = 0;
		int counterSix = 0;
		int counterSeven = 0;
		int counterEight = 0;
		int counterNine = 0;
		int counterTen = 0;
		
		//Implement random
		Random generator = new Random();
		
		//A loop to generate 10 values, accordingly.  Use switch case for updates. 
		for(int i = 0; i<=10; i++)
		{
			int randomTest = 1 + generator.nextInt(10);
			
			switch(randomTest)
			{
			case 0: counterZero++; break;
			case 1: counterOne++; break;
			case 2: counterTwo++; break;
			case 3: counterThree++; break;
			case 4: counterFour++; break;
			case 5: counterFive++; break;
			case 6: counterSix++; break;
			case 7: counterSeven++; break;
			case 8: counterEight++; break;
			case 9: counterNine++; break;
			case 10: counterTen++; break;
			}
			//Seperate the values with commas
			if (i < 10)
			{
				randomNumbers += randomTest + ",";
			}
			else 
			{
				randomNumbers += randomTest;
			}
		}
		
		//Original List
		System.out.println("Random Numbers = " + randomNumbers);
		
		//Checks for the frequency of 0-10.  The use of multiple if statements since this would be hard to loop.
		
		if (counterZero > 0)
		{
			System.out.println("Frequency of 0: " + counterZero);
		}
		if (counterOne > 0)
		{
			System.out.println("Frequency of 1: " + counterOne);
		}
		if (counterTwo > 0)
		{
			System.out.println("Frequency of 2: " + counterTwo);
		}
		if (counterThree > 0)
		{
			System.out.println("Frequency of 3: " + counterThree);
		}
		if (counterFour > 0)
		{
			System.out.println("Frequency of 4: " + counterFour);
		}
		if (counterFive > 0)
		{
			System.out.println("Frequency of 5: " + counterFive);
		}
		if (counterSix > 0)
		{
			System.out.println("Frequency of 6: " + counterSix);
		}
		if (counterSeven > 0)
		{
			System.out.println("Frequency of 7: " + counterSeven);
		}
		if (counterEight > 0)
		{
			System.out.println("Frequency of 8: " + counterEight);
		}
		if (counterNine > 0)
		{
			System.out.println("Frequency of 9: " + counterNine);
		}
		if (counterTen > 0)
		{
			System.out.println("Frequency of 10: " + counterTen);
		}
		
		//Checks the maximum possible of numbers that could generate.  
		//This helps hold which number we need to delete.  
		//Agian, I use multiple if statements since this would be hard to loop.
		
		int maximumFrequency = 1;
		String maximumNumber = "0";
		if (counterZero > maximumFrequency)
		{
			maximumFrequency = counterZero;
			maximumNumber = "0";
		}
		if (counterOne > maximumFrequency)
		{
			maximumFrequency = counterOne;
			maximumNumber = "1";
		}
		if (counterTwo > maximumFrequency)
		{
			maximumFrequency = counterTwo;
			maximumNumber = "2";
		}
		if (counterThree > maximumFrequency)
		{
			maximumFrequency = counterThree;
			maximumNumber = "3";
		}
		if (counterFour > maximumFrequency)
		{
			maximumFrequency = counterFour;
			maximumNumber = "4";
		}
		if (counterFive > maximumFrequency)
		{
			maximumFrequency = counterFive;
			maximumNumber = "5";
		}
		if (counterSix > maximumFrequency)
		{
			maximumFrequency = counterSix;
			maximumNumber = "6";
		}
		if (counterSeven > maximumFrequency)
		{
			maximumFrequency = counterSeven;
			maximumNumber = "7";
		}
		if (counterEight > maximumFrequency)
		{
			maximumFrequency = counterEight;
			maximumNumber = "8";
		}
		if (counterNine > maximumFrequency)
		{
			maximumFrequency = counterNine;
			maximumNumber = "9";
		}
		if (counterTen > maximumFrequency)
		{
			maximumFrequency = counterTen;
			maximumNumber = "10";
		}
		
		//Will display the highest number and will replace them with commas.  
		System.out.println("Removing the number that has the highest frequency: " + maximumFrequency);
		finalNumbers = randomNumbers.replace(maximumNumber, "");
		//Gets rid of any double comma problems when removing elements.  
		finalNumbers = finalNumbers.replace(",,", ",");
		
		//Removes the comma at the start of the new output
		if(finalNumbers.charAt(0) == ',')
		{
			finalNumbers = finalNumbers.substring(1,finalNumbers.length());
		}
		//Checks if the comma is at the very end of the list
		if(finalNumbers.charAt(finalNumbers.length()-1) == ',');
		{
			finalNumbers = finalNumbers.substring(0,finalNumbers.length()-1);
		}
		System.out.println("Random Numbers: " + finalNumbers);
		
	}
	
	public static void main(String[] args) {
		randomNumbers();
	}
	
}
