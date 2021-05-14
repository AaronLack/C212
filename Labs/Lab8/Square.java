import java.awt.Color;

/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 3/11/20
* Class Square, inherits Rectangle.
* Call the three constructors, all methods will be the same except for toString so make sure to change that.
* Will be less code than the inherited method.   
*/

public class Square extends Rectangle{ 

	//All Im gonna do is pass in height twice so the dimensions are the same for a square
	
	//Constructor number 1: border color and a fill color
	public Square(Color fillColor, Color borderColor, int x, int y, int height) {
		super(fillColor, borderColor, x, y, height, height);
	}
	
	//Second constructor case for set borderColor to Black since not provided 
	public Square(Color fillColor, int x, int y, int height) {
		super(fillColor, x, y, height, height);
	}
	
	//Third constructor case: set fillColor to white and border color to black 
	public Square(int x, int y, int height) {
		super(x, y, height, height);
	}
	
	//Name of shape, color and location, area, and perimeter of shape
	public String toString() {
		return "[" + "Name of Shape: Rectangle " + "Location: " + this.getLocation() + "Fill Color: " + this.getFillColor() + "Border Color: " + this.getBorderColor() + "Area: " + this.getArea() + "Perimiter: " + this.getPerimeter() + "]"; 
	}

}
