/*Given a 0-indexed string s, repeatedly perform the following operation any number of times:

Choose an index i in the string, and let c be the character in position i. 
Delete the closest occurrence of c to the left of i (if any) 
and the closest occurrence of c to the right of i (if any).
Your task is to minimize the length of s by performing the above operation any number of times.

Return an integer denoting the length of the minimized string. */

import java.util.HashSet;
import java.util.Set;

public class JavaQuest31 {
  public static void main(String[] args) {
    System.out.println(minStringLength("null"));// output : 3
    System.out.println(minStringLength("aaa"));// output : 1
    System.out.println(minStringLength("abcabcabc"));// output : 3
    System.out.println(minStringLength("bbccdd"));// output : 3
    System.out.println(minStringLength("helloworldhelloworld"));// output : 7
  }

  public static int minStringLength(String s) {
    // code here
    Set<Character> arr = new HashSet<>();
        for (int i=0; i< s.length();i++){
            arr.add(s.charAt(i));
        }
        return arr.size();
  }
}
