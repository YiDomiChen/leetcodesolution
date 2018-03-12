/**
 * 
 * @LeetCode 329. Longest Increasing Path in a Matrix
 * @Description: Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down. 
 * You may NOT move diagonally or move outside of the boundary 
 * (i.e. wrap-around is not allowed).

 * Example 1:
 *
 *	nums = [
 *	  [9,9,4],
 *	  [6,6,8],
 *	  [2,1,1]
 *	]

 * Return 4
 * The longest increasing path is [1, 2, 6, 9].

 * Example 2:

 *	nums = [
 *	  [3,4,5],
 *	  [3,2,6],
 *	  [2,2,1]
 *	]

 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * 
 * @Difficulty: Hard
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Jan 5, 2018
 * @LastEditTime: Jan 5, 2018
 *
 */
package longestincpath;

public class LongestIncreasingPath {
	
	public int[] dx = {1, 0, -1, 0};
	public int[] dy = {0, 1, 0, -1};
	
	public int longestPath = 0;
	
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length, n = matrix[0].length;
		int[][] dp = new int[m][n];
		
		int max = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int res = helper(matrix, dp, i, j);
				max = Math.max(res, max);
			}
		}
		
		return max;
    }
	
	public int helper(int[][] matrix, int[][] dp, int x, int y) {
		//  the DFS here is basically like DP with memorization. 
		//  Every cell that has been computed will not be computed again, 
		//  only a value look-up is performed. So this is O(mn), m and n being the width and 
		//  height of the matrix.
		//
		//  To be exact, each cell can be accessed 5 times at most: 
		//  4 times from the top, bottom, left and right and one time from the outermost 
		//  double for loop. 4 of these 5 visits will be look-ups except for the first one. 
		//  So the running time should be lowercase o(5mn), which is of course O(mn).
				
		if (dp[x][y] != 0) return dp[x][y]; 
		
		int max = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!inBound(matrix, nx, ny)) continue;
			if (matrix[nx][ny] <= matrix[x][y]) continue; 
			
			int len = 1 + helper(matrix, dp, nx, ny);
			max = Math.max(len, max);
		}
		
		dp[x][y] = max;
		return max;
	}
	
	public boolean inBound(int[][] matrix, int x, int y) {
		if (x < 0 || x >= matrix.length) {
			return false;
		}
		if (y < 0 || y >= matrix[0].length) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingPath l = new LongestIncreasingPath();
		int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};
		int max = l.longestIncreasingPath(matrix);
		System.out.println(max);
	}

}
