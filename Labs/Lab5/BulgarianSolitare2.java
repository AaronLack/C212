import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BulgarianSolitare2 {
	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/16/20
	 * Distribute 45 into n piles
	 * Method that distributes the piles randomly and 1 method to do the solitaire method.  
	 * Then we take the result of the decks made into a sweep method 
	 * The sweep method completes the solitare method game.
	 * Then, I have a final method that connects these two methods together.  
	 */
	
	public static ArrayList<Integer> makePiles(int decks) {
		Random randPiles = new Random();
		ArrayList<Integer> pileList = new ArrayList<>();
		//Every deck must have at least 1 card
		int cards = 45 - (decks);
		
		//Distributes the 45 cards in decks of random size, 4 times
		//cards will now be equal to the new decks
		for (int i = 0; i < decks - 1; i++)
		{
			int newDeck = randPiles.nextInt(cards+1);
			cards -= newDeck;
			newDeck++;
			pileList.add(newDeck);
		}
		
		//Adds the remaining cards (the 5th deck) to the list
		pileList.add(cards+1);
		
		return pileList;
		
	}
	
	
	public static ArrayList<Integer> sweep(ArrayList<Integer> list) {
		//number holds the value of the list
		int number = list.size();
		for (int i = 0; i < list.size(); i++)
		{
			//subtract 1 from each index
			//Can't have deck of cards that is equal
			int subtractor = list.get(i) -1;
			list.set(i, subtractor);
		}
		
		//Loop that removes all the 0's from array List
		while(list.contains(new Integer (0)))
			list.remove(new Integer(0));
		
		//Add the new pile to the end of the array list
		list.add(number);
		
		return list;
	}
	
	//The loop call sorts the stuf until 1,2,3,4,5,6,7,8,9
	//Sort
	public static ArrayList<Integer > solitare() {
		ArrayList<Integer> startPile = makePiles(5);
		//print new list
		System.out.println(startPile);
		
		//Makes a new array list that is the result to be 1,2,3,4,5,6,7,8,9
		//To compare the startPile and the new actuall stuff.  
		ArrayList<Integer> result = new ArrayList();
		for (int i = 1; i < 10; i++)
		{
			result.add(i);
		}
		
		while(!startPile.containsAll(result))
		{
			startPile = sweep(startPile);
			Collections.sort(startPile);
		}
		
		return startPile;
	}
	
	
	public static void main(String[] args) {
		System.out.println(solitare());

	}

}
