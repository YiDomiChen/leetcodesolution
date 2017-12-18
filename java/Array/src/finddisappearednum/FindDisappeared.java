/**
 * 
 * @LeetCode 448. Find All Numbers Disappeared in an Array 
 * @Description: Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
 * some elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? 
 * You may assume the returned list does not count as extra space.
 * 
 * @Difficulty: Easy
 * @Category: Array
 * @Author: Yi Chen
 * @CreatedTime: Feb 23, 2017
 * @LastEditTime: Feb 23, 2017
 *
 */

package finddisappearednum;

import java.util.*;

public class FindDisappeared {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		
		for(int i = 0; i < nums.length; i++) {
			//set the element negative whose index equals to the existing number 
			nums[Math.abs(nums[i]) - 1] = Math.abs(nums[Math.abs(nums[i]) - 1]) * -1;	
		}
		List<Integer> disappearList = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++) {
			//if the element is positive, the number that equals to the index is missing in original array
			if(nums[i] > 0) disappearList.add(i + 1);
		}
		
		return disappearList;
//		int[] res = new int[disappearList.size()];
//		for(int i = 0; i < res.length; i++) {
//			res[i] = disappearList.get(i);
//		}
//		
//		return res;
		
    }
	
}
