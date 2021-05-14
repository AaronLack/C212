import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* Header
* @Author: Aaron Lack, alack
* Last edited: 5/3/20
* Class Radix, the modified version of radix sort.
* Pseudocode for this problem:
* Input array with n integer of d digits
* Find the max element to get the max digits
* Loop through each digits of every element and save it in the auxiliary array
* and construct back the original array on the bases of element position in auxiliary array
* Final output is sorted array. 
* 
* IMPORTANT NOTE FOR GRADER: This new algorithm is going to be of runtime of O(n*d). A linear runtime.
*/

public class Radix {

   //Find Max for positive numbers in array
	public int getMax(int arr[]){
       int max = arr[0];
       for(int i = 0; i < arr.length; i++){
           if(arr[i] > max){
               max = arr[i];
           }
       }
       return max;
   }

	//Find Min for negative numbers in array
   public int getMin(ArrayList<Integer> k){
       int min = k.get(0);
       for(int i = 0; i < k.size(); i++){
           if(k.get(i) < min){
               min = k.get(i);
           }
       }
       return min;
   }

   //Sorting the array.
   //%10 is used to seperate all the digits in the aux arrays.
   public void sort(int arr[], int exponent){

	   int output[] = new int[arr.length];
	   int aux[] = new int[10];
	   Arrays.fill(aux, 0);
		
	   for(int i = 0; i <arr.length; i++) {
		   aux[(arr[i]/exponent) % 10]++;
	   }
		
	   for(int i = 1; i < 10; i++) {
		   aux[i] += aux[i-1];
	   }
		
	   for(int i = arr.length -1; i >= 0; i--) {
		   output[aux [(arr[i]/exponent) % 10] -1] = arr[i];
		   aux[ (arr[i]/exponent)%10 ]--;
	   }
		
	   for(int i = 0; i<arr.length; i++) {
		   arr[i] = output[i];
	   }
   }

   //The modified radix sort algorithm, factoring in positive and negative values
   public int[] radix(int arr[]){
       //Counters
	   int positive = 0;
       int negative = 0;


       //Loop to update positive and negative values
       for(int i = 0; i < arr.length; i++){
           int j = arr[i];
           if(i >=0){
              positive++;
           }
           else if(i < 0){
               negative++;
           }
       }

       //Two seperate arrays for positive and negative values.
       int[] positiveNumbers = new int[positive];
       int[] negativeNumbers = new int[negative];
       
       //positive and negative index counters
       int pos = 0;
       int neg = 0;

       for(int j = 0; j<arr.length; j++){
           int i = arr[j];
           if(i >= 0){
               positiveNumbers[pos] = i;
               pos++;
           }
           else if(i < 0){
               negativeNumbers[neg] = i;
               neg++;
           }
       }

       //Finding max of array:
       int findMax = getMax(positiveNumbers);
       for(int i = 1; findMax/i >0 ; i *= 10){
           sort(positiveNumbers, i);
       }

       //Negative numbers, use absolute value to get them to sort properly.
       if(negativeNumbers.length != 0){
           for(int i = 0; i < negativeNumbers.length; i++){
               negativeNumbers[i] = Math.abs(negativeNumbers[i]);
           }

           int v = getMax(negativeNumbers);
           for(int i = 1; v/i >0 ; i *= 10){
               sort(negativeNumbers, i);
           }

       }
       
       //Final result array
       int[] result = new int[arr.length];

       for(int i =0; i<positiveNumbers.length; i++){
           result[i+negativeNumbers.length] = positiveNumbers[i];
       }

       //An array list to deal with negatives.
       //One must remove the negative numbers so that they don't reappear for loop,
       //So I use an array list to do that since this is tricky with an array. 
       ArrayList<Integer> negatives = new ArrayList<>();
       for(int i: negativeNumbers){
           negatives.add(i);
       }

       for(int i = negatives.size()-1; i>=0; i--){
           int k = getMin(negatives);
           negatives.remove(negatives.indexOf(k));
           result[i] = -1*k;
       }

       return result;

   }
  
}
