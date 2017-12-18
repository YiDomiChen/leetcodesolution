/**
 * 
 * @LeetCode
 * @Description  Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.
 * For example:
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false. 
 * @Difficulty Medium 
 * @Tags Union-Found
 * @Author Yi Chen
 * @CreatedTime Jun 28, 2017
 * @LastEditTime Jun 28, 2017
 *
 */

package gvalidtree;

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		
		UnionFind uf = new UnionFind(n);
		for(int[] edge : edges) {
			if(uf.connected(edge[0], edge[1])) {
				return false;
			}
			else {
				uf.union(edge[0], edge[1]);
			}
		}
		
		if(uf.getCount() == 1) {
			return true;
		}
		else {
			return false;
		}
    }
}
