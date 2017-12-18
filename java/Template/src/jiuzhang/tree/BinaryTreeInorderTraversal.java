package jiuzhang.tree;

import java.util.*;


public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversalIteration(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		TreeNode curt = root;
		
		while(curt != null || !stack.isEmpty()) {
			while(curt != null) {
				stack.add(curt);
				curt = curt.left;
			}
			
			curt = stack.pop();
			result.add(curt.val);
			curt = curt.right;
		}
		
		return result;
	}
}
