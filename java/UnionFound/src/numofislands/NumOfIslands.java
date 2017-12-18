package numofislands;

/**
 * 
 * @LeetCode 200 Number of Islands
 * @Description: Given a 2d grid map of '1's (land) and '0's (water), 
 * count the number of islands. An island is surrounded by water and is formed by 
 * connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * Note: You may not slant the container and n is at least 2. 
 * 
 * @Difficulty: Medium
 * Tags: Union-Found, Depth-First Search
 * @Author Yi Chen
 * @CreatedTime: May 6, 2017
 * @LastEditTime: May 6, 2017
 *
 */
public class NumOfIslands {
	
	/**
	 * Approached by Union-Find Method.
	 * 
	 * @param grid maps that represent the distribution of land and water
	 * @return number of islands
	 * 
	 */
	public int numIslands(char[][] grid) {
		if(grid.length == 0 || grid[0].length == 0) return 0;
		int m = grid.length, n = grid[0].length;
		UnionFound uf = new UnionFound(m, n, grid);
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] != '1') continue;
				int p = i * n + j;
				// Only consider the up and left direction union.
				// There is no need to union the right and below elements, which will make union in the following iteration.
				if(i > 0 && grid[i - 1][j] == '1') {
					int q = (i - 1) * n + j;
					uf.union(p, q);
				}
				if(j > 0 && grid[i][j - 1] == '1') {
					int q = i * n + j - 1;
					uf.union(p, q);
				}
				
			}
		}
		
		return uf.count;
    }				
}
