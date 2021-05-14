import java.util.Scanner;

public class MenuProgram {
/*
 * @author: Aaron Lack, alack
 * Last edited: 2/7/20
 * Pseudocode: 
 * The user must input either A,B,C, or E to view a specific pattern
 * Write a bunch of if statements that take the user character value to display appropriate pattern
 * Look up how to  make a menu based program, cite any online resources you use. 
 * Write loops for how to make the shapes. 
 * I found a great resource on how to make some of the patterns to make  
 * Website: https://www.edureka.co/blog/30-pattern-programs-in-java/ 
 */
	public static void menuProgram(int size) {
		//Pattern A:
		//Size is the input the user takes that determines   
	    //This section of the loop decreases the elements in the rows, ex: from 5 to 1
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a character to display a pattern: ");
		
		//Initializes it to something, D is irrelevant, so it will won't throw an error.  
		char pattern = 'D';
		
		//This is a condition that allows the patterns to keep displaying
		while (pattern != 'E')
		{
			//This takes the user input and evaluates the options for if/else statements. 
			//I have displayed the options here and in main to start out.  
			//The code works well, but options are displayed before the pattern.  
			//You can still enter a value to get this code to work.  
			
			pattern = sc.next().charAt(0);
			System.out.println("________Menu________");
			System.out.println("A: Pattern 1");
			System.out.println("B: Pattern 2");
			System.out.println("C: Pattern 3");
			System.out.println("E: Exit");
			
			if (pattern == 'A')
		    {
		    	for (int i = 1; i <= size; i++) 
			    {
			        for (int j = 1; j < i; j++) 
			        {
			            System.out.print(" ");
			        }
			          
			        for (int k = i; k <= size; k++) 
			        { 
			        	System.out.print(k+" "); 
			        } 
			        System.out.println(); 
			     }
			    
			    //This section of the loop increases the elements of the row, ex: back from 1 to 5.  
		
			    for (int i = size-1; i >= 1; i--) 
			    {
			         for (int j = 1; j < i; j++) 
			        {
			            System.out.print(" ");
			        }
			        for (int k = i; k <= size; k++)
			        {
			            System.out.print(k+" ");
			        }
			          
			        System.out.println();
			    }
		    }
			
		    //Pattern B:
		    else if (pattern == 'B')
		    {
			    for (int i=1; i<= size ; i++)
			    {
			        for (int j = i; j < size ; j++) 
			        {
			            System.out.print(" ");
			        }   
			        for (int k = 1; k <= (2*i -1) ;k++) 
			        {
			            if( k==1 || i == size || k==(2*i-1)) 
			            {
			                System.out.print("*");
			            }
			            else 
			            {
			                System.out.print(" ");
			            }
			        }
			        System.out.println("");
			    }
		    }
		    
		    
		    
		    //Pattern C
		    //For this pattern it increases the values when given a size
		    else if (pattern == 'C')
		    {
		    	for (int i=1; i<= size ; i++) 
			    { 
			    	for (int j = size; j > i ; j--) 
			    	{
			    		System.out.print(" ");
			    	}
			    	System.out.print("*");
			    	for (int k = 1; k < 2*(i -1) ;k++) 
			    	{ 
			    		System.out.print(" "); 
			    	} 
			    	if( i==1) 
			    	{ 
			    		System.out.println(""); 
			    	} 
			    	else 
			    	{ 
			    		System.out.println("*"); 
			    	} 
			    } 
			    
			    //This nested for loop decreases the size when given a value.  
			    for (int i=size-1; i>= 1 ; i--)
			    {
			    	for (int j = size; j > i ; j--) 
			    	{
			    		System.out.print(" ");
			    	}
			    	System.out.print("*");
			    	for (int k = 1; k < 2*(i -1) ;k++) 
			    	{
			        System.out.print(" ");
			    	}
			    	if( i==1)
			    	{
			    		System.out.println("");
			    	}
			    		
			    	else
			    	{
			    		System.out.println("*");
			    	}	
			    }
		    }
		    
		    else
		    {
		    	System.out.println("Exiting Program");
		    }
		}
	}
	
	public static void main(String[] args) {
		
		
        //This will be inside main     
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the pattern: ");
		int size = sc.nextInt();
		
		System.out.println("________Menu________");
		System.out.println("A: Pattern 1");
		System.out.println("B: Pattern 2");
		System.out.println("C: Pattern 3");
		System.out.println("E: Exit");
		
		menuProgram(size);

	}

}
