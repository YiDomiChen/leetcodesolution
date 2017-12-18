package threesum;
/**
 * 
 * @LeetCode 15 3Sum
 * @Description Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * @Difficulty Medium
 * @Tags Array, Two Pointers
 * @Author Yi Chen
 * @CreatedTime May 20, 2017
 * @LastEditTime May 20, 2017
 *
 */

import java.util.*;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		if(nums.length < 3) return null;
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		int left, mid, right;
		for(left = 0; left < nums.length && nums[left] <= 0; left++) {
			mid = left + 1;
			right = nums.length - 1;
			if(left > 0 && nums[left] == nums[left - 1]) continue;	//	skip duplicate left elements
			int tmp = 0 - nums[left];
			while(mid < right) {
				if(nums[mid] + nums[right] == tmp) {
					int tmp_mid = nums[mid], tmp_right = nums[right];
					List<Integer> triplet = new ArrayList<Integer>();
					triplet.add(nums[left]);
					triplet.add(nums[mid]);
					triplet.add(nums[right]);
					res.add(triplet);
					
					while(mid < right && nums[mid] == tmp_mid) mid++;	//	skip duplicate mid elements
					while(mid < right && nums[right] == tmp_right) right--;	//skip duplicate right elements
				}
				else if(nums[mid] + nums[right] > tmp) {
					right--;
				}
				else {
					mid++;
				}
			}
		}
		
		return res;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2, -2, -2, -1, -1, 0, 1, 1, 2, 2};
		ThreeSum t = new ThreeSum();
		List<List<Integer>> res = t.threeSum(arr);
		for(List<Integer> triplet : res) {
			System.out.print(String.valueOf(triplet.get(0)) + " " + String.valueOf(triplet.get(1)) + " " + String.valueOf(triplet.get(2)));
			System.out.println();
		}
		
	}

}
