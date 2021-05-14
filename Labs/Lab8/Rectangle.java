import java.awt.Color;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 3/11/20
 * Class Rectangle, inherits Quadrilateral.
 * Call the three constructors, all methods will be the same except for toString so make sure to change that.
 * Will be less code than the inherited method.   
 */

public class Rectangle extends Quadrilateral {

	//Constructor number 1: border color and a fill color
	public Rectangle(Color fillColor, Color borderColor, int x, int y, int height, int width) {
		super(fillColor, borderColor, x, y, height, width);
	
	}
	
	//Second constructor case for set borderColor to Black since not provided 
	public Rectangle(Color fillColor, int x, int y, int height, int width) {
		super(fillColor, x, y, height, width);
	}
	
	//Third constructor case: set fillColor to white and border color to black 
	public Rectangle(int x, int y, int height, int width) {
		super(x, y, height, width);
	}
	
	//Name of shape, color and location, area, and perimeter of shape
	public String toString() {
		return "[" + "Name of Shape: Rectangle " + "Location: " + this.getLocation() + "Fill Color: " + this.getFillColor() + "Border Color: " + this.getBorderColor() + "Area: " + this.getArea() + "Perimiter: " + this.getPerimeter() + "]"; 
	}
		

}
