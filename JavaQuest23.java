/*
 * Question : 
 * given a string s of even length. 
 * Split this string into two halves of equal lengths, 
 * and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. 
Otherwise, return false.
 */

//hints : substring() , toCharArray() ?
public class JavaQuest23 {
  public boolean sameNumberOfVowels(String s) {
    // code here
    String a = s.substring(0, s.length()/ 2);
    String b = s.substring(s.length()/2, s.length());
    char [] arrA = a.toCharArray();
    char [] arrB = b.toCharArray();
    int countA = 0;
    int countB = 0;
    for (int i=0; i< arrA.length; i++){
      if (arrA[i]=='a'||arrA[i]=='e'||arrA[i]=='i'||arrA[i]=='o'||arrA[i]=='u'||arrA[i]=='A'||arrA[i]=='E'||arrA[i]=='I'||arrA[i]=='O'||arrA[i]=='U'){
        countA ++;
      }
    }
    for (int i=0; i< arrB.length; i++){
      if (arrB[i]=='a'||arrB[i]=='e'||arrB[i]=='i'||arrB[i]=='o'||arrB[i]=='u'||arrB[i]=='A'||arrB[i]=='E'||arrB[i]=='I'||arrB[i]=='O'||arrB[i]=='U'){
        countB ++;
      }
    }
    if (countA == countB){
      return true;
    }
    return false;
  }
  public static void main(String[] args) {
    JavaQuest23 javaQuest23 = new JavaQuest23();
    System.out.println(javaQuest23.sameNumberOfVowels("String"));
    System.out.println(javaQuest23.sameNumberOfVowels("Icecream"));
  }
}
