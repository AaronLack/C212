import java.awt.Color;
import java.awt.Graphics;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 3/6/20
 * Class Pentagon, inherits Polygon. 
 * Call the three constructors, all methods will be the same except for toString so make sure to change that.
 * Will be less code than the inherited method.  
 */

public class Pentagon extends Polygon{
	
	public Pentagon(Color fillColor, Color borderColor, int x, int y, int length, double apothem,
			int[] xPoints, int[] yPoints) {
		super(fillColor, borderColor, x, y, length, 5, apothem, xPoints, yPoints);
	}
	
	public Pentagon(Color fillColor, int x, int y, int length, double apothem, int[] xPoints, int[] yPoints) { 
		super(fillColor, x, y, length, 5, apothem, xPoints, yPoints);
	}
	
	public Pentagon(int x, int y, int length, double apothem, int[] xPoints, int[] yPoints) { 
		super(x, y, length, 5, apothem, xPoints, yPoints);
	}

	//Name of shape, color and location, area, and perimeter of shape
	public String toString() {
		return "[" + "Name of Shape: Pentagon " + "Location: " + this.getLocation() + "Fill Color: " + this.getFillColor() + "Border Color: " + this.getBorderColor() + "Area: " + this.getArea() + "Perimiter: " + this.getPerimeter() + "]"; 
	}

}
