import java.awt.Point;
import java.util.ArrayList;


/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 2/28/20
 * In this program, I code the behavior of a cannon shot and display it in JFrame. 
 * First, initialize instance variables. In the constructor, set xPosition to x and the rest to 0.
 * Move is going to be the equations given in the lab.
 * Get location is using the point class and returning a new point.  
 * An array list of Point checks the y-position to make sure that it is not 0.  
 * I have more comments in the code for line byline
 * 
 * For lab7 redo: keep this the same.
 */

public class Cannonball {
	
	//Instance variables
	private double xPosition, yPosition;
	private double xVelocity, yVelocity;
	private static final double g = 9.81;
	
	
	//Constructor here that takes xPosition as argument and inits everything else to 0
	public Cannonball(double x) {
		this.xPosition = x;
		this.yPosition = 0;
		this.xVelocity = 0;
		this.yVelocity = 0;
	}
	
	public void move(double deltaSec) {
		this.xPosition = this.xPosition + (this.xVelocity * deltaSec);
		this.yPosition = this.yPosition + (this.yVelocity * deltaSec) - (g *( Math.pow(deltaSec, 2) / 2.0));
		this.yVelocity = this.yVelocity - g*deltaSec;
		
	}
	
	public Point getLocation() {
		//returns a new Point object with xPosition and yPosition
		Point currentLocation = new Point((int)xPosition, (int)yPosition);
		return currentLocation;
	}
	
	public ArrayList<Point> shoot(double alpha, double v, double deltaSec) {
		ArrayList<Point> locations = new ArrayList<Point>();
		//Calculate initial xVelocity and yVelocity using Math.cos() and Math.sin()
		//Keep on calling move and store the respective coordinates of current location 
		//into an ArrayList till yPosition is 0
		
		this.xVelocity = v*Math.cos(alpha);
		this.yVelocity = v*Math.sin(alpha);
		
		for(int i = 0; i < deltaSec; i += .01)
		{
			if(i == 0)
			{
				locations.add(getLocation());
			}
			move(deltaSec);
			if(this.yPosition <= 0)
			{
				this.yPosition = 0;
				locations.add(getLocation());
				break;
			}
			locations.add(getLocation());
		}
		return locations;
		
	} 

}
