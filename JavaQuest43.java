/*
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. 
 * A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every
 * other node.
 * 
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. 
 * Return the center of the given star graph.
 * 
 * 
 * Example 1: 
 * Input: edges = [[1,2],[2,3],[4,2]] 
 * Output: 2 
 * Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
 * 
 * Example 2: 
 * Input: edges = [[1,2],[5,1],[1,3],[1,4]] 
 * Output: 1
 * 
 * Constraints:
 * 
 * 3 <= n <= 105 edges.length == n - 1 .//
 * edges[i].length == 2 .//
 * 1 <= ui, vi <= n ,//
 * ui != vi ,//
 * The given edges represent a valid star graph.
 */

import java.util.HashSet;
import java.util.Set;

public class JavaQuest43 {
  public static void main(String[] args) {
    System.out.println(findCenter(new int[][] {{1, 2}, {2, 3}, {4, 2}})); // output : 2
    System.out.println(findCenter(new int[][] {{1, 2}, {5, 1}, {1, 3},{1,4}})); // output : 1
    System.out.println(findCenter(new int[][] {{4, 3}, {2, 3}, {1, 3},{3,5},{3,6},{3,7}})); // output : 3

  }

  public static int findCenter(int[][] edges) {
    Set<Integer> set = new HashSet<>();
        for (int i=0; i< edges.length; i++){
            for (int j=0; j< edges[i].length;j++){
                if ( !set.add(edges[i][j])){
                    return edges[i][j];
                }
            }
        }
        return -1;
  }

}
