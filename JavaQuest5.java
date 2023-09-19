/**
 * 
 * When target = 'c', the expected output:
 * We found 3 character c in the String.
 * 
 * When target = 'z', the expected output:
 * Not Found.
 */
// Count the target of character in a String.
public class JavaQuest5 {
  public static void main(String[] args) {
    String str = "Welcome to the coding bootcamp."; // You should not change this line
    char target = 'c'; // Update this target to test the logic
    int num =0;
    // Use a loop to count the target of character in a String.
    // code here
    char [] characters = str.toCharArray();
    for (int i = 0; i < characters.length; i++) {
      if (characters[i] == target) {
        num +=1;
      }
    }
    // if found, print "We found 3 character c in the String."
    // if not found, print "Not Found."
    // code here
    if (num ==3) {
      System.out.println("We found 3 character c in the String.");
    } else {
      System.out.println("Not Found.");
    }

    
  }
}
