import java.util.Arrays;


public class BirthdayParadox{
  
  //Question 1.1: Returns an array of random integers between 0 and range-1. 
  public static int[] generateArray(int size, int range){
   //Declare array and the size it will have.
    int [] Array = new int [size];
    //Store the random values into the array.
    for (int i = 0; i < Array.length; i++){
      Array[i] =  (int) (Math.random() * (range));//not range-1 because the limit is inclusive
    }
    return Array;
  }
  //Method to print an array.
  public static void printArray(int [] anArray){
    System.out.println(Arrays.toString(anArray));
  }
  
  //Question 1.2:
  //Method that stores the random arrays created above into a multi dimentional array.
  public static int[][] generateAllData(int iterations, int size, int range){
    //Create a 2D Array that will contain iterations arrays, each of declared size and containing integers ranging from
    //0 to range-1.
    int [][] data = new int[iterations][size];
    //Filling up each array with the previous method to create a full 2D array.
    for (int i = 0; i < iterations; i++){
      data[i] = generateArray(size,range);
    }
    return data;
  }
  //Question 1.3: Method that counts how many times an element is present in a 2D array.
  public static int countElement(int [][] arr, int element){
    //Initiate a counter.
    int counter = 0;
    //The outer loop goes through all the arrays and the inner loop goes through all the elements.
    for (int i = 0; i < arr.length; i++){
      for (int j = 0;j < arr[i].length; j++){
        //If the elements match, increment the counter.
        if (arr[i][j] == element){
          counter++;
        }
      }
    }
    return counter;
  }
  //Question 1.4: Method that scans through an 2d array and returns the value that occurs the most frequently (the mode).
  public static int maxDay(int [][] testArray){
    //Declare the counter and the potential mode. 
    int highestCount = 0;
    int mode = testArray[0][0];
    for (int i = 0; i < testArray.length; i++){
      for (int j = 0;j < testArray[i].length; j++){
        //Record how many times an element is repeated. 
        int count = countElement(testArray,testArray[i][j]);
        //If an element is repeated more than the previous one, we record that element as the new mode.
        //Once we exit the loop, only the value that was repeated the most will remain. 
        if (count > highestCount){
          highestCount = count;
          mode = testArray[i][j];
        }
      }
    }
    return mode;
  }
  //Quetsion 1.5: Method that determines whether or not an array has duplicates.
  public static boolean hasDuplicates(int[] arrayWithDuplicates){
    //Our methods up to now work only with multidimensonal arrays: we convert the input into a 2d array to apply our 
    //current methods.
    int[][] multiArray = new int[1][];
    multiArray[0] = arrayWithDuplicates; 
    //Identify the potential duplicate.
    int duplicate = maxDay(multiArray);
    //If the integer appears more than once, then it is a duplicate.  
    return (countElement(multiArray, duplicate) > 1);
  }
  
  //Question 1.6: Method that will indicate how many out of 200 arrays have duplicates.
  public static double runExperiment(int size){
    //Create a multidimensional array.
    int[][] subject = generateAllData(200,size,365);
    //Throw an exception to indicate that the size of the array must be of at least one element.
    if (size < 1){
      throw new IllegalArgumentException("Size must be greater or equal to 1.");
    }
    //Initialize a counter that will count how many times a duplicate is encountered.
    int counter = 0;
    for (int i = 0; i < subject.length; i++){
      if (hasDuplicates(subject[i])){
        counter++;
      }
    }
    //We must divide the number of duplicates encountered by the number of sub-arrays to obtain a ratio.
    //The counter must be cast into a double to not lose precision in the division. 
    return (double)counter/subject.length;
  }
      
    
  //Question 1.7: The main method will print a table of ratios showing that the probability of two people in a room 
  //having the same birthday for every total number of people in the room up to 100 people. 
  public static void main(String[] args){ 
    //The size reprensents the total number of people in the room.
    int size = 100;
    //The loop will increment the number of people by 1 until it reaches 100. 
    for (int i = 1; i <= size; i++){
      System.out.print((i) + " ");
      System.out.println(runExperiment(i));
    }
     
    //Testing the previous methods (not part of the question 1.7):
    /*int [][] sample = generateAllData(3,4,3);
    for(int i=0;i<sample.length;i++){
      printArray(sample[i]);
    
    System.out.println(countElement(sample,1)); 
    System.out.println(maxDay(sample));
    System.out.println(hasDuplicates(generateArray(5,10)));
    System.out.println(runExperiment(5));*/
    
   }
}

  



      
      
    
      
    
  
  
  
 
  



    
   
  

















