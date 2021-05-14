import java.util.Arrays;

/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/21/20
	 * Testing my 3 classes, make 3 new objects.
	 * Use a scannable array that prints the objects and the costs for the scanMe method
	 * Then use the comparable method to compare prices.  
	 */

public class PBJSandwichTest {

	public static void main(String[] args) {
		
		Peanutbutter smooth = new Peanutbutter("Jiffy", 6.25, "10/3/2020", "123456");
		Jelly grape = new Jelly("Smuckers", 3.50, "5/5/2021", "654321");
		Bread wheat = new Bread("Sara Lee", 5.0, "3/25/2020", "773202");
		
		Scannable[] sandwich = new Scannable[3];
		sandwich[0] = smooth;
		sandwich[1] = grape;
		sandwich[2] = wheat;
		
		//Print all the items
		for (int i = 0; i < sandwich.length; i++) {
			System.out.println(sandwich[i]);
		}
		
		System.out.println();
		
		//Print the costs using the scannable interface
		System.out.println("Costs: ");
		for (Scannable pbj: sandwich) {
			System.out.println(pbj.scanMe());
		}
		
		System.out.println();
		
		 
		
		//Comparable Interface: Prices from most expensive to least expensive. 
		System.out.println("Comparing To: ");
		Comparable[] shoppingCart = new Comparable[3];
		shoppingCart[0] = smooth;
		shoppingCart[1] = grape;
		shoppingCart[2] = wheat;
		
		Arrays.sort(shoppingCart);
		
		for (Comparable obj: shoppingCart) {
			System.out.println(obj.getClass());
		}

	}

}
