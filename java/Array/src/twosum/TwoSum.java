/**
 * 
 * @LeetCode 1 Two Sum
 * @Description: Given an array of integers, return indices of the two numbers 
 * such that they add up to a specific target.
 * 
 * Note: You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice. 
 * 
 * @Difficulty: Easy
 * @Category: Array
 * @Author: Yi Chen
 * @CreatedTime: Apr 17, 2017
 * @LastEditTime: Apr 17, 2017
 *
 */


package twosum;
import java.util.*;


public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 7, 11, 15, 8};
		int[] res = twoSum(arr, 10);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = new int[2]; 
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				res[0] = map.get(nums[i]);
				res[1] = i;
				
				return res;
			}
			else {
			
				map.put(target - nums[i], i);
			}
		}
		
		return res;
    }
}
