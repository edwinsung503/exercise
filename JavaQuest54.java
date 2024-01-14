/* Given three integer arrays nums1, nums2, and nums3, return a distinct array containing all the values that are present in at least two out of the three arrays. You may return the values in any order.


Example 1:
Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
Output: [3,2]
Explanation: The values that are present in at least two arrays are:
- 3, in all three arrays.
- 2, in nums1 and nums2.

Example 2:
Input: nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
Output: [2,3,1]
Explanation: The values that are present in at least two arrays are:
- 2, in nums2 and nums3.
- 3, in nums1 and nums2.
- 1, in nums1 and nums3.

Example 3:
Input: nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
Output: []
Explanation: No value is present in at least two arrays.


Constraints:

1 <= nums1.length, nums2.length, nums3.length <= 100
1 <= nums1[i], nums2[j], nums3[k] <= 100*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaQuest54 {
  public static void main(String[] args) {
    int[] nums1 = new int[] { 3, 1 };
    int[] nums2 = new int[] { 2, 3 };
    int[] nums3 = new int[] { 2, 1 };
    System.out.println(twoOutOfThree(nums1, nums2, nums3));// [1,2,3]

    int[] nums4 = new int[] { 1, 1, 3, 2 };
    int[] nums5 = new int[] { 2, 3 };
    int[] nums6 = new int[] { 3 };
    System.out.println(twoOutOfThree(nums4, nums5, nums6));// [2,3]

    int[] nums7 = new int[] { 1, 2, 2 };
    int[] nums8 = new int[] { 4, 3, 3 };
    int[] nums9 = new int[] { 5 };
    System.out.println(twoOutOfThree(nums7, nums8, nums9));// []

  }

  public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
          List<Integer> arr = new ArrayList<>();
        int [] arr4 = new int [101];
        Set<Integer> arrSet1 = new HashSet<>();
        for (int i=0;i<nums1.length;i++){
            arrSet1.add(nums1[i]);
        }
        for (int s: arrSet1){
            arr4[s] ++;
        }
        Set<Integer> arrSet2 = new HashSet<>();
        for (int i=0;i<nums2.length;i++){
            arrSet2.add(nums2[i]);
        }
        for (int s: arrSet2){
            arr4[s] ++;
        }
        Set<Integer> arrSet3 = new HashSet<>();
        for (int i=0;i<nums3.length;i++){
            arrSet3.add(nums3[i]);
        }
        for (int s: arrSet3){
            arr4[s] ++;
        }
        //System.out.println(Arrays.toString(arr4));
        for (int i=0; i< arr4.length;i++){
            if (arr4[i] >= 2){
                arr.add(i);
            }
        }
        return arr;
  }

}
