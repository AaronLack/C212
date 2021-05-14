
public class Strings {
	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/10/20
	 * In this program, I will write a method that takes in three strings and returns a boolean
	 * Nothing is case sensitive,
	 * You need to add string 1, string2 to equal string three to get the same length.  
	 * You can't just add, since the order of the characters can be switched and it will still be true.  
	 * To check, do string.equals 
	 *
	 */
	
	public static String equalStrings(String stringOne, String stringTwo, String stringThree) {
		//First, make sure the strings work for both uppercase and lowercase letters.  Not case sensitive.  
		stringOne = stringOne.toLowerCase();
		stringTwo = stringTwo.toLowerCase();
		stringThree = stringThree.toLowerCase();
		//check if the lengths of stringOne+stringTwo = stringThree
		if(stringOne.length() + stringTwo.length() == stringThree.length())
		{
			//For loop for the first string to replace it with it's characters
			for(int i = 0; i < stringOne.length(); i++)
			{
				stringThree = stringThree.replaceFirst(stringOne.substring(i,i+1), "");
			}
			//For loop for the second string to replace it with it's characters
			for(int i = 0; i <stringTwo.length(); i++)
			{
				stringThree = stringThree.replaceFirst(stringTwo.substring(i,i+1), "");
			}
			// "" is a condition that I set in my two for loops when using the replaceFirst method.
			if(stringThree.equals(""))
			{
				return("True");
			}
		}
		return("False");
	}
	public static void main(String[] args) {
		//True Case
		System.out.println(equalStrings("abc","Def", "dabecf"));
		//False Case
		System.out.println(equalStrings("abc","DEF", "WxyzKl"));

	}

}
