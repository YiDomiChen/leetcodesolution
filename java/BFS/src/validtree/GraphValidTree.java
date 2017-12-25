/**
 * 
 * @LeetCode 261. Graph Valid Tree
 * @Description: Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
 * (each edge is a pair of nodes), write a function to check whether these edges make up a 
 * valid tree. 
 * @Difficulty: Medium
 * @Category: BFS
 * @Author: Yi Chen
 * @CreatedTime: Dec 23, 2017
 * @LastEditTime: Dec 23, 2017
 *
 */
package validtree;

import java.util.*;

public class GraphValidTree {
	
	public boolean validTree(int n, int[][] edges) {
		if (edges == null || edges.length == 0) {
			return true;
		}
		
		if (edges.length != n - 1) {
			return false;
		}
		
		HashMap<Integer, Set<Integer>> hash = getAdjacencyMatrix(edges);
		
		Queue<Integer> q = new LinkedList<>(); 
		Set<Integer> s = new HashSet<>();
		
		q.offer(0);
		s.add(0);
		
		while (!q.isEmpty()) {
			Integer u = q.poll();
			for (Integer neighborNode : hash.get(u)) {
				if (s.contains(neighborNode)) {
					continue;
				}
				q.offer(neighborNode);
				s.add(neighborNode);
			}
		}
		
		return s.size() == n;
    }
	
	public HashMap<Integer, Set<Integer>> getAdjacencyMatrix(int[][] edges) {
		HashMap<Integer, Set<Integer>> hash = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			if (!hash.containsKey(edges[i][0])) {
				hash.put(edges[i][0], new HashSet<Integer>());
			}
		}
		
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			
			hash.get(u).add(v);
			hash.get(v).add(u);
			
		}
		
		return hash;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
