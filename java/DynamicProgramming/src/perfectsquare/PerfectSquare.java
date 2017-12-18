

package perfectsquare;

/**
 * 
 * @LeetCode 279. Perfect Squares
 * @Description  Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9. 
 * @Difficulty Medium
 * @Tags Dynamic Programming, Breath-first Search, Math
 * @Author Yi Chen
 * @CreatedTime May 30, 2017
 * @LastEditTime May 30, 2017
 *
 */
public class PerfectSquare {
	
	
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for(int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i <= n; i++) {
			for(int j = 1; i + j * j <= n; j++) {
				dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
			}
		}
		
		return dp[n];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectSquare p = new PerfectSquare();
		int result = p.numSquares(12);
		System.out.println(result);
	}

}
