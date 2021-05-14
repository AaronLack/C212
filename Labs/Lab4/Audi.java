import javax.swing.JFrame;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 2/9/20
 * In this code, I simply will display the four ellipses I created in my AudiDraw class
 * I set up the JFRAME, added a title, and added the components.  
 */

public class Audi {

	public static void main(String[] args) {
		AudiDraw component = new AudiDraw();
		JFrame frame = new JFrame();
		frame.setSize(500,250);
		frame.setTitle("Audi Symbol");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(component);
		frame.setVisible(true);

	}

}
