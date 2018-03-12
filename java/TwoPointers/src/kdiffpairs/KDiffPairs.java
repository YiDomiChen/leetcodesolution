/**
 * 
 * @LeetCode  532. K-diff Pairs in an Array
 * @Description: Given an array of integers and an integer k, 
 * you need to find the number of unique k-diff pairs in the array. 
 * Here a k-diff pair is defined as an integer pair (i, j), 
 * where i and j are both numbers in the array and their absolute difference is k. 
 * @Difficulty:  Easy
 * @Category: Two Pointers
 * @Author: Yi Chen
 * @CreatedTime: Jan 20, 2018
 * @LastEditTime: Jan 20, 2018
 *
 */
package kdiffpairs;

import java.util.*;

public class KDiffPairs {
	
	public int findPairs(int[] nums, int k) {
		int res = 0;
		if (nums.length < 2) {
			return res;
		}
		
		Arrays.sort(nums);
		int left = 0, right = 1;
		while (right < nums.length) {
			if (left == right) right++;
			if (right < nums.length && nums[right] - nums[left] == k) {
				res += 1;
				right++;
				left++;
				while (right < nums.length && nums[right - 1] == nums[right]) {
					right++;
				}
				while (left < right && left > 0 && nums[left - 1] == nums[left]) {
					left++;
				}
				
			} else if (right < nums.length && nums[right] - nums[left] < k) {
				right++;
			} else {
				left++;
			}
			
		}
		
		return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KDiffPairs k = new KDiffPairs();
		int[] nums = {1, 2, 3, 4, 5};
		System.out.println(k.findPairs(nums, 1));
	}

}
