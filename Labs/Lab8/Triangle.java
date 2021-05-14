import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 3/11/20
* Class Triangle, inherits Shape.
* Create instance variables height, width, and array of xPoints and yPoints. 
* I am hard coding the values of the points, assuming the triangle is equilateral. 
* Will be less code than the inherited method.   
* toString will have everything to compare all abstract methods and the name of the shape. 
*/

public class Triangle extends Shape{
	//I want to create triangle
	private int height; //How tall the triangle is
	private int width; //Side length
	private int[] xPoints = new int[3];
	private int[] yPoints = new int[3];
	
	
	public Triangle(Color fillColor, Color borderColor, int x, int y, int height, int width) {
		super(fillColor, borderColor, x, y);
		this.height = height;
		this.width = width;
		this.xPoints = new int[] {x, x+width/2, x-width/2};
		this.yPoints = new int[] {y, height+y, height+y};
	}
	
	//Second constructor case for set borderColor to Black since not provided 
	public Triangle(Color fillColor, int x, int y, int height, int width) { 
		super(fillColor, x, y);
		this.height = height;
		this.width = width;
		this.xPoints = new int[] {x, x+width/2, x-width/2};
		this.yPoints = new int[] {y, height+y, height+y};
		
	}
	
	//Third constructor case: set fillColor to white and border color to black 
	public Triangle(int x, int y, int height, int width) { 
		super(x, y);
		this.height = height;
		this.width = width;
		this.xPoints = new int[] {x, x+width/2, x-width/2};
		this.yPoints = new int[] {y, height+y, height+y};
	}

	//Generate Getters and Setters
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

	public int[] getxPoints() {
		return xPoints;
	}

	public void setxPoints(int[] xPoints) {
		this.xPoints = xPoints;
	}

	public int[] getyPoints() {
		return yPoints;
	}

	public void setyPoints(int[] yPoints) {
		this.yPoints = yPoints;
	}

	
	//Name of shape, color and location, area, and perimeter of shape
	public String toString() {
		return "[" + "Name of Shape: Triangle " + "Location: " + this.getLocation() + "Fill Color: " + this.getFillColor() + "Border Color: " + this.getBorderColor() + "Area: " + this.getArea() + "Perimeter: " + this.getPerimeter() + "]"; 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		if (!Arrays.equals(xPoints, other.xPoints))
			return false;
		if (!Arrays.equals(yPoints, other.yPoints))
			return false;
		return true;
	}

	@Override
	void draw(Graphics g) {
		g.drawPolygon(xPoints,yPoints,3);
		g.fillPolygon(xPoints,yPoints,3);
	}

	@Override 
	double getArea() {
		return (width*height) / 2;
	}

	@Override
	double getPerimeter() {
		return width*3;
	}

}
