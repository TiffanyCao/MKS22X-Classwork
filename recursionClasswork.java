import java.util.*;

public class recursionClasswork{
  public static List<String> makeAllWords(int k, int maxLetter){
    List<String> allWords = new ArrayList<String>();
    makeWordsH(k, "", maxLetter, allWords);
    return allWords;
  }

  private static void makeWordsH(int k, String temp, int maxLetter, List<String> data){
    if(k == 0){
      data.add(temp);
      temp = "";
    }else{
      String t = temp;
      for(int i = 1; i <= maxLetter; i++){
        makeWordsH(k-1, temp+=(char)(96+i), maxLetter, data);
        temp = t;
      }
    }
  }

  public static void main(String args[]){
    System.out.println(makeAllWords(1, 26));
    System.out.println(makeAllWords(2, 2));
    System.out.println(makeAllWords(2, 3));
  }
}
