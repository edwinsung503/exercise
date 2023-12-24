/*
 * Question : Given a string s, return the number of segments in the string.

A segment is defined to be a contiguous sequence of non-space characters.

 * 
*/
public class JavaQuest25 {
  public static void main(String[] args) {
    System.out.println(countWords("       ")); // 0
    System.out.println(countWords("")); // 0
    System.out.println(countWords("Hello")); // 1
    System.out.println(countWords("Hello, my name is John."));// 5
    System.out.println(countWords(" . "));// 1

  }

  public static int countWords(String s) {
    // code here
    int count = 0;
    s.trim();
    if (s.length() == 0) {
      return 0;
    }
    if (s.charAt(0) != ' ') {
      count++;
    }

    for (int i = 0; i < s.length()-1; ++i) {
      if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
        count++;
      }
    }
    return count;
  }
}
