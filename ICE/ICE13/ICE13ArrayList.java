import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 4/24/20
* Class ICE13ArrayList, performing linear and binary search for numbers with an ArrayList
* Make a static variable array to be used to fill the array up with numbers and print them
* Then search through the values and calculate the time it takes to run though it. 
* Have methods for linearSearch, binarySearch, populating the array, and a frequency timer.
* Binary Search is complicated to find all positions of elements, so maybe skip that towards the end.
*/

public class ICE13ArrayList {
	
	//Make a static variable arrayList as well and repeat this process.
	//Make a new class and pretty much copy and paste stuff and switch array methods to arrayList methods.
	private static ArrayList<Integer> arrayList;
		
	//Linear Search Method
	public static void linearSearch(ArrayList<Integer> a, int value) {
		ArrayList<Integer> indexes = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			if (a.get(i) == value) {
				indexes.add(i);
			}
		}
		System.out.println(indexes);
	}

	//Binary Search Method.
	public static int binarySearch(ArrayList<Integer> a, int low, int high, int value) {
		//find minimum and max index of where say 3 was found. 
		//return the range of the indexes and put it in an array list.
		//Binary search method uses recursion
		if (low <= high) {
			int mid = (low + high) / 2;
			if (a.get(mid) == value) {
				return mid;
			}
			else if (a.get(mid) < value) {
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
		
	public static ArrayList<Integer> populateArray() {
		arrayList = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i = 0; i < 1000000; i++) {
			int fillArray = rand.nextInt(2000-1000) + 1000;
			arrayList.add(fillArray);
		}
		return arrayList;
	}
		
	public static void printArray() {
		for(int n: arrayList) {
			System.out.println(n);
		}
	}
		
	public static String frequency(int input) {
		int count = 0;
		for(int i = 0; i < 1000000; i++) {
			if(arrayList.get(i) == input) {
				count++;
			}
		}
		String result = input + " Found " + count + " times";
		return result;
	}
	
	public static void main(String[] args) {
		//Linear Search:
		//You have to put the timer in the for loop since that is where the method is being called.
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
			linearSearch(arrayList, input);
			timer.stop(); 
		    System.out.println("Elapsed time: " + timer.getElapsedTime() + " milliseconds");
		    System.out.println();
		}

		//Binary Search:
		//The time is much smaller for binary search method since it is a more efficient algorithm. 
		System.out.println();
		Collections.sort(arrayList); 
		//printArray();
		System.out.println("10 random values for binary search:");
		for (int i = 0; i < 10; i++) {
			StopWatch timer = new StopWatch();
			int input = rand.nextInt(2000-1000) + 1000;
			System.out.println(frequency(input));
			//System.out.print(input + " found at positions: ");
			timer.start();
			binarySearch(arrayList, 1000, 2000, input);
			timer.stop(); 
		    System.out.println("Elapsed time: " + timer.getElapsedTime() + " milliseconds");
			System.out.println();
			}
		}

	}
