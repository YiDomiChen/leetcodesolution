/**
 * 
 * @LeetCode
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Jan 19, 2018
 * @LastEditTime: Jan 19, 2018
 *
 */
package convarr2bst;

import util.*;

public class ConvertArrayToBST {
	
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		
		return helper(nums, 0, nums.length - 1);
    }
	
	public TreeNode helper(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		
		TreeNode node = new util.TreeNode(nums[(start + end) / 2]);
		node.left = helper(nums, start, (start + end) / 2 - 1);
		node.right = helper(nums, (start + end) / 2 + 1, end);
		
		return node;
	} 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
