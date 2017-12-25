/**
 * 
 * @LeetCode
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Dec 18, 2017
 * @LastEditTime: Dec 18, 2017
 *
 */
package preordertrav;

import util.*;
import java.util.*;

public class PreorderTraversal {	
	public List<Integer> preorderTraversal_traverse(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        
        return res;
        
    }
	
	public List<Integer> preorderTraversal_nonrecursion(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		
		return res;
	}
	
	private List<Integer> divideAndConquer(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		
		List<Integer> left = divideAndConquer(root.left);
		List<Integer> right = divideAndConquer(root.right);
		res.add(root.val);
		res.addAll(left);
		res.addAll(right);
		
		return res;
	}
	
    private void traverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left, res);
        traverse(root.right, res);
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
