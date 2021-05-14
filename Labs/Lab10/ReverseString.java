
/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/10/20
 * Class ReverseString, make an iterative method to reverse the characters of the string
 * Do the same for recursion, but also make a helper function so that the recursive call is done properly in main
 * The recursive helper function will call the recursive function for reversing the string
 * In main, call the functions.  
 */


public class ReverseString {
	//Make a method that reverses the string without using string buffer
	
	public static String reverseString(String str) {
		String result = "";
		for(int i = str.length() - 1; i >= 0; i--) { 
			result += str.charAt(i);
		}
		return result;
		
	}
	
	public static String reverseRecur(String str, StringBuilder reverseStr) {
		if (str.length() == 0) {
			return reverseStr.toString();
		}
		else {
			String removeFirstCharString = str.substring(0,str.length()-1);
			return reverseRecur(removeFirstCharString, reverseStr.append(str.charAt(str.length()-1)));
		}
	}
	
	//Helper funtion that gets called in main
	public static String recursiveResult(String str) {
		return reverseRecur(str, new StringBuilder());
	}

	
	public static void main(String[] args) {
		System.out.println("Iterative");
		System.out.println(reverseString("Hello!"));
		System.out.println();
		System.out.println("Recursive");
		System.out.println(recursiveResult("Hello!"));
	}
		

}
