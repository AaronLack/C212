import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class RectangleComponent2 extends JComponent{
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle box = new Rectangle(100,100,150,150);
		g2.draw(box);
		
		Ellipse2D.Double ellipse = new Ellipse2D.Double(110,110,125,125);
		g2.draw(ellipse);
		
		Rectangle box2 = new Rectangle(135,135,75,75);
		g2.draw(box2);
		
		
	}

}
