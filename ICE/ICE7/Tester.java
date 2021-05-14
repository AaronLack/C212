import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 3/13/20
 * I will set up a tester in this method.
 * In the tester constructor, I will make a new object of type ICESevenStarter 
 * and Do the typical JFrame stuff using the keyword this. 
 * 100,100 is the location of the frame for where text is going to be displayed.
 * Then all I'm doing in main is calling tester.  
 */

public class Tester extends JFrame {

	
	static ICESevenStarter tester;
	
	
	// again if you want to use Tester as a keyListener, then you should:
	//1. setup the keyListener in the constructor
	//2. setup the three functions for keyListener, you only need to complete one of them
	
	public Tester() {
		ICESevenStarter ice7 = new ICESevenStarter(100,100);
		this.add(ice7);
		this.addKeyListener(ice7);
		this.setSize(300,300);
		this.setTitle("ICE 7");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}

	// TODO? 

	
	public static void main(String[] args) {
		// TODO
		// Create and show Tester as the JFrame.
		Tester test = new Tester();
		
		
	}

}
