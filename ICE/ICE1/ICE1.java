import javax.swing.JFrame;

public class ICE1 {
	public static void main(String[] args) {
		
		RectangleComponent2 component = new RectangleComponent2();
		JFrame frame = new JFrame();
		frame.setSize(300,400);
		frame.setTitle("Two Rectangles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(component);
		frame.setVisible(true);
		
	}

}
