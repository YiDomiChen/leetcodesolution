/**
 * 
 * @LeetCode  228. Summary Ranges
 * @Description: Given a sorted integer array without duplicates, 
 * return the summary of its ranges.
 * 
 * Example 1:
 * Input: [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * 
 * @Difficulty: Medium
 * @Category: Array
 * @Author: Yi Chen
 * @CreatedTime: Mar 12, 2018
 * @LastEditTime: Mar 12, 2018
 *
 */
package sumrang;

import java.util.*;

public class SummaryRanges {
	
	public List<String> summaryRanges(int[] nums) {
		LinkedList<String> res = new LinkedList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		if (nums.length == 1) {
			res.add(nums[0] + "");
			return res;
		}
		
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
				i++;
			}
			
			if (a == nums[i]) {
				res.add(nums[i] + "");
			} else {
				res.add(a + "->" + nums[i]);
			}
		}
		
		return res;
    }
	
	public List<String> summaryRanges2(int[] nums) {
		LinkedList<String> res = new LinkedList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		if (nums.length == 1) {
			res.add(nums[0] + "");
			return res;
		}
		
		int l = 0, r = 0;
		while (r < nums.length) {
			while (r + 1 < nums.length && nums[r + 1] - nums[r] == 1) {
				r++;
			}
			if (l == r) {
				res.add(nums[l] + "");
			} else {
				res.add(nums[l] + "->" + nums[r]);
			}
			r++;
			l = r;
		}
						
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SummaryRanges sr = new SummaryRanges();
		int[] nums = {0,2,3,4,6,8,9};
		List<String> res = sr.summaryRanges2(nums);
		for (String s : res) {
			System.out.println(s);
		}
	}

}
