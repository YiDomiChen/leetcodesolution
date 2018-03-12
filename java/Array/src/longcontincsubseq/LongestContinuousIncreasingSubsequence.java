/**
 * 
 * @LeetCode  674. Longest Continuous Increasing Subsequence
 * @Description: Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray). 
 * @Difficulty: Easy
 * @Category: Array 
 * @Author: Yi Chen
 * @CreatedTime: Mar 9, 2018
 * @LastEditTime: Mar 9, 2018
 *
 */
package longcontincsubseq;

public class LongestContinuousIncreasingSubsequence {
	
	public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0) return res;
        res = 1;
        
        int curLen = 1;
        int curNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > curNum) {
                curLen++;                
            } else {
            	res = Math.max(res, curLen);
                curLen = 1;
            }
            curNum = nums[i];
        }
        
        res = Math.max(res, curLen);
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,5,7};
		LongestContinuousIncreasingSubsequence lcis = new LongestContinuousIncreasingSubsequence();
		System.out.println(lcis.findLengthOfLCIS(arr));
	}

}
