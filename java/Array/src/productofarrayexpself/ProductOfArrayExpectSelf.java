/**
 * 
 * @LeetCode 238. Product of Array Except Self
 * @Description: Given an array of n integers where n > 1, nums, return an array output such that output[i] 
 * is equal to the product of all the elements of nums except nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * @Difficulty: Medium
 * @Tags: Array
 * @Author: Yi Chen
 * @CreatedTime: May 9, 2017
 * @LastEditTime: May 9, 2017
 *
 */
package productofarrayexpself;

public class ProductOfArrayExpectSelf {
	
	
	
	public int[] productExceptSelf(int[] nums) {
		
		int cumProductLeft = 1;
		int[] results = new int[nums.length];
		results[0] = 1;
		for(int i = 1; i < nums.length; i++) {	//iterate from the lower bound to calculate the product on the left hand side
			cumProductLeft *= nums[i - 1];
			results[i] = cumProductLeft;
		}
		
		int cumProductRight = 1;
		for(int i = nums.length - 1; i >= 0; i--) {	//iterate from the right bound to calculate the product on the right hand side
			results[i] *= cumProductRight;	// merge the product
			cumProductRight *= nums[i];
		}
		
		return results;
    }
}
