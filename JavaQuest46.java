/*
 * Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
 * 
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 * 
 */
public class JavaQuest46 {
  public static void main(String[] args) {
    System.out.println(findGCD(new int[] {2, 5, 6, 9, 10}));
    System.out.println(findGCD(new int[] {7, 5, 6, 8, 3}));
    System.out.println(findGCD(new int[] {3, 3}));

  }

  public static int findGCD(int[] nums) {
    int min = nums[0];
    int max = nums[0];
    int result = 0;
    for (int i=0; i<nums.length;i++) {
      if (nums[i]< min){
        min = nums[i];
      } else if (nums[i] > max) {
        max = nums[i];
      } 
    }
    for (int i=1; i<=max; i++) {
      if (min % i == 0 && max % i ==0 && min!=max) {
        result = i;
      } else if (min==max) {
        result = min;
      }
    }
    return result;
  }

}
