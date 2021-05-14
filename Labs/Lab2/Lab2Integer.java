/* I will define all the variables first.  Then I will type cast them to represent their int value.
 * Then I need to figure out how to format using the printf command to make the output and comparason look pretty and   easy to read.  
 * Lastly, I will watch the Youtube video for the J-Unit testing. 
 * I am putting the ascii values for each character next to the variable assignments. 
 * I got the data from this source: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
 * 
 * 
 * @Author Aaron Lack, alack
 * Last Edited: 1/27/20
 */

public class Lab2Integer {
	 

	public static String characters() {
		
		//I need to ask how to why the main function does not work in JUNIT TESTING.  
		
	
		//Define all 20 characters
		char charA = 'A';			//65
		char charB = 'B';			//66
		char charC = 'C';			//67
		char charZ = 'Z';			//90
		char charX = 'X';			//88
		char char_a = 'a';			//97
		char char_b = 'b';			//98
		char char_c = 'c';			//99
		char char_y = 'y';			//121
		char char_u = 'u';			//117
		char charZero = '0';			//48
		char charNine = '9';			//57
		char charTwo = '2';			//50
		char charDollar = '$';		//36
		char charStar = '*';			//42
		char charGreater = '>';		//62
		char charPipe = '|';			//124
		char charBackslash = '\\' ; 	//92		Double backslash will not create a new line
		char charSpace = (' ');		//32		I put space and tab in () to represent a character
		char charTab = ('	');		//9		The output on the first line for space and tab are present.
		
		
		String result = "";
		
		result = result + (int) charA + " " +(int) charB + " " + (int) charC + " " + (int) charZ + " " + (int) charX + " " + (int) char_a + " " + (int) char_b + " " + (int) char_c + " " + (int) char_y + " " +(int) char_u + " " + (int) charZero + " " +(int) charNine + " " +(int) charTwo + " " + (int) charDollar + " " + (int) charStar + " " +(int) charGreater + " " + (int) charPipe + " " + (int) charBackslash + " " + (int) charSpace + " " + (int) charTab;
		
		System.out.println("result : " + result);
		
		return result;

	}
	public static void main(String[] args) {
		 
		Lab2Integer.characters();
		//className.methodName
	}
}
