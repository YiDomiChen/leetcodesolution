

package gvalidtree;

import org.junit.Test;

public class GraphValidTreeTest {
	@Test
	public void test() {
		GraphValidTree g = new GraphValidTree();
//		int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		
		
		System.out.println(g.validTree(5, edges));
		
	}
	
}
