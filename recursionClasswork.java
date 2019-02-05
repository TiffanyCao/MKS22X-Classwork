import java.util.*;

public class Words{
  public static List<String> makeAllWords(int k, int maxLetter){
    List<String> allWords = new ArrayList<String>();
    String temp = "";
    makeWordsH(k, temp, maxLetter, allWords);
    return allWords;
  }

  private static void makeWordsH(int k, String temp, int maxLetter, List<String> data){
    if(k == 0){
      data.add(temp);
    }else{
      makeWordsH(k-1, temp+=(char)97, maxLetter, data);
      makeWordsH(k-1, temp+=(char)98, maxLetter, data);
      //makeWordsH(k-1, temp+=(char)99, maxLetter, data);
    }
  }

  public static void main(String args[]){
    //System.out.println(makeAllWords(1, 26));
    System.out.println(makeAllWords(2, 2));
    //System.out.println(makeAllWords(2, 2));
  }
}
