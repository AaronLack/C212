import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 3/11/20
 * Class Polygon, will
 * Add instance variables length, sides, and apothem and include them in all three constructors. 
 * toString will have everything to compare all abstract methods and the name of the shape.
 * The xPoints and yPoints are going to be an array of size sides so it is generic.
 * This is needed or the g.fillPolygon and g.drawPolygon method.   
 */

public class Polygon extends Shape{

	//Keep limit of polygon 0-10; the shapes should be a small size. 
	
	private int length; //the length of sides
	private int sides;//number of sides
	private double apothem; //used to calculate the area of a figure, it is the midpoint of a side drawn perpendicular to a side
	private int[] xPoints = new int[sides];
	private int[] yPoints = new int[sides];
	//The array of x and y points are created in the shapedriver class and all the math
	
	
	//First Constructor to fill a border color and a fill color.
	public Polygon(Color fillColor, Color borderColor, int x, int y, int length, int sides, double apothem, int[] xPoints, int[] yPoints) {
		super(fillColor, borderColor, x, y);
		this.length = length;
		this.sides = sides;
		this.apothem = apothem;
		this.xPoints = xPoints;
		this.yPoints = yPoints;
	}
	
	//Second constructor case for set borderColor to Black since not provided 
	public Polygon(Color fillColor, int x, int y, int length, int sides, double apothem, int[] xPoints, int[] yPoints) { 
		super(fillColor, x, y);
		this.length = length;
		this.sides = sides;
		this.apothem = apothem;
		this.xPoints = xPoints;
		this.yPoints = yPoints;
	}
	
	
	public Polygon(int x, int y, int length, int sides, double apothem, int[] xPoints, int[] yPoints) { 
		super(x, y);
		this.length = length;
		this.sides = sides;
		this.apothem = apothem;
		this.xPoints = xPoints;
		this.yPoints = yPoints;
	}
	
	//Generate Getters and Setters
		public int getSides() {
			return sides;
		}

		public void setSides(int sides) {
			this.sides = sides;
		}

		public double getApothem() {
			return apothem;
		}

		public void setApothem(double apothem) {
			this.apothem = apothem;
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
		return "[" + "Name of Shape: Polygon " + "Location: " + this.getLocation() + "Fill Color: " + this.getFillColor() + "Border Color: " + this.getBorderColor() + "Area: " + this.getArea() + "Perimiter: " + this.getPerimeter() + "]"; 
	}
	
	//Equals Method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polygon other = (Polygon) obj;
		if (Double.doubleToLongBits(apothem) != Double.doubleToLongBits(other.apothem))
			return false;
		if (length != other.length)
			return false;
		if (sides != other.sides)
			return false;
		if (!Arrays.equals(xPoints, other.xPoints))
			return false;
		if (!Arrays.equals(yPoints, other.yPoints))
			return false;
		return true;
	}
	
	@Override
	void draw(Graphics g) {
		g.drawPolygon(xPoints,yPoints,sides);
		g.fillPolygon(xPoints,yPoints,sides);
	}

	@Override
	//This area function is for any n-sided figures assuming it is regular
	double getArea() {
		return (length*sides*apothem)/2;
	}

	@Override
	double getPerimeter() {
		return sides * length;
	}
	

}
