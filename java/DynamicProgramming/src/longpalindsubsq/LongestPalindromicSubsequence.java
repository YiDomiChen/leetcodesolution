package longpalindsubsq;

/**
 * 
 * @LeetCode 516. Longest Palindromic Subsequence 
 * @Description Given a string s, find the longest palindromic subsequence's length in s. 
 * You may assume that the maximum length of s is 1000.
 * @Difficulty Medium 
 * @Tags Dynamic Programming
 * @Author Yi Chen
 * @CreatedTime Jun 2, 2017
 * @LastEditTime Jun 2, 2017
 *
 */
public class LongestPalindromicSubsequence {
	
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		
		int[][] dp = new int[n][n];
		
		for(int i = n - 1; i >= 0; i--) {
			dp[i][i] = 1;
			for(int j = i + 1; j < n; j++) {
				if(s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				}
				else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}
		
		return dp[0][n - 1];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
