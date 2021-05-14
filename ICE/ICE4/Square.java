import java.awt.Rectangle;

	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/27/20
	 * In this program, I will inherit the rectangle class and use their code to make a square class
	 * This link is helpful to see the methods of the class Rectangle:
	 * https://docs.oracle.com/javase/7/docs/api/java/awt/Rectangle.html
	 * This link is helpful to see the methods of class Object
	 * https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html
	 * First, define 3 instance variables. 3 because height = width, call it side and x and y are unchanged
	 * Then, area is simply width*height. 
	 * Note: if I do side*side, I will get 0 since side isn't defined a specific value, so make sure to use the 
	 * inherited instance variable for rectangle in this case.  
	 * Side is simply to make sure that the height is equivelant to the width.  
	 * Finally use two string to make a pretty output.  
	 * For odd dimensions, the center point is going to be off by half.  
	 * This is because the setLocation methods can only take integers, and not doubles
	 * and Java truncates integer division.  I hope that is acceptable.  
	 */

public class Square extends Rectangle {
	
	//side is both height and width. This object will take in 3 variables 
	//x and y are the positions, starting at the top left corner. 

	protected int x;
	protected int y;
	protected int side;
	
	//Constructor
	public Square(int x, int y, int side) {
		super();
		this.setLocation(x - (side/2), y - (side/2));
		this.setSize(side,side);
	}
	
	public int getArea() {
		return width * height;
	}
	
	public String toString() {
		return("Center point: " + (x + (width/2)) + "," + (y + (height/2)) + " ~ " + "Dimensions: "
 + width + " by " + height +  " ~ " + "Area: " + this.getArea());
		}
	
	
	

}
