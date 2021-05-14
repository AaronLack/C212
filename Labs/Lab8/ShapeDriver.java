	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 3/11/20
	 * 
	 * Pseudocode: 
	 * If shape is instance quad and less than 10 
	 * Rand4points x and y, get rand colors
	 * Shape window main, Instantiate driver object, add object to array list
	 * For loop that draws all objects in array list
	 * 
	 * Additional Requirements:
	 * Background should be random other than black
	 * Shapes should be of random sizes
	 * Shapes should be of random colors different than the background color
	 * Shapes should be drawn in random locations.
	 * Some methods wont be used, and you may need to add some methods yourself. 
	 */
 
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

/*
 * Driver program for random shape generator app
 * NOTE: You are encouraged to experiment and try out various approaches
 * The comments given here are just guidelines to get you started 
 * Possibly, this problem can be finished in many ways.
 */

public class ShapeDriver extends JPanel {

    // Panel constants
    public final int FRAME_WIDTH = 600;
    public final int FRAME_HEIGHT = 600;

    private Random random;
	
	// Need some data structure here to store all Shapes to be drawn
	// in the paintComponent
	
	// You can also keep other instance variables here as you deem fit
	
    public ShapeDriver() {
        super(); 

        /* TO-DO: 
         *  - set up this JPanel
         *  - initialize any other fields you've declared
         *  - You could also setBackground here
         */
        
        //Sets the background color to a random color
        Color colors[]  = {Color.GREEN,Color.cyan,Color.BLUE,Color.MAGENTA,Color.RED,Color.ORANGE};
        int randomIndex = new Random().nextInt(colors.length);
        this.setBackground(colors[randomIndex]); 
    }

    @Override
    public void paintComponent(Graphics g) {
        // calling super class paintComponent method
        // background will not be colored otherwise
        super.paintComponent(g);

        /*
		  Invoke the .draw() of the different Shapes here. It should take
		  the Graphics g object as a parameter. Iterate over your data structure
		  holding all the various Shape objects and call their draw() method.
		*/
        
        
    }
    
	public void actionPerformed(ActionEvent e){
		/*
		  This method gets invoked automatically whenever Timer runs out.
		  Purpose of this method should be to do all the randomization
		  such as picking random colors, (x,y) coords, sizes and also
		  deciding which type of shape to draw. Call this.repaint() at
		  the end, so that paintComponent() is invoked.
		  
		  Remember, a specific type of shape (Square, Oval etc) can be repeated
		  only 10 times max.
		*/
		
		
		ArrayList <Shape> shapes = new ArrayList<>();
		shapes.add(Quadrilateral);
		shapes.add(Rectangle);
		shapes.add(Square);
		shapes.add(Oval);
		shapes.add(Circle);
		shapes.add(Triangle);
		shapes.add(Polygon);
		shapes.add(Hexagon);
		shapes.add(Pentagon);
		
		random = new Random();
		
		boolean generatingShapes = true;
		
		while(generatingShapes) {
			
			int xPosition = random.nextInt(601);
			int yPosition = random.nextInt(601);
			
			int indexNumber = random.nextInt(10);
			
			int quadrilateralTracker = 0;
			int rectangleTracker = 0;
			int squareTracker = 0;
			int ovalTracker = 0;
			int circleTracker = 0;
			int triangleTracker = 0;
			int polygonTracker = 0;
			int hexagonTracker = 0;
			int pentagonTracker = 0;
			
		}
		
		
		
		
	}
    // test client
    public static void main(String[] args) {

    }
}