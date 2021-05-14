import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 4/1/20
* Class Oval, inherits Shape.
* Create instance variables radius1 and radius2
* Will be less code than the inherited method.   
*/

public class Oval extends Shape{

	//x and y are the locations
	//An oval has a radius1 a, and a radius2 b, where a > b. similar to height and width
	private int radius1;
	private int radius2;
	
	//Constructor number 1: border color and a fill color
	public Oval(Color fillColor, Color borderColor, int x, int y, int xDirection, int yDirection, int radius1, int radius2) {
		super(fillColor, borderColor, x, y, xDirection, yDirection);
		this.radius1 = radius1;
		this.radius2 = radius2;
	}
	
	//Second constructor case for set borderColor to Black since not provided 
	public Oval(Color fillColor, int x, int y, int xDirection, int yDirection, int radius1, int radius2) { 
		super(fillColor, x, y, xDirection, yDirection);
		this.radius1 = radius1;
		this.radius2 = radius2;
	}
	
		
	//Third constructor case: set fillColor to white and border color to black 
	public Oval(int x, int y, int xDirection, int yDirection, int radius1, int radius2) { 
		super(x,y, xDirection, yDirection);
		this.radius1 = radius1;
		this.radius2 = radius2;
	}

	//Name of shape, color, location and area of shape
	public String toString() {
		return "[" + "Name of Shape: Oval " + "Location: " + this.getLocation() + "Fill Color: " + this.getFillColor() + "Border Color: " + this.getBorderColor() + "Area: " + this.getArea() + "]"; 
	}
	
	@Override
	void draw(Graphics g) {
		g.setColor(getFillColor());
		g.drawOval(this.getX(), this.getY(), radius1, radius2);
		g.fillOval(this.getX(), this.getY(), radius1, radius2);
	}
	
	//Gets radius1 for the circle when overriding the area method
	public int getRadius1() {
		return radius1;
	}

	@Override
	double getArea() {
		return Math.PI * radius1 * radius2;
		//return radius1;
	}

}
