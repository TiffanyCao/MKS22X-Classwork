import java.util.*;

public class partition{

    private static int pivotIndex;
    private static int pivot;
    private static int start;
    private static int end;

  /**A method that recursively calls to sort the array so all values greater than the randomly chosen pivot are to its right
  *and all values less than the randomly chosen pivot are to its left
  *@param int[] data
  *@param int starting
  *@param int ending
  *@return int the new index of the pivot
  */
  public static int partition(int[] data, int starting, int ending){
    if(starting == 0){ //at the start, setup
      Random choose = new Random(); //choose random index for pivot
      pivotIndex = Math.abs(choose.nextInt()) % data.length;
      System.out.println(pivotIndex);
      pivot = data[pivotIndex]; //store pivot
      System.out.println(pivot);
      data[pivotIndex] = data[0]; //swap pivot with value at index zero
      data[0] = pivot;
      pivotIndex = 0;
      start = 1; //set the start to 1
      end = ending; //end stays the same
      System.out.println(print(data));
      return partition(data, start, end); //recursive call
    }
    if(starting != ending){ //if more swaps can be tested...
      System.out.println(start);
      System.out.println(end);
      while(data[start] > pivot){ //if the value at the start index is greater than the pivot
        int temp = data[start]; //swap with value at end index
        data[start] = data[end];
        data[end] = temp;
        end--; //end index decreases
      }
      System.out.println(print(data));
      start++; //start index increases after the value at current start index is less than the pivot
      return partition(data, start, end); //recursive call with the new start and end
    }
    if(starting == ending){ //if no more swaps can be tested...
      if(data[start] < pivot){ //if the value at the middle index is less than the pivot, switch with pivot
        int temp = data[start];
        data[start] = pivot;
        data[0] = temp;
        return start; //return pivot's new index
      }else{ //if the value at the middle index is greater than the pivot, switch pivot with value at middle index - 1
        int temp = data[start-1];
        data[start-1] = pivot;
        data[0] = temp;
        return start-1; //return pivot's new inde
      }
    } return -1; //return -1 if all else fails
  }

  /**A method that prints out the array
  *@return String
  */
  public static String print(int[] data){
    String result = "[";
    for(int i = 0; i < data.length; i++){
      if(i != data.length-1){
        result += data[i] + ", ";
      }else{
        result += data[i] + "]";
      }
    }
    return result;
  }

  public static void main(String[] args){
    int[] test = {17, 61, 67, 47, 93, 12, 20,	4, 44, 68};
    System.out.println(print(test));
    System.out.println(partition(test, 0, test.length-1));
    System.out.println(print(test));
  }
}
