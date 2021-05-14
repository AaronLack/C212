/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/22/20
 * Class Block, used to create the stocks
 * Create instance variables quantity and pricePerShare.
 * Generate constructor and and appropriate getters. 
 * Add a JUNIT Test at the end as well.
 */
public class Block {
	
	//Instance Variables
	private int quantity;
	private int pricePerShare;
	private int totalPrice;
	
	//Constructor
	public Block(int quantity, int pricePerShare) {
		this.quantity = quantity;
		this.pricePerShare = pricePerShare;
		totalPrice = pricePerShare * quantity;
	}
	
	//Getters
	public int getPricePerShare() {
		return pricePerShare;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
}
