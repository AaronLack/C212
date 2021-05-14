import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 4/24/20
* Class ICE13Array, performing linear and binary search for numbers with an array
* Make a static variable array to be used to fill the array up with numbers and print them
* Then search through the values and calculate the time it takes to run through it.
* Have methods for linearSearch, binarySearch, populating the array, and a frequency timer. 
* Binary Search is complicated to find all positions of elements, so maybe skip that towards the end.
*/


public class ICE13Array {
	
	//Make a static variable arrayList as well and repeat this process.
	//Make a new class and pretty much copy and paste stuff and switch array methods to arrayList methods.
	private static int[] array;
	
	//Linear Search Method
	public static void linearSearch(int[] a, int value) {
		ArrayList<Integer> indexes = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == value) {
				indexes.add(i);
			}
		}
		System.out.println(indexes);
	}

	//Binary Search Method.
	public static int binarySearch(int[] a, int low, int high, int value) {
		//find minimum and max index of where say 3 was found. 
		//return the range of the indexes and put it in an array list.
		//Binary search method uses recursion
		if (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == value) {
				return mid;
			}
			else if (a[mid] < value) {
				return binarySearch(a, mid+1, high, value);
			}
			else {
				return binarySearch(a, low, mid-1, value);
			}
		}
		else {
			return -1;
		}
	}
	
	public static int[] populateArray() {
		array = new int [1000000];
		Random rand = new Random();
		for(int i = 0; i < array.length; i++) {
			int fillArray = rand.nextInt(2000-1000) + 1000;
			array[i] = fillArray;
		}
		return array;
	}
	
	//I used this method especially for debugging, feel free to comment it out for grading purposes
	public static void printArray() {
		for(int n: array) {
			System.out.println(n);
		}
	}
	
	public static String frequency(int input) {
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == input) {
				count++;
			}
		}
		String result = input + " Found " + count + " times";
		return result;
	}

	public static void main(String[] args) { 
		//Linear Search:
		populateArray();
		//printArray();
		Random rand = new Random();
		System.out.println();
		System.out.println("10 random values for linear search: ");
		for (int i = 0; i < 10; i++) {
			StopWatch timer = new StopWatch();
			int input = rand.nextInt(2000-1000) + 1000;
			System.out.println(frequency(input));
			System.out.print(input + " found at positions: ");
			timer.start();
			linearSearch(array, input);
		    timer.stop(); 
		    System.out.println("Elapsed time: " + timer.getElapsedTime() + " milliseconds");
		    System.out.println();
		}

		//Binary Search:
		//The time is much smaller for binary search method since it is a more efficient algorithm. 
		System.out.println();
		Arrays.sort(array); 
		//printArray();
		System.out.println("10 random values for binary search:");
		for (int i = 0; i < 10; i++) {
			StopWatch timer = new StopWatch();
			int input = rand.nextInt(2000-1000) + 1000;
			System.out.println(frequency(input));
			//System.out.print(input + " found at positions: ");
			timer.start();
			binarySearch(array, 1000, 2000, input);
			timer.stop(); 
		    System.out.println("Elapsed time: " + timer.getElapsedTime() + " milliseconds");
			System.out.println();
		}
	}
}
		
	  
	
	
		
			
			

	
		
