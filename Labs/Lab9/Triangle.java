import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class Triangle extends Shape{
	//I want to create triangle
	private int height; //How tall the triangle is
	private int width; //Side length
	private int[] xPoints = new int[3];
	private int[] yPoints = new int[3];
	
	
	public Triangle(Color fillColor, Color borderColor, int x, int y, int xDirection, int yDirection, int height, int width) {
		super(fillColor, borderColor, x, y, xDirection, yDirection);
		this.height = height;
		this.width = width;
		this.xPoints = new int[] {x, x+width/2, x-width/2};
		this.yPoints = new int[] {y, height+y, height+y};
	}
	
	//Second constructor case for set borderColor to Black since not provided 
	public Triangle(Color fillColor, int x, int y, int xDirection, int yDirection, int height, int width) { 
		super(fillColor, x, y, xDirection, yDirection);
		this.height = height;
		this.width = width;
		this.xPoints = new int[] {x, x+width/2, x-width/2};
		this.yPoints = new int[] {y, height+y, height+y};
		
	}
	
	//Third constructor case: set fillColor to white and border color to black 
	public Triangle(int x, int y, int xDirection, int yDirection, int height, int width) { 
		super(x, y, xDirection, yDirection);
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


	@Override
	void draw(Graphics g) {
		g.setColor(getFillColor());
		xPoints = new int[] {this.getX(), this.getX()+width/2, this.getX()-width/2};
		yPoints = new int[] {this.getY(), this.getY()+height, this.getY()+height};
		g.drawPolygon(xPoints,yPoints,3);
		g.fillPolygon(xPoints,yPoints,3);
	}

	@Override 
	double getArea() {
		return (width*height) / 2;
	}
}
