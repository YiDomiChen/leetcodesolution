/**
 * 
 * @LeetCode
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Dec 24, 2017
 * @LastEditTime: Dec 24, 2017
 *
 */
package jiuzhang.bfs;

import java.util.*;

public class DirectedGraphNode {
	 // Definition for Directed graph.
	 int label;
	 ArrayList<DirectedGraphNode> neighbors;
	 public DirectedGraphNode(int x) { 
		 label = x; neighbors = new ArrayList<DirectedGraphNode>();
	 }
}
