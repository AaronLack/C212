import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/22/20
 * Class Stocks, for problem two in the lab
 * Need a buy, sell, and stockMarketSimulator Method method.
 * Market simulator will take care of the amount gain or loss for a certian stock. 
 * Keep a queue of objects of type Block
 * Add a JUNIT Test at the end as well.
 */


public class Stocks {
	
	//Private instance variable to keep track of all the stocks
	private Map<String, Queue<Block>> portfolio;
	
	//Constructor that puts the portfolio to create a new hashMap.
	public Stocks() {
		portfolio = new HashMap<>();
	}
	
	public void buy(String name, int quantity, int pricePerShare) {
		if(!portfolio.containsKey(name)) {
			portfolio.put(name,  new LinkedList<>());
		}
		portfolio.get(name).add(new Block(quantity, pricePerShare));
	}
	
	public String sell(String name, int pricePerShare) {
		int quantity = portfolio.get(name).peek().getQuantity();
		int sellingTotal = quantity * pricePerShare;
		int pricePaid = portfolio.get(name).remove().getTotalPrice();
		int difference = sellingTotal - pricePaid;
		return "You earned: " + "$" + difference;
	}
	
	//For this method, I will have them either quit or continue by typing in anything
	//Then, I will ask if they want to buy or sell
	public void stockMarketSimulator() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type quit to exit program, otherwise, type anything to continue");
		String firstInput = sc.next();
		//A while loop saying that they didn't enter quit
		while (!firstInput.equalsIgnoreCase("quit")) {
			System.out.println("Type buy or sell");
			String input = sc.next();
			//If they are buying, prompt user to put in values from buy method and then call that method
			if (input.equalsIgnoreCase("buy")) {
				System.out.println("Enter the name of the stock: ");
				String name = sc.next();
				System.out.println("Enter the quantity: ");
				int quantity = sc.nextInt();
				System.out.println("Enter the price per share: ");
				int pricePerShare = sc.nextInt();
				buy(name, quantity, pricePerShare);
			}
			//If they are selling, prompt user to put in values from sell method and then call that method
			else if (input.equalsIgnoreCase("sell")) {
				System.out.println("Enter the name of the stock: ");
				String name = sc.next();
				System.out.println("Enter a price per share to sell at: ");
				int pricePerShare = sc.nextInt();
				System.out.println(sell(name, pricePerShare));
			}
			//Again, prompt user if they want to continue or exit. 
			System.out.println("Type quit to exit program, otherwise, press anything to continue");
			firstInput = sc.next();
		}
	}
	
	public static void main(String[] args) {
		//Just call the stockMarketSimulator method from making a new stocks object.
		Stocks stock = new Stocks();
		stock.stockMarketSimulator();
	}
	
}
