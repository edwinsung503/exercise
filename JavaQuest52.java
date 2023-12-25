/*Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:
Input: n = 16
Output: true

Example 2:
Input: n = 5
Output: false

Example 3:
Input: n = 1
Output: true
 

Constraints:

-231 <= n <= 231 - 1
 */
public class JavaQuest52 {
  public static void main(String[] args) {
    System.out.println(isPowerOfFour(16)); // true
    System.out.println(isPowerOfFour(-231));// false
    System.out.println(isPowerOfFour(230));// false
    System.out.println(isPowerOfFour(1));// true
    System.out.println(isPowerOfFour(5));// false

  }

  public static boolean isPowerOfFour(int n) {
    return (n > 0) && (Math.log(n) / Math.log(2) % 2 == 0);
  }
}
