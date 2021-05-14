import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;

/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 4/8/20
*____________________________________________________________________________________________________________
* 
* LAB 9 REDO CHANGES:
* 
* 1. Fix the collision function. I put in a vkn_J for the grader to easily test collisions, just press J and only circles and squares will appear. Press H to get all the shapes to appear.  
* 
* 2. Important note about the sizes for grader: Originally, I calle the getArea() method to compare areas
* However, this caused problems of shapes to be huge if they collided with each other
* So I changed it to getHeight() for squares and getRadius1() for circles respectively
* Logically, this works because a square of size 30 cant have a different area than a square of size 30 
* And a square of size 30 is smaller than a square of size 31.  
* 
* 3. Add all of the shapes to appear for the dirver using switch case in vkn and fix constructors
* 
* 4. Another Note: My hexagons and pentagons are not perfect, but they are still there. 
* 
*/


public class ShapeDriver extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private ArrayList<Shape> shapeList = new ArrayList();
    
    public ShapeDriver() {
    	timer = new Timer(1000/60, this);
	    timer.start();
    }

    
    //Make a collision function to be called in actionPerformed
    //This will be a boolean calling the getLocation function from shape class
    public boolean collision(Shape shape1, Shape shape2) {
    	
	    	double distanceFormula = Math.sqrt(Math.pow((double)shape2.getX()-(double)shape1.getX(), 2)) + Math.pow((double)shape2.getY()-(double)shape1.getY(), 2);
	 
	    	//For Two Circles Colliding Together
    		if(shape1 instanceof Circle && shape2 instanceof Circle) {
    			if (distanceFormula < (((Circle) shape1).getRadius1() + ((Circle) shape2).getRadius1()))  {
    				return true;
        		}
    			else {
    				return false;
    			}
    		}
    		
    		//For Two Squares Colliding Together		
    		else if(shape1 instanceof Square && shape2 instanceof Square) {
    			if (distanceFormula < (((Square) shape1).getHeight() + ((Square) shape2).getHeight())) {
    				return true;
    			}
    			else {
    				return false;
    			}
    		}

    		else {
    			return false;
    		}
    }
    	
  

    public void actionPerformed(ActionEvent e) throws ConcurrentModificationException {
	   
    		//MOVING THE SHAPE//
    	
    		for(Shape tempShape: shapeList) {
    			tempShape.moveLocation(); 
    		}
    	
    		//CHECKING FOR COLLISION//
    	
    		for(int x = 0; x < shapeList.size()-1; x++) {
    			
    			for(int y = x+1; y < shapeList.size(); y++) {
    				
    			
    				//4 conditions: First check if square/square; circle/circle, square/circle, circle/square
    				//Then do the interactions
    			
    				//SQUARE SQUARE//
    				if (shapeList.get(x).getClass() == Square.class && shapeList.get(y).getClass() == Square.class) {
    				
    					Square square1 = ((Square)shapeList.get(x));
    					Square square2 = ((Square)shapeList.get(y));
    				
    					//SQUARES//
    				
    					if(collision(square1, square2) && square1.getFillColor() != square2.getFillColor()) {
        					
    						//If two squares of different colors collide, delete smaller one.
    						//If both same size, delete one of them. 
    						if(square1.getHeight() < square2.getHeight()) {
    							shapeList.remove(square1);
    						}
        					
    						else if(square1.getHeight() == square2.getHeight()) {
    							shapeList.remove(square1);
    						}
        					
    						else if(square1.getHeight() > square2.getHeight()) {
    							shapeList.remove(square2);
    						}
        					
    					}
        				
	        			//If two squares of same color collide,
	        			//merge them to be a size of the two squares added together.
	
	        			else if (collision(square1, square2) && square1.getFillColor() == square2.getFillColor()) {
	        					
	        				if(square1.getHeight() < square2.getHeight()) {
	        					//Add square1 and square2 to make a new square biggerSquare
	        					//Direction of biggerSquare is of square2

	        					Square biggerSquare = new Square(square2.getFillColor(), square2.getX(), square2.getY(),square2.getxDirection(),square2.getyDirection(), ((int)square1.getHeight() * 2));
	        					shapeList.add(biggerSquare);
	        					shapeList.remove(square1);
	        					shapeList.remove(square2);
	
	        				}
	        					
	        				else if(square1.getArea() == square2.getArea()) {
	        					//Add square1 and square2 to make a new square biggerSquare
	        					//Direction of biggerSquare is of square2
	        					
	        					Square biggerSquare = new Square(square2.getFillColor(), square2.getX(), square2.getY(), square2.getxDirection(), square2.getyDirection(), ((int)square1.getHeight() * (int)square2.getHeight()));
	        					shapeList.add(biggerSquare);
	        					shapeList.remove(square1);
	        					shapeList.remove(square2);
	        				}
	        					
	        				else if(square1.getArea() > square2.getArea()) {
	        					shapeList.remove(square2);
	        					//Add square1 and square2 to make a new square biggerSquare
	        					//Direction of biggerSquare is of square1
	        					
	        					Square biggerSquare = new Square(square1.getFillColor(), square1.getX(), square1.getY(), square1.getxDirection(),square1.getyDirection(), ((int)square2.getHeight() *2));
	        					shapeList.add(biggerSquare);
	        					shapeList.remove(square1);
	        					shapeList.remove(square2);
	        				}
	        			}
	    				
	    			}
	    			
	    			//CIRCLE CIRCLE//
	    			else if (shapeList.get(x).getClass() == Circle.class && shapeList.get(y).getClass() == Circle.class) {
	    				
	    				//CIRCLES//
	    				//Construct 2 Circles
	    				Circle circle1 = ((Circle)shapeList.get(x));
	    				Circle circle2 = ((Circle)shapeList.get(y));
	    				
	        			if(collision(circle1, circle2) && circle1.getFillColor() != circle1.getFillColor()) {
	        					
	        				//If two circles of different colors collide, delete smaller one.
	        				//If both same size, delete one of them. 
	        				if(circle1.getRadius1() < circle2.getRadius1()) {
	        					shapeList.remove(circle1);
	        				}
	        					
	        				else if(circle1.getRadius1() == circle2.getRadius1()) {
	        					shapeList.remove(circle1);
	        				}
	        					
	        				else if(circle1.getRadius1() > circle2.getRadius1()) {
	        					shapeList.remove(circle2);
	        				}
	        					
	        			}
	        				
	        			//If two circles of same color collide,
	        			//merge them to be a size of the two circles added together.
	       
	        			else if (collision(circle1, circle2) && circle1.getFillColor() == circle2.getFillColor()) {
	        					
	        				if(circle1.getRadius1() < circle2.getRadius1()) {
	        					//Add circle1 and circle2 to make a new square biggerCircle
	        					//Direction of biggerCircle is of circle2
	        					
	        					Circle biggerCircle = new Circle(circle2.getFillColor(), circle2.getX(), circle2.getY(), circle2.getxDirection(),circle2.getyDirection(), ((int)circle1.getRadius1() *2));
	        					shapeList.add(biggerCircle);
	        					shapeList.remove(circle1);
	        					shapeList.remove(circle2);
	        					
	        				}
	        					
	        				else if(circle1.getRadius1() == circle2.getRadius1()) {
	        					//Add circle1 and circle2 to make a new square biggerCircle
	        					//Direction of biggerCircle is of circle2
	        					
	        					Circle biggerCircle = new Circle(circle2.getFillColor(), circle2.getX(), circle2.getY(),circle2.getxDirection(),circle2.getyDirection(),((int)circle1.getRadius1() *(int)circle2.getRadius1()));
	        					shapeList.add(biggerCircle);
	        					shapeList.remove(circle1);
	        					shapeList.remove(circle2);
	        					
	        				}
	        					
	        				else if(circle1.getRadius1() > circle2.getRadius1()) {
	        					//Add circle1 and circle2 to make a new square biggerCircle
	        					//Direction of biggerCircle is of circle1
	        					
	        					Circle biggerCircle = new Circle(circle1.getFillColor(), circle1.getX(), circle1.getY(), circle1.getxDirection(),circle1.getyDirection(), ((int)circle2.getRadius1() *2));
	        					shapeList.add(biggerCircle);
	        					shapeList.remove(circle1);
	        					shapeList.remove(circle2);
	        				}
	        			}
	    			}
	    			
	 
    			}
    		}
    		
    		//REMOVING SHAPES IF IT HITS THE EDGE//
	
    		for (int i = 1; shapeList.size() > i; i++) {
    			if(shapeList.get(i).getX() < 20 || shapeList.get(i).getX() > 580) {
				shapeList.remove(i);
			}
    			else if(shapeList.get(i).getY() < 20 || shapeList.get(i).getY() > 580) {
				shapeList.remove(i);
    			}
    		}
    		
	    //call repaint
	    this.repaint();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        // calling super class paintComponent method
        // background will not be colored otherwise
        super.paintComponent(g);
        
        for(Shape s : shapeList) {
        	s.draw(g);
        }

    }

    @Override
    public void keyPressed(KeyEvent e){
	    /*
	 	 * In this function, I need make 4 random variables: randomColor, xPos, yPos, size
	     * Give them a range. For colors: make array of colors and choose randomly. 
	     * For xPos and yPos, give a range 20-580
	     * For size, 2-10. 
	     * Run switch case statements for each possible shape, square or circle.  
	    */
    	
	    	Random randomNumber = new Random();
	    	Color colors[]  = {Color.GREEN,Color.CYAN,Color.BLUE,Color.MAGENTA,Color.RED,Color.ORANGE};
	    	Color randomFillColor = colors[randomNumber.nextInt(6)];
	    //	System.out.println("Fill Color: " + randomFillColor);
	    	
	    	int xPos = 25 + randomNumber.nextInt(475);
	    	int yPos = 25 + randomNumber.nextInt(475);
	    	//System.out.println("[" + xPos + "," + yPos +"]");
	    	
	    	int randSize = 20 + randomNumber.nextInt(30);
	    	//This is for shapes that take in a height and a width, so they can be different sizes. Ex: Rectangle
	    	int randSizeTwo = 20 + randomNumber.nextInt(30);
	    	
	    	//When you press the H key, all of the shapes will appear
	    	int randomShape = 1 + randomNumber.nextInt(8);
	    	
	    //This is for when you press the J key, you can test my collisions easily.
	    	int randomCircleOrSquare = 1 + randomNumber.nextInt(2);
	    	
	    	
	    	//2 Switch Cases for random x and y directions, of values 1 and -1. 
	    	int xDirection=0;
	    	int yDirection=0;
	    	int randomX_Direction = 1+randomNumber.nextInt(2);
	    	int randomY_Direction = 1+randomNumber.nextInt(2);
	    	
	    	
	    	switch(randomX_Direction) {
	    	
	    	//Case 1: positive 1
	    	case 1:
	    		xDirection = 1;
	    		break;
	    		
	    	//Case 2: negative 1
	    	case 2:
	    		xDirection = -1;
	    		break;
	    	}
	    	
	    	switch(randomY_Direction) {
	    	
	    	//Case 1: positive 1
	    	case 1:
	    		yDirection = 1;
	    		break;
	    		
	    	//Case 2: negative 1
	    	case 2:
	    		yDirection = -1;
	    		break;
	    	}
	    	
	    	//Creating a regular array for pentagon x and y points
	    	int[] penta_xPoints = {xPos, xPos+randSize/2, xPos-randSize/8, xPos-randSize/8, xPos-randSize/4};
	    	int[] penta_yPoints = {yPos, yPos+randSize/2, yPos+randSize, yPos+randSize, yPos+randSize/2};
	    	
	    	//Creating a regular array for hexagon x and y points
	    	int[] hex_xPoints = {xPos, xPos+randSize, xPos+((3/2)+randSize), xPos-((3/2)+randSize), xPos-randSize, xPos-((3/2)+randSize), xPos+((3/2)+randSize)};
    		int[] hex_yPoints = {yPos, yPos, yPos+randSize/2, yPos+randSize, yPos+randSize, yPos+randSize/2};

	    	if(e.getKeyCode() == KeyEvent.VK_H) {
	    		
	    		
	    		switch(randomShape) {
	    		//1 is Square:
	    		case 1: 
	    			Square mySquare = new Square(randomFillColor, xPos, yPos, xDirection, yDirection, randSize);
	    			shapeList.add(mySquare);
	    			break;
	    		
	    		//2 is Circle:
	    		case 2: 
	    			Circle myCircle = new Circle(randomFillColor, xPos, yPos, xDirection, yDirection, randSize);
	    			shapeList.add(myCircle); 
	    			break;

	    		//3 is Rectangle:
    			case 3:
    				Rectangle myRectangle = new Rectangle(randomFillColor, xPos, yPos, xDirection, yDirection, randSize, randSizeTwo);
    				shapeList.add(myRectangle);
    				break;
    				
    			//4 is Quadrilateral:
    			case 4: 
    				Quadrilateral myQuad = new Quadrilateral(randomFillColor, xPos, yPos, xDirection, yDirection, randSize, randSizeTwo);
    				shapeList.add(myQuad);
    				break;
    				
    			//5 is Oval:
    			case 5: 
    				Oval myOval = new Oval(randomFillColor, xPos, yPos, xDirection, yDirection, randSize, randSizeTwo);
    				shapeList.add(myOval);
    				break;
    			
    			
    				
    			//6 is Triangle:
    			case 6:
    	    			Triangle myTriangle = new Triangle(randomFillColor, xPos, yPos, xDirection, yDirection, randSize, randSize);
    	    			shapeList.add(myTriangle);
    	    			break;
    				
    			//7 is Pentagon
    			case 7: 
    				Pentagon myPentagon = new Pentagon(randomFillColor, xPos, yPos, xDirection, yDirection, randSize, penta_xPoints,penta_yPoints);
    				shapeList.add(myPentagon);
    				break;
    				
    			//8 is Hexagon:
    			case 8: 
    				Hexagon myHexagon = new Hexagon(randomFillColor, xPos, yPos, xDirection, yDirection, randSize, hex_xPoints, hex_xPoints);
    				shapeList.add(myHexagon);
    				break;
  
	    		}

    		}
	    	
	    	
	    	//For the Sake of regrading my Lab, I added a J key you can press to test collisions 
	    	//Since circles and squares will apper only
	    	if(e.getKeyCode() == KeyEvent.VK_J) {
	    		switch(randomCircleOrSquare) {
	    		//1 is Square:
	    		case 1: 
	    			Square mySquare = new Square(randomFillColor, xPos, yPos, xDirection, yDirection, randSize);
	    			shapeList.add(mySquare);
	    			break;
	    		
	    		//2 is Circle:
	    		case 2: 
	    			Circle myCircle = new Circle(randomFillColor, xPos, yPos, xDirection, yDirection, randSize);
	    			shapeList.add(myCircle); 
	    			break;
	    		}
	    		
	    	}
    }
    
    
    
    //No implementation is needed for this lab assignment.
    @Override
    public void keyReleased(KeyEvent e) {}


    //No implementation is needed for this lab assignment.
    @Override
    public void keyTyped(KeyEvent e) {}
} 
