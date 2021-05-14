import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

	/*
	 * Header
	 * @Author: Aaron Lack, alack
	 * Last edited: 2/21/20
	 * First, I will set instantiate the class with variable size at 0
	 * Then I will use a paint component function to make the proper triangles in the proper locations
	 * I will use g.fillPolygon to make triangles to be made of squares.   
	 * The color will be above the two loops so both triangles get made into a square
	 * If I wanted to display triangles, I can name the color before each g.fillPolygon statement.
	 * In the print checkboard function, I need to add the JFrame component here
	 * I also need to create an object here and display that object onto the JFrame
	 * Finally, call that method with a given integer size 
	 */
	
	
public class Checkerboard extends JComponent {
	private int size = 0;
	
	
	//This is the constructor
	public Checkerboard(int size) {
		this.size = size;
	}
	
	//This function draws it
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int sideLength = size;
		g.setColor(Color.WHITE);
		//odd white columns. There will be 8 by 8 squares and I will start i at 0 and increment by 2
		for(int i = 0; i < 8; i += 2)
		{
			for(int j = 0; j < 8; j += 2)
			{
				//g.setColor(Color.WHITE);
				g.fillPolygon(new int [] {sideLength*i, sideLength*i, sideLength*(i+1)}, new int[] {sideLength*j, sideLength*(j+1), sideLength*(j+1)},3);
				//g.setColor(Color.BLACK);
				g.fillPolygon(new int [] {sideLength*i, sideLength*(i+1), sideLength*(i+1)}, new int[] {sideLength*j, sideLength*j, sideLength*(j+1)},3);
			}
		}
		
		//even white columns. Start at i at 1 and increment by two for every other
		for(int i = 1; i < 8; i += 2)
		{
			for(int j = 0; j < 8; j += 2)
			{
				//g.setColor(Color.WHITE);
				g.fillPolygon(new int [] {sideLength*i, sideLength*i, sideLength*(i+1)}, new int[] {sideLength*(j+1), sideLength*(j+2), sideLength*(j+2)},3);
				//g.setColor(Color.BLACK);
				g.fillPolygon(new int [] {sideLength*i, sideLength*(i+1), sideLength*(i+1)}, new int[] {sideLength*(j+1), sideLength*(j+1), sideLength*(j+2)},3);
				
			}
		}
		
		//Even columns set to black color
		g.setColor(Color.BLACK);
		
		//odd black columns
		for(int i = 1; i <=8; i +=2)
		{
			for(int j = 0; j < 8; j += 2)
			{
				//g.setColor(Color.WHITE);
				g.fillPolygon(new int [] {sideLength*i, sideLength*i, sideLength*(i+1)}, new int[] {sideLength*j, sideLength*(j+1), sideLength*(j+1)},3);
				//g.setColor(Color.BLACK);
				g.fillPolygon(new int [] {sideLength*i, sideLength*(i+1), sideLength*(i+1)}, new int[] {sideLength*j, sideLength*j, sideLength*(j+1)},3);
			}
		}
		
		//even black columns
		for(int i = 0; i < 8; i += 2)
		{
			for(int j = 0; j < 8; j+= 2)
			{
				//g.setColor(Color.WHITE);
				g.fillPolygon(new int [] {sideLength*i, sideLength*i, sideLength*(i+1)}, new int[] {sideLength*(j+1), sideLength*(j+2), sideLength*(j+2)},3);
				//g.setColor(Color.BLACK);
				g.fillPolygon(new int [] {sideLength*i, sideLength*(i+1), sideLength*(i+1)}, new int[] {sideLength*(j+1), sideLength*(j+1), sideLength*(j+2)},3);
			}
		}
	}
	
	//This function will be called in main so that a checkerboard displays. JFRAME goes in here.  
	public static void printCheckBoard(int size) {
		JFrame frame = new JFrame();
		frame.setSize(size*10, size*10);
		Checkerboard object = new Checkerboard(size);
		frame.add(object);
		
		frame.setTitle("Checkerboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		printCheckBoard(46);
		printCheckBoard(23); //23 and 46 are just examples
	}

	
}
