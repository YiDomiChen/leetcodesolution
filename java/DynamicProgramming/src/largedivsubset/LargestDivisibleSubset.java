/**
 * 
 * @LeetCode  368. Largest Divisible Subset
 * @Description:  Given a set of distinct positive integers, 
 *   find the largest subset such that every pair (Si, Sj) of elements in this subset 
 *   satisfies: Si % Sj = 0 or Sj % Si = 0.
 *  
 *   If there are multiple solutions, return any subset is fine. 
 * @Difficulty: Medium
 * @Category: Dynamic Programming 
 * @Author: Yi Chen
 * @CreatedTime: Mar 7, 2018
 * @LastEditTime: Mar 7, 2018
 *
 */
package largedivsubset;

import java.util.*;

public class LargestDivisibleSubset {
	
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		// 0. sort the array
		Arrays.sort(nums);	// O(nlogn)
		
		// 1. get the size of largest divisible subset in current subarray 
		// O(n^2)
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		// 2. get the index with the maximum number (largest divisible subset size in the array)
		int maxIndex = 0, maxSize = dp[0];
		for (int i = 1; i < nums.length; i++) {
			if (dp[i] > maxSize) {
				maxSize = dp[i];
				maxIndex = i;
			}
		}
		
		// 3. trace back the array and get the elements of the largest divisible subset
		int curElement = nums[maxIndex];
		int curSize = maxSize;
		
		for (int i = maxIndex; i >= 0; i--) {
			if (curElement % nums[i] == 0 && curSize == dp[i]) {
				res.add(nums[i]);
				curElement = nums[i];
				curSize--;
			}
		}
		
		// overall time complexity: O(n^2)
		return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 3, 8, 9, 27};
		LargestDivisibleSubset lds = new LargestDivisibleSubset();
		List<Integer> res = lds.largestDivisibleSubset(nums);
		for (int r : res) {
			System.out.println(r);
		}
		
	}

}
