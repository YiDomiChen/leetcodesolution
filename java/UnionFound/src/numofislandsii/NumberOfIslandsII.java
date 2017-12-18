/**
 * 
 * @LeetCode   305. Number of Islands II
 * @Description A 2d grid map of m rows and n columns is initially filled with water. 
 * We may perform an addLand operation which turns the water at position (row, col) into a land. 
 * Given a list of positions to operate, count the number of islands after each addLand operation. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * @Difficulty Hard
 * @Tags Union and Find
 * @Author Yi Chen
 * @CreatedTime Jun 27, 2017
 * @LastEditTime Jun 27, 2017
 *
 */

package numofislandsii;

import java.util.*;

public class NumberOfIslandsII {
	
	private int[] dx = {0, 1, 0, -1};
	private int[] dy = {1, 0, -1, 0};
	
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		UnionFind uf = new UnionFind(m, n);
		List<Integer> res = new ArrayList<Integer> ();		
		
		for(int[] position: positions) {
			int landX = position[0], landY = position[1];			
			int landId = uf.addLand(landX, landY);
			for(int i = 0; i < 4; i++) {
				 int nearId = uf.getID(landX + dx[i], landY + dy[i]);
				 if(nearId > 0 && !uf.connected(landId, nearId)) {
					 uf.union(nearId, landId);
				 }
			}
			res.add(uf.getCount());
		}
		
		return res;
    }
}
