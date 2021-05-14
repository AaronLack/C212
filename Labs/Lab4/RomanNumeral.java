
public class RomanNumeral {
	/*
	 * @author: Aaron Lack, alack
	 * Last edited: 2/7/20
	 * Create a switch case method that evaluates all the possible char integer values.  
	 * These include I,V,X,L,C,D,M
	 * Then create another function that converts it. 
	 * For the Roman numeral function, I need to account for the length of the Roman numerals
	 * And call the switch case values method based on the length of the input.  
	 * I read a great article from this on how to implement this function.
	 * Website: https://www.codespeedy.com/converting-roman-numerals-into-integer-numbers-value-in-java/
	 */
	
	
	public static int converter(char letter) {
		//Have a place holder to set the value
		//Write a switch case statement with appropriate values and symbols
		int value = 0;
		switch(letter)
		{
		case 'I': value = 1; break;
		case 'V': value = 5; break;
		case 'X': value = 10; break;
		case 'L': value = 50; break;
		case 'C': value = 100; break;
		case 'D': value = 500; break;
		case 'M': value = 1000; break;
		default: System.out.println("Input out of range");
		}
		return value;
	}

	public static int RomanNumeralToNumber(String number) {
		int length = number.length();
		int intgerForm = converter(number.charAt(0));
		
		//integerForm is the switch case value at index of 0, (aka of length 1).  It calls those values
		//In the cases of a Roman numeral of length 1 and 0, refer to the switch case statements. 
		//The first condition checks if a Roman numeral has a length of 2
		//When a Roman numeral has a length of 2, (ex: IV (4), VI (6)
		//IV: charAt(0): I, charAt(1): 5.  So if 5>1, subtract to get 4. else, add to get 6
		 
		if (length == 2)
		{
			if (converter(number.charAt(1)) > intgerForm)
			{	//EX: 5-1 to properly get 4
				intgerForm = converter(number.charAt(1)) - intgerForm;
			}
			else
			{	//EX: 5+1 to properly get 6
				intgerForm = converter(number.charAt(1)) + intgerForm;
			}
		}
		else
		{
			int counter = 0;
			intgerForm = 0;
				
			//While the length of a Roman integer is more than 2
			//Counter is the index of the Roman numeral index.  
			//This code does something similar to the first if statement but iterates multiple times
			//The iterations and indexes are based on the length of the Roman numeral
			while (counter < length - 1)
			{	//Iterates through the appropriate length and the counter
				if (converter(number.charAt(counter)) >= converter(number.charAt(counter + 1)))
				{
					intgerForm = intgerForm + converter(number.charAt(counter));
					counter = counter + 1;
				}
				else
				{
					intgerForm = intgerForm + converter(number.charAt(counter + 1)) - converter(number.charAt(counter));
					counter = counter + 2;
				}
			}
			//This if is for Roman numeral values of length 1.  Calls the switch case methods
			if (counter == length - 1)
			{
				intgerForm = intgerForm + converter(number.charAt(counter));
			}
		}
		//This deals with any negative inputs
		return Math.abs(intgerForm); 
	}
	
	public static void main(String[] args) {
		
		//1978
		System.out.println(RomanNumeralToNumber("MCMLXXVIII"));
	}

}
