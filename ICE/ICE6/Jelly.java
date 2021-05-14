
	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/21/20
	 * Creating a Jelly class with 4 instance variables: name, price, experationDate, and barcode.
	 * Generate constructor, getters, and setters.
	 * Generate toString(),
	 * Generate a scanMe method from Scannable interface that returns the price of the object.
	 * Finally, Generate a compare me method that compares price of Peanutbutter, Jelly and Bread
	 */

public class Jelly implements Scannable, Comparable {
	
	
	private String name;
	private double price;
	private String experationDate;
	private String barcode;
	
	public Jelly(String name, double price, String experationDate, String barcode) {
		super();
		this.name = name;
		this.price = price;
		this.experationDate = experationDate;
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getExperationDate() {
		return experationDate;
	}
	public void setExperationDate(String experationDate) {
		this.experationDate = experationDate;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	@Override
	public String toString() {
		return "Jelly [name=" + name + ", price=" + price + ", experationDate=" + experationDate + ", barcode="
				+ barcode + "]";
	}
	
	@Override
	public double scanMe() {
		double cost = this.price;
		return cost;
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Peanutbutter) {
			Peanutbutter other = (Peanutbutter) obj;
			if(price >other.scanMe()) {
				return -1;
			}
			else if(price<other.scanMe()) {
				return 1;
			}
			else {
				return 0;
			}
		}
			
		else if(obj instanceof Jelly) {
			Jelly other = (Jelly) obj;
			if(price >other.scanMe()) {
				return -1;
			}
			else if(price<other.scanMe()) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		else {
			Bread other = (Bread) obj;
			if(price >other.scanMe()) {
				return -1;
			}
			else if(price<other.scanMe()) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}

}
