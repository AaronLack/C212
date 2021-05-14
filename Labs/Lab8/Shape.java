import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random; 

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 3/6/20
 * All the different shapes need a draw method
 * All extended classes should implement a toString method
 * All extended classes should have an equals method to compare two shapes
 * Oval, Circle, Triangle, Quad, Rect, Square, Poly, Hex, and Pent classes should have the same number of constructors 
 * with the same arguments in addition to any other fields needed to create those shapes
 * Need to call super class of the constructor to make private fields
 * Fill in all the methods that the abstract methods. 
 */


abstract class Shape {
	private Color fillColor; 
	private Color borderColor; 
	private Boolean isFilled; 
	private Point Location;
	
	//the three constructors initialize the instance fields 
	public Shape(Color fillColor, Color borderColor, int x, int y) { 
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		this.Location = new Point(x,y);
		
	}

	// set borderColor to Black since not provided 
	public Shape(Color fillColor, int x, int y) { 
		this.fillColor = fillColor;
		this.borderColor = Color.black;
		this.Location = new Point(x,y);
	}

	// set fillColor to white and border color to black 
	public Shape(int x, int y) { 
		this.fillColor = Color.white;
		this.borderColor = Color.black;
		this.Location = new Point(x,y);
	}
	
	// will fill the shape with some random image. You can select any image for larger shapes 
	// I think its best to create a random color by using rgb and puting it in an color object
	public void setFillColor(Color c) { 
		this.fillColor = c;
	}
	
	//Setters: you set something. Getters: you return something
	public Color getFillColor() { 
		return fillColor;
	}
	
	public void setBorderColor(Color c) { 
		this.borderColor = c;
	} 
	
	public Color getBorderColor() { 
		return borderColor;
	}

	public void setLocation(Point pt) { 
		this.Location = pt;
	} 
	
	public Point getLocation() { 
		return Location;
	}

	// Note: subclasses of Shape do not inherent private members so we need methods the subclasses
	// can use to get the x and y values from the private Point instance field 
	
	public int getX() { 
		return (int)this.Location.getX();
	}
	
	public void setX(int x) { 
		this.Location.setLocation(x, this.getY());
	
	} 
	
	public int getY() { 
		return (int)this.Location.getY();
	} 
	
	public void setY(int y) { 
		this.Location.setLocation(this.getX(), y);
	}

	// if fillColor is white returns true, else returns false 
	public boolean isFilled() { 
		if (this.fillColor == Color.white) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//moves location by dx and dy
	private void moveLocation(int dx, int dy) { 
		this.Location.translate(dx, dy);
	}

	//Abstract Graphics g class
	abstract void draw(Graphics g);
	abstract double getArea(); 
	abstract double getPerimeter();
}

