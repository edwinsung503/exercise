/**
 * Example Output
 * Second Max = 230
 */
public class JavaQuest8 {
  // Write a loop to find the second max number.
  public static void main(String[] args) {
    int[] nums = new int[] { -10, 5, 100, 240, 230, 80 }; // Second Max = 230
    int[] nums2 = new int[] { -10, 5, 100, 120, 240, 200 }; // Second Max = 200
    int[] nums3 = new int[] { -10, 5, 120, -100, 100, 240 }; // Second Max = 120
    int[] nums4 = new int[] { -10, 5, 100, 240, 240, 80 }; // Second Max = 240

    // Your program should be able to handle all the above test case.
    //int secondMax = 0;
    // code here
    System.out.println(JavaQuest8.second(nums));
    System.out.println(JavaQuest8.second(nums2));
    System.out.println(JavaQuest8.second(nums3));
    System.out.println(JavaQuest8.second(nums4));
  }

  public static int second(int [] num ) {
    int secondMax = 0;
    int temp = 0;
    //排哂次序, 尾二果個就係second max
    for (int i =0; i < num.length - 1;i++) {
      for (int j =0; j < num.length - 1; j++) {
        if (num[j] > num[j+1] ) {
          temp = num[j];
          num[j] = num[j+1];
          num[j+1] = temp;
          secondMax=num[4];
        }
      }
    }
  return secondMax;
  }
}