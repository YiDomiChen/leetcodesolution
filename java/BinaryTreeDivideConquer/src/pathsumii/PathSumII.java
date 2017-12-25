/**
 * 
 * @LeetCode 113. Path Sum II
 * @Description: Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

  * return

[
   [5,4,11,2],
   [5,8,4,5]
]

 *  
 * @Difficulty: Medium
 * @Category: Binary Tree
 * @Author: Yi Chen
 * @CreatedTime: Dec 21, 2017
 * @LastEditTime: Dec 21, 2017
 *
 */
package pathsumii;

import java.util.*;
import util.*;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<Integer> ();
        path.add(root.val);
        
        helper(res, path, root, root.val, sum);
        
        return res;
    }
    
    
    public void helper(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum, int target) {
        if (root.left == null && root.right == null) {   // current node is a leaf
            if (sum == target) {
                res.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        if (root.left != null) {
            path.add(root.left.val);
            helper(res, path, root.left, sum + root.left.val, target);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            helper(res, path, root.right, sum + root.right.val, target);
            path.remove(path.size() - 1);
        }
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
