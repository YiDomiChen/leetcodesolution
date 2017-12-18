/**
 * 
 * @LeetCode 200. Number of Islands
 * @Description Solved by DFS. For details, see UnionFound-NumOfIslands
 * @Difficulty: 
 * @Tags: 
 * @Author: Yi Chen
 * @CreatedTime: May 19, 2017
 * @LastEditTime: May 19, 2017
 *
 */
package numofislands;

public class NumOfIslands {
		
	/**
	 * Approached by Depth-First Search
	 * 
	 */
	public int numIslands(char[][] grid) {
		if(grid.length == 0 || grid[0].length == 0) return 0;
		int m = grid.length, n = grid[0].length;
		int count = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == '1') {
					DFSMarking(i, j, grid);
					count++;
				}
			}
		}
		
		return count;
	}
		
	private void DFSMarking(int i, int j, char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;
		grid[i][j] = '0';
		DFSMarking(i - 1, j, grid);
		DFSMarking(i + 1, j, grid);
		DFSMarking(i, j - 1, grid);
		DFSMarking(i, j + 1, grid);
		
	}
}
