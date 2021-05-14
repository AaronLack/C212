//  Lab 2 
//  
//  Released:  1/20/20
//
//  @Author  Aaron Lack and alack
//  Last Edited:  
//
//
//  Directions:  Implement the following methods 
//               
//               
//////////////////////////////////////////////////////////////////////////////////

// Note:  Do not need to explicitly import classes from java.lang but wanted to make it explicit 
// Goal - understand using Static classes - i.e. the Math class was not designed to be Instantiated (make objects) 
// It is a class that provides functionality and will be used to complete one of the methods
import java.lang.Math;
import java.util.Scanner;

public class Lab2Exercises { 
    
    // computes area of a square when given its side length
    public static int areaOfSquare(double sideLength) {
    	double areaOfSquare = Math.pow(sideLength, 2);
    	return (int) areaOfSquare;
    }

    // computes perimeter of a square when given its side length
    public static int perimeterOfSquare(double sideLength) {
    	double perimeterOfSquare = sideLength * 4;
    	return (int) sideLength;
    }

    // computes volume of a cubic when given its side length
    public static double volumeOfCube(double sideLength) {
      double volumeOfCube = Math.pow(sideLength, 3);
      return volumeOfCube;
      
    }
       
    // returns a String with two lines in the following format:
    // On Line1: "Length of one Side of Square is: *
    // On Line2: "Area: *, Perimeter: **, Volume: **** " where * refers to area, ** refers to 
    // perimeter of square and *** refers to volume of the cube respectively. 
    public static String printMeasurements(int value) {
    		String meausrement = "Length of square: "+value+"\nArea: "+areaOfSquare(value) + " Perimeter: " + perimeterOfSquare(value) + " Volume: " + volumeOfCube(value);
    		return meausrement;
  	  	 
      // Please reuse any of the functions defined above.
     
    }
    
	// given two points (x1,y1) and (x2,y2) return y intercept 	of the line
    public static int lineFunction(double x1, double y1, double x2, double y2) {
      double slope = (y2-y1) / (x2-x1);
      double yIntercept = y1 - (slope*x1);
      return (int) yIntercept;
   
    }

    // reads a number between 1000 and 1 Billion and prints it with commas (,) separating 
    // every three digits. for example: 12317910 will be printed as $12,317,910
    // hint use modulus (%) to save part of the number, then concatenate back together as a String
    public static String addCommas(int num) {

      // Take the quotient first, then the remander of a number.  Then put a comma inbetween q and r.  
      // return qutoint + , + remainder
      
      //I want the user to input a number
    	
    	//Convert input into a string
    	//Use substring function (length)
   
    
    	
    	if (num >= 1000 && num <= 999999) 
      {
    	int quotientThousand = num/1000;
        int modThousand = num%1000;
        String thousandCombine = quotientThousand + "," + modThousand;
        return thousandCombine;
        
      } 
      if (num >= 1000000 && num <= 999999999)
      {
    	  int quotientMillion1 = num/1000000;
    	  int modMillion1 = num%1000000;
    	  		
    	  int quotientMillion2 = modMillion1/1000;
    	  //Breaks number up again so I can add commas
    	  int modMillion2 = modMillion1%1000;

    	  String millionCombine = quotientMillion1 + "," + quotientMillion2 + "," + modMillion2;
    	  return millionCombine;
    	  //I need to go back to the thousand if statement to add another comma for the remainder
          
      } 
   	
      if (num == 1000000000) 
	  {
	  	  String billionCombine = "1,000,000,000"; 
	  	  return billionCombine;
	   }
      
      return "";
      //This is for a if condition is not satisfied. This will not crash the program.  
      
      //Use scanner class again to 
    }
    
 
    // test client 
    // Use Scanner to read inputs from user. Don't use Scanner in above functions!
    // This is where we test our code.  Call the functions
    public static void main(String[] args)  {
    	
      System.out.println(areaOfSquare(5.0));
      System.out.println(perimeterOfSquare(5.0));
      System.out.println(volumeOfCube(5.0));
      
      Scanner sc = new Scanner(System.in);
	  System.out.print("Please enter a measurement: ");
	  System.out.println(printMeasurements(sc.nextInt()));
      
      System.out.println(lineFunction(0,5,4,9));
      
   
      //int num = sc.nextInt();
      System.out.print("Please enter a number: ");

      String res = addCommas(sc.nextInt());
      System.out.println(res);
	  
	  //Questions
	  int myInt = 7;
	  double myDouble = 2.0;
	  char myChar = 'a';
	  System.out.println(myInt*myChar);		//1
	  System.out.println(myDouble*myChar);	//2
	  System.out.println(Math.pow(myChar, 2)); //3
 
	 //Test cases work when I enter numbers such as 123,456,789;
	 //Test cases do not work when I enter 100000. Ex: 1,0,0 is my outupt. How do I fix this?
	 //Same with the billion conditional, why does it get mad at me?
	  
//	  int i = 10;
//	  n = ++(i++);
//	  System.out.println(++(i++) % 5);
        
    }
}

//Ask about question formatting.  

///////////////////////////////////
//                               //
// ANSER THE FOLLOWING QUESTIONS //
//                               //
///////////////////////////////////

/*
 * Questions 1-3 are on explicit and implicit casting of some numerical types  
 *
 * 1.  What happens if you multiply an int with a char? 
 * 
 * 		Character 'a' has an ASCII value of 97, so when you multiply an integer with a char you get char, you get the integer product. In my test case, I got 679.  
 * 
 * 
 * 2.  What happens if you multiply a double with a char?
 *  Again, the numeric values get multiplied and 'a'*2.0 returns 194.0, with the product being a double.  
 * 
 * 3.  What happens if you square a char? 
 * Squaring 'a' is the same as 97 squared so I got a value of 9409.0, with the product also being a double.  
 * 
 * 4.  What happens if a method has a parameter of type int, but you pass it a char?
 * 
 * (Just an example) public static String addCommas(int num)
 * String is the return type, num is the parameter.  
 * You need to pass in a character because an error message will get thrown if you pass in an integer.  
 * 
 * 5.  What happens if a method has a parameter of type char, but you pass it an int? 
 * 
 * You need to pass in an integer, you should pass whatever the data type for the parameter is asking. For example, if you pass in a character, an error message will return because of the mixing data types.  If you pass in an integer, the program should compile because of matching data types.
    
 * 
 * 6.  What is the difference between two floating point primitive data types in the Java?\
 * 
 * 		There are two floating point primitive data types in Java.  The first is float, and the other one is double.  The main difference between them is a float the the size of the data types.  A float has a range of +/- 10E38 with a 7 decimal place precision and has a size of 4 bytes.  A double has a range of +/- 10E308 with a 15 decimal place precision and has a size of 8 bytes.  
 * 
 * 7.  Consider the following code snippet.
 *     int i = 10;
 *     n = ++(i++);
 *     System.out.println(++(i++) % 5);
 * 
 *     Without Compiling the Program:
 *     What {do you think} are the values of i and n if the code is executed?
 *     
 *     I think the value is going to be 11 because the ++ operator increments the integer value by 1.
 *     
 *     What are the final value printed?
 *     Now Compile and Run the Program to check your answers. If they are different, explain why 
 *     and provide updated code!
 *     
 *     Turns out I was wrong. The final answer was an error: Unresolved compilation problems, n cannot be resolved to a variable.  Invalid argument to operation ++/--.  
 */
