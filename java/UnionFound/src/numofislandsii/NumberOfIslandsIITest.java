/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Jun 27, 2017
 * @LastEditTime Jun 27, 2017
 *
 */

package numofislandsii;

import java.util.List;

import org.junit.Test;

public class NumberOfIslandsIITest {
	
	@Test
	public void test() {
		NumberOfIslandsII n = new NumberOfIslandsII();
		int[][] positions = {{0, 1}, {0, 0}};
		List<Integer> res = n.numIslands2(1, 2, positions);
		for(int num : res) {
			System.out.println(num);
		}
	}
}
