package maxbintree;

import util.*;
import serializebtree.*;

public class MaximumBinaryTree {
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return helper(nums, 0, nums.length - 1);
    }
	
	public TreeNode helper(int[] nums, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return null;
		}
		if (startIndex == endIndex) {
			return new TreeNode(nums[startIndex]);
		}
		
		
		int maxIndex = startIndex;
		int max = nums[startIndex];
		for (int i = startIndex; i <= endIndex; i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}
		
		TreeNode root = new TreeNode(max);
		TreeNode leftTree = helper(nums, startIndex, maxIndex - 1);
		TreeNode rightTree = helper(nums, maxIndex + 1, endIndex);
		root.left = leftTree;
		root.right = rightTree;
		
		return root;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
