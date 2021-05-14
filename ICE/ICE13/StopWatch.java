/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 4/24/20
* Class Stopwatch, code directly taken from the bookcode java files given.
* I am using this to find the runtime of linear and binary search for my ICE13. 
* A stopwatch accumulates time when it is running.
* You can repeatedly start and stop the stopwatch.
* You can use a stopwatch to measure the running time of a program.
*/

public class StopWatch {
	
   private long elapsedTime;
   private long startTime;
   private boolean isRunning;

   //Constructs a stopwatch that is in the stopped state and has no time accumulated.
   public StopWatch() {  
      reset();
   }

   //Starts the stopwatch. Time starts accumulating now.
   public void start() {  
	   if (isRunning) { 
    	  return; 
	   }
      isRunning = true;
      startTime = System.currentTimeMillis();
   }
   
   //Stops the stopwatch. Time stops accumulating and is added to the elapsed time.
   public void stop() {  
	   if (!isRunning) { 
    	  return; 
	   }
      isRunning = false;
      long endTime = System.currentTimeMillis();
      elapsedTime = elapsedTime + endTime - startTime;
   }
   

   //Returns the total elapsed time.
   public long getElapsedTime() {  
      if (isRunning) {  
         long endTime = System.currentTimeMillis();
         return elapsedTime + endTime - startTime;
      }
      else {
         return elapsedTime;
      }
   }

   //Stops the watch and resets the elapsed time to 0.
   public void reset() {  
      elapsedTime = 0;
      isRunning = false;
   }
}

