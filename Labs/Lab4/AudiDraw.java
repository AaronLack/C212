import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;


/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 2/9/20
 * In this code, I created my own class called AudiDraw 
 * I made 4 ellipses that were next to each other (x,y) and kept the radius consistent (125,125)
 * I also distinguish them with different colors. 
 */

public class AudiDraw extends JComponent{
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		//x,y height, width
		
		Ellipse2D.Double ellipse = new Ellipse2D.Double(50,75,125,125);
		g2.setColor(Color.RED);
		g2.draw(ellipse);
		
		Ellipse2D.Double ellipse2 = new Ellipse2D.Double(150,75,125,125);
		g2.setColor(Color.BLUE);
		g2.draw(ellipse2);
		
		Ellipse2D.Double ellipse3 = new Ellipse2D.Double(250,75,125,125);
		g2.setColor(Color.YELLOW);
		g2.draw(ellipse3);
		
		Ellipse2D.Double ellipse4 = new Ellipse2D.Double(350,75,125,125);
		g2.setColor(Color.GREEN);
		g2.draw(ellipse4);
		
		
	}

}
