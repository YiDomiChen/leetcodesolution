/**
 * 
 * @LeetCode  5. Longest Palindromic Substring
 * @Description: Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
 * 
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 * 
 * @Difficulty: Medium 
 * @Category: Dynamic Programming
 * @Author: Yi Chen
 * @CreatedTime: Mar 13, 2018
 * @LastEditTime: Mar 13, 2018
 *
 */
package longpalinsubstr;

public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
		int[][] dp = new int[s.length()][s.length()];
		int l = 0, r = 0, maxLen = 0;
		for (int i = 0; i < dp.length - 1; i++) {
			for (int j = 0; j < i; j++) {
				if (j == i) {
					dp[j][i] = 1;
				}
				if (s.charAt(j) == s.charAt(i) && j == i - 1) {
					dp[j][i] = 1;
				}
				if (i - j >= 2 && s.charAt(j) == s.charAt(i) && dp[j + 1][i - 1] == 1) {
					dp[j][i] = 1;
				}
				
				if (maxLen < i - j + 1) {
					maxLen = i - j + 1;
					l = j;
					r = i;
				}
			}
			dp[i][i] = 1;
		}
		
		return s.substring(l, r);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("babad"));
	}

}
