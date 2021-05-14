import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JFrame;


/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/25/25
 * In this program, I will test my Cannonball Class by displaying it in a JFrame. 
 * First, initialize an array list of points and positions.  
 * Then Write a method to draw circles
 * Use a scanner to take in input values for the shoot method and create objects to test it.  
 * 
 * Lab7 REDO: take x as an input, ask what that means. 
 */


public class DrawCannonball extends JComponent {
	
	ArrayList<Point> position = new ArrayList<Point>();
	
	public DrawCannonball(ArrayList<Point> point) {
		this.position = point;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Go over all the points in your ArrayList and draw circle. you might want to flip y cord. 
		//using getheight()-y.
		//casting graphics 2d to g
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.black);
		for(Point p: position)
		{
			g2.drawOval(p.x, -p.y + 250, 10, 10); //Adding 250 to -p.y so the cannon fits the frame.
		}
		
	}
	
	public static void main(String[] args) {
		//Create a cannonball obj 
		//Use Scanner to take inputs for shoot(). Call shoot method and store everything into an ArrayList.
		//Instanstiate an obj of this class and do the regular JFRame stuff (setSize, add, setVisible, etc). 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the angle between 0 and 90 degrees: ");
		double angle = sc.nextDouble();
		System.out.println("Please enter the inital velocity: ");
		double initialVelocity = sc.nextDouble();
		System.out.println("Please enter the time interval (delta sec)");
		double deltaTime = sc.nextDouble();
		
		//First Create a Cannonball Object
		//LAB7 REDO: FIX the xPos to take in user input!!!
		System.out.println("Enter an x-position");
		double xPos = sc.nextDouble();
		Cannonball ball = new Cannonball(xPos);
		//For all the stored points in positoin, call the shoot method with the cannonball object
		ArrayList<Point> position = ball.shoot((angle*Math.PI / 180), initialVelocity, deltaTime);
		//New object that displays the points
		DrawCannonball draw = new DrawCannonball(position);
		//Typical JFrame Stuff
		JFrame frame = new JFrame();
		frame.setSize(1200,400);
		frame.setTitle("Cannonball Shot");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Add the object
		frame.add(draw);
		frame.setVisible(true);

	}

}
