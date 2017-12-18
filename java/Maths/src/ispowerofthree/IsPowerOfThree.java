/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Jun 1, 2017
 * @LastEditTime Jun 1, 2017
 *
 */

package ispowerofthree;

import java.lang.*;

public class IsPowerOfThree {
	
	public boolean isPowerOfThree(int n) {
		double x = Math.pow(3, Math.log(n) / Math.log(3));
		return x == n;

    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IsPowerOfThree powerOfThree = new IsPowerOfThree();
		
		System.out.println(powerOfThree.isPowerOfThree(7));

	}

}
