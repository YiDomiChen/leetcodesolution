/**  
 * Copyright © 2018Yi Chen. All rights reserved.
 *
 * @Title: 114. Flatten Binary Tree to Linked List
 * @Description: TODO
 * @author: Yi Chen  
 * @date: Apr 11, 2018
 * @difficulty: 
 * @EditDate: Apr 11, 2018
 * @version: V1.0  
 */
package flatbintree;

import util.*;

public class FlatternBinaryTree {
	
	public void flatten(TreeNode root) {
        helper(root);
    }
	
	public TreeNode helper(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode leftLast = helper(root.left);
		TreeNode rightLast = helper(root.right);
		if (leftLast != null) {
			leftLast.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		if (rightLast != null) {
			return rightLast;
		}
		if (leftLast != null) {
			return leftLast;
		}
		
		return root;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
