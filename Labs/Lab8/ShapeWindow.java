	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 3/11/20  
	 * In this class, I am using the shapeDriver instance variable of type JPanel to create a window
	 * I am then going to use the typical JFrame stuff but use this.____ instead. 
	 * Then, I'm going implement the timer class to run this code and produce shapes for a given time.
	 * I will do this by using a try/catch, similar to if/else, for running this program.  
	 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

/*
 * Main application for random shape generator app
 * NOTE: You are encouraged to experiment and try out various approaches
 * The comments given here are just guidelines to get you started 
 * Possibly, this problem can be completed in many ways.
 */
public class ShapeWindow extends JFrame {

    JPanel shapeDriver;

    public ShapeWindow() {
    	//An empty super takes in everything
        super();
        // TO-DO: set up the frame
		/*
		Create a ShapeDriver object here (which is a JPanel)
		and add it to ShapeWindow (which is a JFrame). Don't forget to setSize,
		setVisible and any other required attributes (you might want to add the ShapeDriver
		object to the ContentPane (using this.getContentPane()) instead of directly adding
		to ShapeWindow.
		
		You can initialize a Timer here (with appropriate milliseconds and your 
		ShapeDriver obj created above as params). Use the timer.start() method to start Timer.
		However, you would also want to do Thread.sleep(<Appropriate milliseconds here>) afterwards
		It should be within a try-catch block. You can leave the catch block empty or provide some sysout msg
		You can stop your timer object after the try-catch block
		*/
        
        
        JPanel shapeDriver = new ShapeDriver();
        this.add(shapeDriver);
        this.setSize(600,600);
        this.setTitle("Shape Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(shapeDriver);
        this.setVisible(true);
        
        Timer timer = new Timer(1000/60, (ActionListener) shapeDriver);
        timer.start();
        
        //Try catch for the timer.  
        try {
        	Thread.sleep(1000/60);
        }
        catch(Exception i) {
        	System.out.println("");
        }
        timer.stop();
        
    }

    public static void main(String[] args) {
        // Create a JFrame and invoke the constructor
        JFrame shapeWindow = new ShapeWindow();
        
    }
}
