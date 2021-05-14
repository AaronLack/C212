import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

/* Header
* @Author: Aaron Lack, alack
* Last edited: 3/11/20
* Here are all my JUNIT Tests for all the shapes for the isEquals method and the toString method.
*/

public class shapesTest {

	@Test
	public void test() {
		
		int[] polygonXPoints = {0,1,2,3,4,5,6,7};
		int[] polygonYPoints = {2,3,4,5,6,7,8,9};
		
		int[] hexagonXPoints = {0,1,2,3,4,5};
		int[] hexagonYPoints = {2,3,4,5,6,7};
		
		int[] pentagonXPoints = {0,1,2,3,4};
		int[] pentagonYPoints = {5,6,7,8,9};
		
		Point quadPoint1 = new Point(0,0);
		Point quadPoint2 = new Point(0,4);
		Point quadPoint3 = new Point(4,4);
		Point quadPoint4 = new Point(4,0);
		
		Quadrilateral quad = new Quadrilateral(quadPoint1,quadPoint2,quadPoint3,quadPoint4);
		Rectangle rect = new Rectangle(quadPoint1,quadPoint2,quadPoint3,quadPoint4);
		Square sq = new Square(quadPoint1,quadPoint2,quadPoint3,quadPoint4);
		
		Point triPoint1 = new Point(-5,0);
		Point triPoint2 = new Point(5,0);
		Point triPoint3 = new Point(0,5);
		
		Triangle tri = new Triangle(triPoint1,triPoint2,triPoint3);
		
		Oval oval = new Oval (2,4,0,0);
		Circle circle = new Circle(3,0,0);
		
		Polygon poly = new Polygon(polygonXPoints,polygonYPoints,8);
		Hexagon hex = new Hexagon(hexagonXPoints,hexagonYPoints, 6);
		Pentagon penta = new Pentagon(pentagonXPoints, pentagonYPoints,5);
		
		
		assertEquals(true, sq.equals(sq));
		assertEquals(true, sq.equals(rect));
		assertEquals(false, quad.equals(hex));
		assertEquals(false, tri.equals(penta));
		assertEquals(false, oval.equals(circle));
		assertEquals(false, poly.equals(hex));
		assertEquals(false, hex.equals(penta));
		assertEquals(false, penta.equals(poly));
		
		//toString
		String output = quad.toString();
		assertEquals("[" + "Name of Shape: Quadrilateral " + "Location: " + quad.getLocation() + "Fill Color: " + quad.getFillColor() + "Border Color: " + quad.getBorderColor() + "Area: " + quad.getArea() + "Perimiter: " + quad.getPerimeter() + "]", output);
		
		String output1 = rect.toString();
		assertEquals("[" + "Name of Shape: Rectangle " + "Location: " + rect.getLocation() + "Fill Color: " + rect.getFillColor() + "Border Color: " + rect.getBorderColor() + "Area: " + rect.getArea() + "Perimiter: " + rect.getPerimeter() + "]", output1);
		
		String output2 = sq.toString();
		assertEquals("[" + "Name of Shape: Square " + "Location: " + sq.getLocation() + "Fill Color: " + sq.getFillColor() + "Border Color: " + sq.getBorderColor() + "Area: " + sq.getArea() + "Perimiter: " + sq.getPerimeter() + "]", output2);
		
		String output3 = tri.toString();
		assertEquals("[" + "Name of Shape: Triangle " + "Location: " + tri.getLocation() + "Fill Color: " + tri.getFillColor() + "Border Color: " + tri.getBorderColor() + "Area: " + tri.getArea() + "Perimiter: " + tri.getPerimeter() + "]", output3);
		
		String output4 = oval.toString();
		assertEquals("[" + "Name of Shape: Oval " + "Location: " + oval.getLocation() + "Fill Color: " + oval.getFillColor() + "Border Color: " + oval.getBorderColor() + "Area: " + oval.getArea() + "Circumference: " + oval.getPerimeter() + "]", output4);
		
		String output5 = circle.toString();
		assertEquals("[" + "Name of Shape: Circle " + "Location: " + circle.getLocation() + "Fill Color: " + circle.getFillColor() + "Border Color: " + circle.getBorderColor() + "Area: " + circle.getArea() + "Circumference: " + circle.getPerimeter() + "]", output5); 
		
		String output6 = poly.toString();
		assertEquals("[" + "Name of Shape: Polygon " + "Location: " + poly.getLocation() + "Fill Color: " + poly.getFillColor() + "Border Color: " + poly.getBorderColor() + "Area: " + poly.getArea() + "Perimiter: " + poly.getPerimeter() + "]", output6);
		
		String output7 = hex.toString();
		assertEquals("[" + "Name of Shape: Hexagon " + "Location: " + hex.getLocation() + "Fill Color: " + hex.getFillColor() + "Border Color: " + hex.getBorderColor() + "Area: " + hex.getArea() + "Perimiter: " + hex.getPerimeter() + "]", output7);
		
		String output8 = penta.toString();
		assertEquals("[" + "Name of Shape: Pentagon " + "Location: " + penta.getLocation() + "Fill Color: " + penta.getFillColor() + "Border Color: " + penta.getBorderColor() + "Area: " + penta.getArea() + "Perimiter: " + penta.getPerimeter() + "]", output8);
	}

}
