import java.awt.Color;

/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 3/11/20
* Class Circle, inherits Oval.
* Call the three constructors, all methods will be the same except for toString so make sure to change that.
* The area and circumference will also be slightly different than Oval, so override that as well.  
* Will be less code than the inherited method.   
*/

public class Circle extends Oval{

	//All Im gonna do is pass in radius1 twice so the dimensions are the same for a circle
	//Constructor number 1: border color and a fill color
	public Circle(Color fillColor, Color borderColor, int x, int y, int radius1) {
		super(fillColor, borderColor, x, y, radius1, radius1);
		
	}
	
	//Second constructor case for set borderColor to Black since not provided 
	public Circle(Color fillColor, int x, int y, int radius1) { 
		super(fillColor, x, y, radius1, radius1);
	}
	
	//Third constructor case: set fillColor to white and border color to black 
	public Circle(int x, int y, int radius1) { 
		super(x, y, radius1, radius1);
	}
	
	//Name of shape, color and location, area, and perimeter of shape
		public String toString() {
			return "[" + "Name of Shape: Circle " + "Location: " + this.getLocation() + "Fill Color: " + this.getFillColor() + "Border Color: " + this.getBorderColor() + "Area: " + this.getArea() + "Circumference: " + this.getPerimeter() + "]"; 
		}
		
	//Override the perimeter and area methods because its different from the oval method.  
	@Override
	double getArea() {
		return Math.pow(getRadius1(), 2); 
	}

	@Override
	double getPerimeter() {
		return 2 * Math.PI * getRadius1();
	}
	

}
