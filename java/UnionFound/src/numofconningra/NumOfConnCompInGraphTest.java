package numofconningra;

import org.junit.Test;

public class NumOfConnCompInGraphTest {
	
	@Test
	public void test() {
		NumOfConnCompInGraph n = new NumOfConnCompInGraph();
		int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
		
		System.out.println(n.countComponents(5, edges));
		
		
	}
	
}
