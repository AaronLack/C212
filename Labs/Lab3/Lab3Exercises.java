import java.io.IOException;
import java.util.*;

/*
 * Header
 * Lab 3 Exercises
 * @Author: Aaron Lack, alack
 * Last edited: 2/5/20
 * 
 */

public class Lab3Exercises {
	/* 
	 * Pseudocode for 2A:
	 * I will use a scanner class that inputs an integer.
	 * Then I will reverse it using a string
	 * Then I will convert reversed number back into an int and subtract the two
	 * Then I will reverse that difference (string)
	 * The I will add the two numbers.
	 * Main is just input output base,
	 * you can test logic in main and then copy and paste it in the function and then call the function
	 */

	public static int my1089puzzle(int myInput) {
		
		//This cuts a number to the last three digits
		int inputThreeDigits = myInput%1000; 
		
		//inputToString Converts to string so we can reverse	it
		String inputToString = Integer.toString(inputThreeDigits); 
		
		//firstReverse is the reverse number of input
		StringBuffer firstReverse = new StringBuffer(inputToString);	
		firstReverse.reverse();
		
		//convert firstReverse to an integer
		int firstReverseToInteger = Integer.parseInt(firstReverse.toString()); 
		
		//Subtract reverse value from input, absolute value fixes sign issues
		int difference = Math.abs(firstReverseToInteger - inputThreeDigits);	 
		
		//Converts the difference into a string to reverse
		String differenceToString = Integer.toString(difference); 
		
		
		//reverse the difference now
		StringBuffer secondReverse = new StringBuffer(differenceToString);
		secondReverse.reverse();
		
		//convert secondReverse back to an integer
		int secondReverseToInteger = Integer.parseInt(secondReverse.toString()); 
		
		//Computes the sum
		int sum = secondReverseToInteger + difference; //1089
		
		return sum;
		
	}
	
	/*
	 * Pseudocode for 2B:
	 * 
	 * If string is not valid phone number (not length 10), return not valid phone number. 
	 * Read in a phone number using a scanner class. put in 2342342334. no dashes.
	 * Option is going to be passes as true and false for test cases
	 * So when option is true, format it  (234)234-2234
	 * And when you pass in option being false, 234-234-2234  
	 */
	
	public static String formatPhoneNumber(String myNumber, boolean option) {
		if (option == true)
		{
			String newNumber = "(" + myNumber.substring(0,3) + ")" + myNumber.substring(3,6) + "-" + myNumber.substring(6,10);
			return newNumber;
			
		}
		else
		{
			String newNumber = myNumber.substring(0,3) + "-" + myNumber.substring(3,6) + "-" + myNumber.substring(6,10);
			return newNumber;
		
		}
	}
	
	/*
	 * Pseudocode for 2C:
	 * I will write a while loop for numbers 5,19 and display correct inputs in a list or array.  
	 * Using if/else statements, I will have not valid outputs go in else 
	 * Inside the if statements for integers, write a condition that checks if the element is already there
	 * Using a for loop, I will take the array and convert it into a string and add commas to it.  
	 * To exit this program, enter a character. For example: s.  
	 * You will know when to do this when whatever numbers you put in asks you to enter in a correct number.  
	 * If you enter in a number twice, the input statement will not display again, so this is an indication to not do that.  
	 */
	public static String numbersList() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a number between 5-19: ");
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> listInteger = new ArrayList<>();
		while (sc.hasNextInt())
		{
			int input = sc.nextInt();
			if (input >= 5 && input <= 19)
			{
				if (!listInteger.contains(input))
				{
					System.out.println("your input: " + input);
					listInteger.add(input);
				}
			}
			else 
			{
				System.out.println("Enter a correct number between 5-19");
			}
		}
		String convert = ""; 
		
		//For loop to add commas using string builder.   
		
		System.out.println("al is : " + listInteger);
		
		//Appends first element of the list
		sb.append(listInteger.get(0));
		
		for (int i = 1; i < listInteger.size(); i++)
		{
			sb.append(',');
			sb.append(listInteger.get(i));
			
		}
		System.out.println("convert : " + convert);
		return sb.toString();
	}
	
	
	/*
	 * Pseudocode for 2D:
	 * Use the scanner class to have the user enter in A-F 
	 * Use a bunch of if/else statements that takes
	 * Store the description in a variable, and then return the variable.   
	 */
	
	//This code works if I have char yourGrade, but not char, ask if this is ok.  
	public static String grade(char yourGrade) {
		if (yourGrade == 'A') {
			String gradeA = "Your grade is in between a 93.0 and 100";
			return gradeA;
		}
		else if (yourGrade == 'B') {
			String gradeB = "Your grade is in between a 83.0 and 92.99";
			return gradeB;
		}
		else if (yourGrade == 'C') {
			String gradeC = "Your grade is in between a 73.0 and 82.99";
			return gradeC;
		}
		else if (yourGrade == 'D') {
			String gradeD = "Your grade is in between a 63.0 and 72.99";
			return gradeD;
		}
		else {
			String gradeF = "Your grade is less that a 63.0";
			return gradeF;
		}
	}
	
	/*
	 * Pseudocode for 2E:
	 * Ask the user to input a positive integer value
	 * Store a variable where it converts to hex
	 * Return a string
	 * May have to use a for loop
	 * Examples of decimal to hex:
	 * C1 = 193; (12*(16**1)) + (1*(16**0)) =193
	 * 7DE = 2014; (7(16**2)) + (13*(16**1)) + (14*(16**0))
	 * (Sn *B**n) is the formal conversion equation, where S = number digits; b = base, n = power
	 * On the website, you can do this backwards by taking the remainder and the 
	 * For values A-F, subtract the values by 55
	 */
	
	public static String intToHex(int n) { 
		
		//This is an array of all possible characters in Hex
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		//Set remainder to be empty so we can store values here later
		int remainder;
		//The hex must be a string because it can contain letters and numbers
		String sum = "";
		while(n>0)
		{
			remainder = n%16;
			sum = hexDigits[remainder] + sum;
			n = n/16;
		}
		return sum;
		
	}

	
	public static void main(String[] args) 
	{
		//2A
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int input = sc.nextInt();
		System.out.println(my1089puzzle(input)); 
		
		
		//2B
		System.out.print("Please enter a phone number: ");
		String phoneNumber = sc.next();
		System.out.println(formatPhoneNumber(phoneNumber, true)); 
		System.out.println(formatPhoneNumber(phoneNumber, false)); 
		
		//2C
		System.out.println(numbersList());
		
		//2D
		System.out.print("Please enter your letter grade (Capital Letter): ");
		char yourGrade = sc.next().charAt(0);
		System.out.println(grade(yourGrade));
		
		//2E
		System.out.print("Please enter a positive number: ");
		int decimalNumber = sc.nextInt();
		System.out.println(intToHex(decimalNumber));
		
		
		//2F: 
		//i. Give the type and value for each of the following expressions
		
		System.out.println(7.8>78);
		//false, this is a boolean since a condition is being checked. 
		
		System.out.println(12+13+19+21);
		//65, all integers are being added, so this is a type integer.  
		
		System.out.println(2.3+5.7+7.1);
		//15.1, all doubles are being added, so this is a type double.  
		
		System.out.println(2+4+"24");
		//624, it first adds 2+4, and then concatenates 6 with 24.  So this is a type string.
		String myVar = 2+4+"24";
		System.out.println(myVar);
		//624, proof this is a type string.  
		
		//ii.
		//Without compiling the code, guess what the output is.  
		//Then, compile it and compare the actual output with your guess. 
		//After calculating this, I got 9.05 for an output.
		//1. 
//		double t = 9.0;
//		while(Math.abs(t-9.0/t)>.001) {
//			t = (0.9/t + t)/2.0;
//		}
//		System.out.println(t);
		//The actual output is nothing, because t will always be less than .001. I was wrong. 
		//This is because t never gets incremented, you need a t++
	    //
		//If this code is not commented out, any executable code after it wont' display on the console
		
		//2.
		//I think this will print 7 three spaces over.  
		System.out.printf("%03d", 7);
		//Actual output: 007, again I was wrong.  
		
		//3. 
		//I think this will change Bye Bye Bye to Bee Bee Bee
		String s = "Bye Bye Bye";
		s = s.replace('y', 'e');
		System.out.println(s);
		//Actual output: Bee Bee Bee, I was correct (for once lol).  
	

	} 

}
