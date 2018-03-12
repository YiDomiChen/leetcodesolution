/**
 * 
 * @LeetCode  530. Minimum Absolute Difference in BST
 * @Description: Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * @Difficulty: Easy
 * @Category: Binary Tree, BST
 * @Author: Yi Chen
 * @CreatedTime: Mar 11, 2018
 * @LastEditTime: Mar 11, 2018
 *
 */
package mindiffbst;

import java.util.*;

import util.*;

public class MinAbsDiffBST {
	public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        List<Integer> inorder = helper(root);
        
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < inorder.size(); i++) {
            res = Math.min(res, Math.abs(inorder.get(i) - inorder.get(i - 1)));
        }
        
        return res;
    }
    
    public List<Integer> helper(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        List<Integer> left = helper(root.left);
        List<Integer> right = helper(root.right);
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        
        return res;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
