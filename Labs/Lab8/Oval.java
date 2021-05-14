import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 3/11/20
* Class Oval, inherits Shape.
* Create instance variables radius1 and radius2
* The area and circumference will also be slightly different than Oval, so override that as well.  
* Will be less code than the inherited method.   
*/

public class Oval extends Shape{

	//x and y are the locations
	//An oval has a radius1 a, and a radius2 b, where a > b. similar to height and width
	private int radius1;
	private int radius2;
	
	//Constructor number 1: border color and a fill color
	public Oval(Color fillColor, Color borderColor, int x, int y, int radius1, int radius2) {
		super(fillColor, borderColor, x, y);
		this.radius1 = radius1;
		this.radius2 = radius2;
	}
	
	//Second constructor case for set borderColor to Black since not provided 
	public Oval(Color fillColor, int x, int y, int radius1, int radius2) { 
		super(fillColor, x, y);
		this.radius1 = radius1;
		this.radius2 = radius2;
	}
	
		
	//Third constructor case: set fillColor to white and border color to black 
	public Oval(int x, int y, int radius1, int radius2) { 
		super(x,y);
		this.radius1 = radius1;
		this.radius2 = radius2;
	}
	
	public int getRadius2() {
		return radius2;
	}

	public void setRadius2(int radius2) {
		this.radius2 = radius2;
	}

	public void setRadius1(int radius1) {
		this.radius1 = radius1;
	}

	//Name of shape, color and location, area, and perimeter of shape
	public String toString() {
		return "[" + "Name of Shape: Oval " + "Location: " + this.getLocation() + "Fill Color: " + this.getFillColor() + "Border Color: " + this.getBorderColor() + "Area: " + this.getArea() + "Circumference: " + this.getPerimeter() + "]"; 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oval other = (Oval) obj;
		if (radius1 != other.radius1)
			return false;
		if (radius2 != other.radius2)
			return false;
		return true;
	}

	
	//Gets radius1 for the circle when overriding the area and perimeter methods.  
	public int getRadius1() { 
		return radius1;
	}
	
	@Override
	void draw(Graphics g) {
		g.drawOval(this.getX(), this.getY(), radius1, radius2);
		g.fillOval(this.getX(), this.getY(), radius1, radius2);
	}

	@Override
	double getArea() {
		return Math.PI * radius1 * radius2;
	}

	@Override
	//This is an approx of the circumference sine the equation for this shape is complicated.  
	double getPerimeter() {
		return 2 * Math.PI * Math.sqrt((radius1 + radius2) /2);
	}

}
