import java.awt.Color;
import java.awt.Graphics;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/1/20
 * Class Quadrilateral, inherits shape
 * A quadrilateral, needs 4 closed sides of any length. Examples  Rectangle, Square, etc 
 * Add instance variables height and width and include them in all three constructors. 
 * toString will have everything to compare all abstract methods and the name of the shape.  
 */

public class Quadrilateral extends Shape{
	
	//Just assume the points are just there
	int height;
	int width;
	
	//First Constructor to fill a border color and a fill color.
	//2 arrays: 1 for x points and for for y points
	//x,y are for location, height and width are the size. 
	public Quadrilateral(Color fillColor, Color borderColor, int x, int y, int height, int width, int xDirection, int yDirection) {
		super(fillColor, borderColor, x, y, xDirection, yDirection);
		this.height = height;
		this.width = width;
		
	}
	
	//Second constructor case for set borderColor to Black since not provided 
	//super: calls constructor of whatever your implementing
	public Quadrilateral(Color fillColor, int x, int y, int xDirection, int yDirection, int height, int width) { 
		super(fillColor, x, y, xDirection, yDirection);
		this.height = height;
		this.width = width;
		
	}
	
	//Third constructor case: set fillColor to white and border color to black 
	public Quadrilateral(int x, int y, int height, int width, int xDirection, int yDirection) { 
		super(x,y, xDirection, yDirection);
		this.height = height;
		this.width = width;
	}
	
	//Generates Getters and Setters
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
	
	//Name of shape, color and location, and area of shape
	public String toString() {
		return "[" + "Name of Shape: Quadrilateral " + "Location: " + this.getLocation() + "Fill Color: " + this.getFillColor() + "Border Color: " + this.getBorderColor() + "Area: " + this.getArea() + "]"; 
	}
	
	@Override
	void draw(Graphics g) {
		//Start by filling rectangle and squares
		g.setColor(getFillColor());
		g.drawRect(this.getX(), this.getY(), width, height);
		g.fillRect(this.getX(), this.getY(), width, height);	 	
	}

	@Override
	double getArea() {
		return width*height;
	}

}
