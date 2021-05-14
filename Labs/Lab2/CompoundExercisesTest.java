/* I am using a main function to test and play around with pre and post increments for CompoundedExercises
 * @Author Aaron Lack, alack
 * Last Edited: 1/28/20
 */

public class CompoundExercisesTest {

	public static void main(String[] args) {
		int result = -1;
		System.out.println(result);
		
		// We want the result to be -2 
		result = --result;
		System.out.println(result);
		
		// Now we want the result to be 4
		result = ++result + ++result + ++result + ++result + result++;
		System.out.println(result);
		
		// Now we want the result to be 2
		result = result-- - --result;
		System.out.println(result);
		
		// Now we want the result to be 5
		result = result++ + result++;
		System.out.println(result);
		
		// Now we want the result to go back to 2
		result = result-- - --result;
		System.out.println(result);
		
		System.out.println("\n");
		
		int i = -5;
        i++;
        System.out.println(i);    // "-4"
        ++i;                     
        System.out.println(i);    // "-3"
        System.out.println(--i);  // "-4"
        System.out.println(i--);  // "-4"
        System.out.println(++i);  // "-4"

	}

}
