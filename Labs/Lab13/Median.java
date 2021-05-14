import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.Timer;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 5/3/20
 * Class median, for lab 13
 * Pseudocode for this problem:
 * 
 * Let m be median of a sequence of n elements. 
 * e<=m for half of the elements, m <= e for the other half.
 * a(inclusive) and b (exclusive)
 * Median: k = n/2, a = 0, b = n.
 * 
 * select(k, a, b):
 * Pick a pivot p in the subsequence between a and b
 * Partition the subsequence elements into three subsequences: the elements  < p, = p, and > p.
 * Let n1, n2, and n3 be the sizes of each of these subsequences.
 * if k < n1
 * 		return select(k, 0, n1)
 * else if k >= n1+n2
 * 		return select(k, n1+n2, n)
 * else
 *		return p
 *
 * Run this program multiple times to get different outputs, same goes for JUNIT.
 *
 */

public class Median {
	
	//Static instance variables for this class
	static ArrayList<Integer> sort = new ArrayList<Integer>();
	static Random rand = new Random();
	
	//Select algorithm given up above
	public static int select(int k, int a, int b) {
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		
		int pivot = sort.get(rand.nextInt(b-a)+a);
		
		for(int i = 0; i < sort.size(); i++) {
			int size = sort.get(i);
			if(size < pivot) {
				n1++;
			}
			else if(size == pivot) {
				n2++;
			}
			else {
				n3++;
			}
		}
		
		if(k < n1) {
			return select(k, 0, n1);
		}
		else if (k >= (n1+n2)) {
			return select(k, n1+n2, sort.size()); //return b since b = n.
		}
		else {
			return pivot;
		}
	}
	
	//Adds 100001 random numbers 1-100 to arraylist sort 
	public void addNumbers() {
		for(int i = 0; i < 100001; i++) {
			int fillArray = 1 + rand.nextInt(100);
			sort.add(fillArray);
		}
	}
	
	//Checks to make sure that the median for the select method and the normalSort method are equal
	public boolean equals() {
		int selectSort = select(sort.size()/2, 0, sort.size());
		System.out.println("select median: " + selectSort);
		int normalSort = normalSort();
		System.out.println("normal median: " + normalSort);
		return selectSort == normalSort;
	}
	
	//The other sort method we are comparing
	public static int normalSort() {
		Collections.sort(sort);
		return sort.get(sort.size()/2);
	}
	
	//Calculates the runtime of each algorithm using the StopWatch class
	public static boolean compareTime() {
		StopWatch timer = new StopWatch();

		//Get elapsed time of select method
		timer.start();
		select(sort.size()/2, 0, sort.size());
		timer.stop();
		long selectTime = timer.getElapsedTime();
		System.out.println("Elapsed time for select algorithm: " + timer.getElapsedTime() + " milliseconds");
		
		//Get elapsed time for the normalSort method
		timer.start();
		normalSort();
		timer.stop();
		long normalSortTime = timer.getElapsedTime();
		System.out.println("Elapsed time for collections.sort() algorithm: " + timer.getElapsedTime() + " milliseconds");
		
		if(selectTime < normalSortTime) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		StopWatch timer = new StopWatch();
		Median check = new Median();
		check.addNumbers();
		System.out.println(check.equals());
		System.out.println();
		System.out.println(compareTime());
	}

}
