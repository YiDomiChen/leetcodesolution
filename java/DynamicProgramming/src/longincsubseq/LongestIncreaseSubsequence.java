/**
 * 
 * @LeetCode  300. Longest Increasing Subsequence
 * @Description:  Given an unsorted array of integers, find the length of longest increasing subsequence.

 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 * Your algorithm should run in O(n2) complexity. 
 * @Difficulty: Medium
 * @Category: Dynamic Programming
 * @Author: Yi Chen
 * @CreatedTime: Mar 9, 2018
 * @LastEditTime: Mar 9, 2018
 *
 */
package longincsubseq;

public class LongestIncreaseSubsequence {
	
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) { return 0; }
		int res = 1;
		// the longest number that ends with element of index i;
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				 if (nums[j] < nums[i]) {
					 dp[i] = Math.max(dp[i], dp[j] + 1);
				 }
			}
			res = Math.max(dp[i], res);
		}
		
		return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		LongestIncreaseSubsequence lis = new LongestIncreaseSubsequence();
		System.out.println(lis.lengthOfLIS(arr));
	}

}
