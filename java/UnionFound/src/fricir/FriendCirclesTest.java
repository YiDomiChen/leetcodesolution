package fricir;

import org.junit.Test;

public class FriendCirclesTest {

	@Test
	public void test() {
		int[][] m = {{1,1,0},
				{1,1,1},
				{0,1,1}};
		FriendCircles f = new FriendCircles();
		System.out.println(f.findCircleNum(m));
		
	}

}
