/**
 * 
 * @LeetCode 209. Minimum Size Subarray Sum
 * @Description: for details, see: https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * @Difficulty: Medium
 * @Category: Two Pointers
 * @Author: Yi Chen
 * @CreatedTime: Jan 8, 2018
 * @LastEditTime: Jan 8, 2018
 *
 */
package minsubarrsum;

public class MinSizeSubarraySum {
	
	public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                ans = Math.min(j - i, ans);
            }
            sum -= nums[i];
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
