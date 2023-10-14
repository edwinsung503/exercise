
/**
 * Expected Output:
 * J
 * e
 * 3
 * 9
 * 10
 * ab c
 * VenturenixLAB, Coding
 * 19
 * ren
 * VENTURENIXLAB, JAVA
 * venturenixlab, java
 * V*NTUR*NIXLAB, JAVA!!!
 */
public class JavaQuest9 {
  public static void main(String[] args) {
    String str = "VenturenixLAB, Java";
    // prints J
    // prints e (the 1st e)
    // code here ...
    int count = 0;
    char indexJ = ' ';
    char indexe = ' ';
    for (int i=0; i < str.length() ; i++){
      if (str.charAt(i) == 'J') {
        indexJ = str.charAt(i);
      } else if (str.charAt(i)=='e'&& count <1) {
        indexe = str.charAt(i);
        count ++;
      }
    }
    System.out.println(indexJ);
    System.out.println(indexe);
    
    // Use indexOf()
    // prints 3
    // prints 9
    // prints 10
    // code here ...
    
    for (int i=0;i<str.length();i++){
      if(str.indexOf(str.charAt(i))==3 ||str.indexOf(str.charAt(i))==9||str.indexOf(str.charAt(i))==10) {
        System.out.println(str.indexOf(str.charAt(i)));
      }
    }
    // Use String trim()
    String abc = "    ab c    ";
    // prints "ab c"
    System.out.println(abc.trim());
    // Use String replace() method
    // prints VenturenixLAB, Coding
    // code here ...
    System.out.println(str.replace("Java","Coding"));
    
    // int length()
    // prints 19
    // code here ...
    System.out.println(str.length());

    // Use String substring(int start, int end)
    // prints "ren"
    // code here ...
    //VenturenixLAB, Coding
    for (int i=0;i <str.length();i++){
      if(str.charAt(i) =='r') {
        System.out.println(str.substring(i, i+3));
      }
    }

    // print "VENTURENIXLAB, JAVA"
    // prints "venturenixlab, java"
    // code here ...
    System.out.println(str.toUpperCase());
    System.out.println(str.toLowerCase());
    // Method Chaining (one line to complete)
    // prints "V*NTUR*NIXLAB, JAVA!!!"
    // code here ...
    System.out.println(str.toUpperCase().replace('E','*').concat("!!!"));

  }
}