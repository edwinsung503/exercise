/*
 * Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 

Example 1:
Input: nums = [3,4,5,2]
Output: 12 
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12. 

Example 2:
Input: nums = [1,5,4,5]
Output: 16
Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.

Example 3:
Input: nums = [3,7]
Output: 12
 

Constraints:

2 <= nums.length <= 500
1 <= nums[i] <= 10^3
 */
public class JavaQuest53 {
  public static void main(String[] args) {
    System.out.println(maxProduct(new int[] { 3, 4, 5, 2 }));// 12
    System.out.println(maxProduct(new int[] { 1, 5, 4, 5 }));// 16
    System.out.println(maxProduct(new int[] { 3, 7 }));// 12
    System.out.println(maxProduct(new int[] { 2, 200, 400, 400 }));// 159201
    System.out.println(maxProduct(new int[] { 1, 9, 9, 6 }));// 64

  }

  public static int maxProduct(int[] nums) {

    int maxnum = 0;
    int maxIndex = 0;
    for (int i =0; i<nums.length;i++){
        if (nums[i]>= maxnum) {
          maxnum = nums[i];
          maxIndex = i;
        }
    }
    int max = 0;
    for (int i=0; i<nums.length; i++) {
      if (max < (nums[i]-1)*(nums[maxIndex]-1) && i!=maxIndex ){
        max = (nums[i]-1)*(nums[maxIndex]-1) ;
      }
    }
    return max;
  }

}