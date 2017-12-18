/**
 * 
 * @LeetCode
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: May 9, 2017
 * @LastEditTime: May 9, 2017
 *
 */
package productofarrayexpself;

import org.junit.*;

public class TestCase {
	
	@Test
	public void test() {
		ProductOfArrayExpectSelf algorithm = new ProductOfArrayExpectSelf();
		
		int[] result = algorithm.productExceptSelf(new int[] {1,2,3,4});
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
}
