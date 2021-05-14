import java.util.Scanner;

/* I will have a user input an integer using the scanner class.  
 * The integer will be stored into a variable when doing user input.  
 * I will then type cast that variable (char) to return the ASCII value
 * ASCII symbols source: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
 * 
 * 
 * @Author Aaron Lack, alack
 * Last Edited: 1/28/20
 */
public class Lab2Character {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a integer: ");
		int input = sc.nextInt();
		char convert = (char)(input);
		System.out.println(convert);
	} 

}
