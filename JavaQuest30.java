/*Given an integer num, return the number of digits in num that divide num.

An integer val divides nums if nums % val == 0. */

/*Example 1:
Input: num = 7
Output: 1
Explanation: 7 divides itself, hence the answer is 1.

Example 2:
Input: num = 121
Output: 2
Explanation: 121 is divisible by 1, but not 2. Since 1 occurs twice as a digit, we return 2.

Example 3:
Input: num = 1248
Output: 4
Explanation: 1248 is divisible by all of its digits, hence the answer is 4. */
public class JavaQuest30 {
  public static void main(String[] args) {
    System.out.println(countDigits(7));//output : 1 
    System.out.println(countDigits(121));// output : 2
    System.out.println(countDigits(1248));// output : 4 
    System.out.println(countDigits(999999)); //outpiy : 6
  }

  public static int countDigits(int num) {
    String str = String.valueOf(num);
    int count = 0;
    for (int i=0; i< str.length();i++) {
      if (num % Integer.valueOf(str.charAt(i)-'0') ==0) {
        count ++; 
      }
    }
    return count;
  }
}
