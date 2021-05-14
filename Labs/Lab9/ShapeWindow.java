import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/1/20  
 * In this class, I am using the shapeDriver instance variable of type JPanel to create a window
 * I am then going to use the typical JFrame stuff but use this.____ instead. 
 * Then, I'm going implement the timer class to run this code and produce shapes for a given time.
 * I will do this by using a try/catch, similar to if/else, for running this program.  
 */

public class ShapeWindow extends JFrame {

    JPanel shapeDriver;

    public ShapeWindow() {
    	//An empty super takes in everything
        super();
        
        JPanel shapeDriver = new ShapeDriver();
        this.addKeyListener((KeyListener) shapeDriver);
        this.add(shapeDriver);        
        this.setSize(600,600);
        this.setTitle("Shape Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(shapeDriver);
        this.setVisible(true);
        
    }

    public static void main(String[] args) {
        //Create a JFrame and invoke the constructor
    	//This actually runs the program. 
        JFrame shapeWindow = new ShapeWindow();
        
    }
}
