////////////////////////////////////////////////////////////////////////////////////
//  C212
//   
//  Released:  1/20/20
//
//  Lab 2
//  @Author  Aaron Lack, alack
//  Last Edited: 1/27/20
//
//
//  Directions: See Below 
//               
//////////////////////////////////////////////////////////////////////////////////

// 1. Change the following program to use compound assignments, pre- or post- increment/decrement statements ONLY as appropriate.
class CompoundExercises { 

     public static void compoundOperators(){
           
          int result = -1; // result is -1
          System.out.println(result);

          // result = result - 1; (previous) // result is now -2
          result = --result; // new
          System.out.println(result);

          // result = result * -2;  (previous) // result is now 4
          result = ++result + ++result + ++result + ++result + result++; //new
          System.out.println(result);

          // result = result / 2; // result is now 2
          result = result-- - --result; //new
          System.out.println(result);

          //result = result + 3; // result is now 5
          result = result++ + result++; //new
          System.out.println(result);

          //result = result % 3; // result is now 2
          result = result-- - --result; //new
          System.out.println(result);
     }
     
// 2. In the following program, explain why the value "-4" is printed thrice in a row:
     public static void question1() {
        int i = -5;
        i++;
        System.out.println(i);    // "-4"
        ++i;                     
        System.out.println(i);    // "-3" 
        System.out.println(--i);  // "-4" 		(1)
        System.out.println(i--);  // "-4"		(2)
        System.out.println(++i);  // "-4"		(3)
        
        //The first println statement is a pre-decrement, so when the program is compiled, it will immediately decresase the value from -3 --> -4.  
        //The second println statement is a post-decrement, so it will return -4 and when another print statement after it is made. It should decrease the value from -4 --> -5 when this happens.
        //The third println statement is a pre-increment, and in this case it will add one to the previous value.  Siince -5 was stored, it will add one and display -4.  The second and third println statemnts kinda "cancel" each other out and yield the same value of -4.  
     }
}