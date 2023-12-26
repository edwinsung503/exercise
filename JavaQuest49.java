/*Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,

return the number of negative numbers in grid.

Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100 */
public class JavaQuest49 {
  public static void main(String[] args) {
    System.out.println(
        countNegatives(new int[][] { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } }));// Output:
                                                                                                                // 8

    System.out.println(countNegatives(new int[][] { { 3, 2 }, { 1, 0 } }));// Output : 0
    System.out.println(countNegatives(new int[][] { { -100, -99, -88 }, { -1, 100, 99 } }));// Output : 4
  }

  public static int countNegatives(int[][] grid) {
    int count = 0;
    for (int i=0; i<grid.length;i++){
        for (int j=0; j< grid[i].length;j++){
            if (grid[i][j] < 0){
                count ++;
            }
        }
      }
      return count;
  }

}
