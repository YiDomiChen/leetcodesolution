/**
 * 
 * @LeetCode 94. Binary Tree Inorder Traversal
 * @Description: Given a binary tree, return the inorder traversal of its nodes' values.
 *	For example:
 *	Given binary tree [1,null,2,3],
	
 *	   1
 *	    \
 *	     2
 *	    /
 *	   3
 	
 *	return [1,3,2].
 * @Difficulty: Medium
 * @Category: Tree
 * @Author: Yi Chen
 * @CreatedTime: Dec 19, 2017
 * @LastEditTime: Dec 19, 2017
 *
 */
package inordertrav;

import java.util.*;
import util.*;

public class InorderTraversal {		
	public List<Integer> inorderTraversal_nonrecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;	//traverse until the currently left most leaf
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
