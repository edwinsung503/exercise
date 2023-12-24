/*
 * Question : Given two strings s and goal, 
 * return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.

the input need to be lowercase English letters.
*/

import java.util.Arrays;

public class JavaQuest20 {

  public static void main(String[] args) {
    System.out.println(rotateString("abcde", "cdeab"));// true
    System.out.println(rotateString("abcde", "abced"));// false
    System.out.println(rotateString("abcde", "eabcd"));// true
    System.out.println(rotateString("abcde", "abcde"));// true
  }

  public static boolean rotateString(String s, String goal) {
    char [] arrS = s.toCharArray();
    char temp = ' ';
    for (int i=0; i < arrS.length;i++){
      for (int j=0; j < arrS.length-1;j++){
        temp = arrS[j];
        arrS[j] = arrS[j+1];
        arrS[j+1] = temp;
      }
      StringBuilder sb = new StringBuilder();
      sb.append(arrS);
      if (sb.toString().equals(goal)){
        return true;
      }
    }
    
    return false;
  }
}
