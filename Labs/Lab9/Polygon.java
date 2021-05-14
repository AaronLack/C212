import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/8/20
 * Class Polygon, will
 * Add instance variables length, sides, and apothem and include them in all three constructors. 
 * toString will have everything to compare all abstract methods and the name of the shape.
 * The xPoints and yPoints are going to be an array of size sides so it is generic.
 * This is needed or the g.fillPolygon and g.drawPolygon method.   
 */

public class Polygon extends Shape{
	
	private int length; //the length of sides
	private int sides;//number of sides
	private int[] xPoints = new int[sides];
	private int[] yPoints = new int[sides];
	//The array of x and y points are created in the shapedriver class and all the math
	
	
	//First Constructor to fill a border color and a fill color.
	public Polygon(Color fillColor, Color borderColor, int x, int y, int xDirection, int yDirection, int length, int sides, int[] xPoints, int[] yPoints) {
		super(fillColor, borderColor, x, y, xDirection, yDirection);
		this.length = length;
		this.sides = sides;
		this.xPoints = xPoints;
		this.yPoints = yPoints;
	}
	
	//Second constructor case for set borderColor to Black since not provided 
	public Polygon(Color fillColor, int x, int y, int xDirection, int yDirection, int length, int sides, int[] xPoints, int[] yPoints) { 
		super(fillColor, x, y, xDirection, yDirection);
		this.length = length;
		this.sides = sides;
		this.xPoints = xPoints;
		this.yPoints = yPoints;
	}
	
	
	public Polygon(int x, int y, int xDirection, int yDirection, int length, int sides, int[] xPoints, int[] yPoints) { 
		super(x, y, xDirection, yDirection);
		this.length = length;
		this.sides = sides;
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

	@Override
	//Write an if/else if condition for sides 5/6, then calculate the points
	void draw(Graphics g) {
		g.setColor(getFillColor());
		if (sides == 5) {
			xPoints = new int[] {this.getX(), this.getX()+length/2, this.getX()-length/8, this.getX()-length/8, this.getX()-length/4};
			yPoints = new int[] {this.getY(), this.getY()+length/2, this.getY()+length, this.getY()+length, this.getY()+length/2};
			g.drawPolygon(xPoints,yPoints,5);
			g.fillPolygon(xPoints,yPoints,5);
		}
		else if (sides == 6) {
			xPoints = new int[] {this.getX(), this.getX()+length, this.getX()+((3/2)+length), this.getX()-((3/2)+length), this.getX()-length, this.getX()-((3/2)+length), this.getX()+((3/2)+length)};
			yPoints = new int[] {this.getY(), this.getY(), this.getY()+length/2, this.getY()+length, this.getY()+length, this.getY()+length/2};
			g.drawPolygon(xPoints,yPoints,6);
			g.fillPolygon(xPoints,yPoints,6);
		}
			
	}
		
	@Override
	//This area function is for any n-sided figures assuming it is regular
	double getArea() {
		//Fix this later, need apothem or use if elif else statements for number of sides and implement that in here
		//The if elif statements should range from 3 to 8. 
		return (length*sides)/2;
	}

	

	

}
