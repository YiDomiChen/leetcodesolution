/**
 * 
 * @LeetCode 16. 3 Sum Closest
 * @Description Given an array S of n integers, find three integers in S such that the sum is 
 * closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * @Difficulty Medium
 * @Tags Arrays
 * @Author Yi Chen
 * @CreatedTime Jul 3, 2017
 * @LastEditTime Jul 3, 2017
 *
 */

package threesumclosest;

import java.util.*;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		
		if(nums.length < 3) return -1;
		int left, mid, right;
		
		Arrays.sort(nums);		
		int minDiff = Integer.MAX_VALUE; 
		int minSum = nums[0] + nums[1] + nums[2];
		
		for(left = 0; left < nums.length - 2; left++) {
			mid = left + 1;
			right = nums.length - 1;
			while(mid < right) {
				int sum = nums[left] + nums[mid] + nums[right];
				if(Math.abs(sum - target) < minDiff) {
					minDiff = Math.abs(sum - target);
					minSum = sum;
				}
				
				if(minDiff == 0) return target;
				if(sum < target) {
					mid++;
				}
				else {
					right--;
				}
			}
		}
		
		return minSum;
		
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,0,0};
		int target = 1;
		
		ThreeSumClosest t = new ThreeSumClosest();
		System.out.println(t.threeSumClosest(arr, target));
	}
}
