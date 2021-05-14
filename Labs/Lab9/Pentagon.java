import java.awt.Color;
import java.awt.Graphics;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/8/20
 * Class Pentagon, inherits Polygon. 
 * Pass in 5 for the number of sides
 * Will be less code than the inherited method.  
 */

public class Pentagon extends Polygon{
	
	private int[] xPoints = new int[5];
	private int[] yPoints = new int[5];
	
	public Pentagon(Color fillColor, Color borderColor, int x, int y, int xDirection, int yDirection, int length,
			int[] xPoints, int[] yPoints) {
		super(fillColor, borderColor, x, y, xDirection, yDirection, length, 5, xPoints, yPoints);
		
		this.xPoints = new int[] {x, x+length/2, x-length/8, x-length/8, x-length/4};
		this.yPoints = new int[] {y, y+length/2, y+length, y+length, y+length/2};
	}
	
	public Pentagon(Color fillColor, int x, int y, int xDirection, int yDirection, int length, int[] xPoints, int[] yPoints) { 
		super(fillColor, x, y, xDirection, yDirection,length, 5, xPoints, yPoints);
		this.xPoints = new int[] {x, x+length/2, x-length/8, x-length/8, x-length/4};
		this.yPoints = new int[] {y, y+length/2, y+length, y+length, y+length/2};

	}
	
	public Pentagon(int x, int y, int xDirection, int yDirection, int length, int[] xPoints, int[] yPoints) { 
		super(x, y, xDirection, yDirection, length, 5, xPoints, yPoints);
		this.xPoints = new int[] {x, x+length/2, x-length/8, x-length/8, x-length/4};
		this.yPoints = new int[] {y, y+length/2, y+length, y+length, y+length/2};
	}
	

}

