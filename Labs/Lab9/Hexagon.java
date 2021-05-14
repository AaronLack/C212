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

public class Hexagon extends Polygon{
	
	private int[] xPoints = new int[6];
	private int[] yPoints = new int[6];
	
	public Hexagon(Color fillColor, Color borderColor, int x, int y, int xDirection, int yDirection, int length,
			int[] xPoints, int[] yPoints) {
		super(fillColor, borderColor, x, y, xDirection, yDirection, length, 6, xPoints, yPoints);
		this.xPoints = new int[] {x, x+length, x+((3/2)+length), x-((3/2)+length), x-length, x-((3/2)+length), x+((3/2)+length)};
		this.yPoints = new int[] {y, y, y+length/2, y+length, y+length, y+length/2};
		
	}
	
	public Hexagon(Color fillColor, int x, int y, int xDirection, int yDirection, int length, int[] xPoints, int[] yPoints) { 
		super(fillColor, x, y, xDirection, yDirection,length, 6, xPoints, yPoints);
		this.xPoints = new int[] {x, x+length, x+((3/2)+length), x-((3/2)+length), x-length, x-((3/2)+length), x+((3/2)+length)};
		this.yPoints = new int[] {y, y, y+length/2, y+length, y+length, y+length/2};
	}
	
	public Hexagon(int x, int y, int xDirection, int yDirection, int length, int[] xPoints, int[] yPoints) { 
		super(x, y, xDirection, yDirection, length, 6, xPoints, yPoints);
		this.xPoints = new int[] {x, x+length, x+((3/2)+length), x-((3/2)+length), x-length, x-((3/2)+length), x+((3/2)+length)};
		this.yPoints = new int[] {y, y, y+length/2, y+length, y+length, y+length/2};
	}

}