/**
 * 
 * @LeetCode 70. Climbing Stairs 
 * @Description You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
 * @Difficulty Easy
 * @Tags Dynamic Programming
 * @Author Yi Chen
 * @CreatedTime Jun 2, 2017
 * @LastEditTime Jun 2, 2017
 *
 */

package climbstairs;

public class ClimbingStairs {

	public int climbStairs(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		
		return dp[n];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs c = new ClimbingStairs();
		System.out.println(c.climbStairs(10));
	}

}
