import java.awt.Color;

/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 4/1/20
* Class Circle, inherits Oval.
* Call the three constructors, all methods will be the same except for toString so make sure to change that.
* Will be less code than the inherited method.   
*/

public class Circle extends Oval{

	//All I'm going to do is pass in radius1 twice so the dimensions are the same for a circle
	//Constructor number 1: border color and a fill color
	public Circle(Color fillColor, Color borderColor, int x, int y, int xDirection, int yDirection, int radius1) {
		super(fillColor, borderColor, x, y, xDirection, yDirection, radius1, radius1);
		
	}
	
	//Second constructor case for set borderColor to Black since not provided 
	public Circle(Color fillColor, int x, int y, int xDirection, int yDirection, int radius1) { 
		super(fillColor, x, y, xDirection, yDirection, radius1, radius1);
	}
	
	//Third constructor case: set fillColor to white and border color to black 
	public Circle(int x, int y, int xDirection, int yDirection, int radius1) { 
		super(x, y, xDirection, yDirection, radius1, radius1);
	}
	
	//Name of shape, color and location of shape
		public String toString() {
			return "[" + "Name of Shape: Circle " + "Location: " + this.getLocation() + "Fill Color: " + this.getFillColor() + "Border Color: " + this.getBorderColor() + "Area: " + this.getArea() + "]"; 
		}

}
