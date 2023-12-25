/*
 * Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 * 
 * Specifically, ans is the concatenation of two nums arrays.
 * 
 * Return the array ans.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,1] Output: [1,2,1,1,2,1] Explanation: The array ans is formed as follows: - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]] - ans = [1,2,1,1,2,1] Example 2:
 * 
 * Input: nums = [1,3,2,1] Output: [1,3,2,1,1,3,2,1] Explanation: The array ans is formed as follows: - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]] - ans =
 * [1,3,2,1,1,3,2,1]
 * 
 * 
 * Constraints:
 * 
 * n == nums.length, 1 <= n <= 1000, 1 <= nums[i] <= 1000
 */

import java.util.Arrays;

public class JavaQuest38 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(getConcatenation(new int[] {1, 2, 1})));//[1, 2, 1, 1, 2, 1]
    System.out
        .println(Arrays.toString(getConcatenation(new int[] {1, 2, 3, 4})));//[1, 2, 3, 4, 1, 2, 3, 4]
    System.out
        .println(Arrays.toString(getConcatenation(new int[] {4, 3, 2, 1})));//[4, 3, 2, 1, 4, 3, 2, 1]

  }

  public static int[] getConcatenation(int[] nums) {
    int copy [] = Arrays.copyOf(nums, nums.length * 2 );
    for (int i=0; i < copy.length/2; i++) {
      copy[i+ copy.length/2] = nums[i] ;
    }
    return copy;
  }

}
