import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.PrintWriter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import javax.swing.KeyStroke;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 3/13/20
 * In this class, I will take care of the logic behind making a frame and displaying text when you press a key
 * I have instance variables of an empty string, a JLabel lab, and x and y locations for where text is being displayed
 * I will use a try/catch to make sure that I don't get a file not found exception. 
 * Which key will be pressed to show what is going to be in the pressKey method
 * I then need to call draw string to display that on a JFrame.
 * I will manually put an input file of my stuff and Eclipse will make the output file.  
 * Note to the grader: I have a folder called ICE7 when I made this project, and I found the output file
 * by right clicking the ICE7 folder and hitting refresh. 
 */


public class ICESevenStarter extends JComponent implements KeyListener{
	
	//For me, it is better to initiate some data when creating the fields
	//So that you will not encounter null exceptions later
	private String cityOfBirth = "";
	private String names = "";
	private int xLoc = 0;
	private int yLoc = 0;
	private JLabel lab;
	private String labelText = "";
	
	
	// TODO?
	// you might need another fields at here
	
	public ICESevenStarter(int xLoc, int yLoc) {
		// TODO
		// initiate x and y location as input x and y location
		// initiate other fields by reading the files
	   
	   // You can choose to store the new data to file directly in here
	   // Or you can create a function to do that
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		
		
		try {
			//I have a folder called ICE7 when I made this project, and I found the output file
			//by right clicking the ICE7 folder and hitting refresh. 
			File inputFile = new File("input");
			Scanner sc = new Scanner(inputFile);
			File output = new File("output");
			PrintWriter path = new PrintWriter(output);
			
			String firstName = sc.next();
			String lastName = sc.next();
			String born = sc.next();
			
			this.names = lastName+ ", " +firstName;
			this.cityOfBirth = born;
			
			path.println(this.cityOfBirth);
			path.println(this.names);
			
			sc.close();
			path.close();
			
			JPanel panel = new JPanel();
			panel.add(lab);
		}
		
		catch (Exception E) {
			
		}	
		
	}

    public void paintComponent(Graphics g) {
    	// TODO
    	// print the text you want to draw at here
    	g.drawString(labelText, xLoc, yLoc);
    }
    // TODO?
    // think about how to change your text in this class
    // if you choose to set Tester as KeyListener, then you should have set of setters for the fields to be called in Tester.java
    // If you choose to set this class as KeyListener, then you can directly setup the three functions for keyListener, and change the text to draw in here. 

    
    //Leave Blank
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		char k = (char)e.getKeyCode();
    	switch (k)
    	{
    		case KeyEvent.VK_B:
    			this.labelText = "Bye";

    			break;
    		case KeyEvent.VK_C:
    			
    			this.labelText = cityOfBirth;
    			break;
    		case KeyEvent.VK_N:
    			
    			this.labelText = names;
    			break;
    		
    	}
    	//To draw what we have
	    this.repaint();
	}
	

	//Leave Blank
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
