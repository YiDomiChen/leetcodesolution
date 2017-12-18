
package jiuzhang.tree;

import java.util.*;

public class BinaryTreePreorderTraversal {
	
	/***
	 * Implement preorder traversal with non-recursion (iteration) method
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversalIteration(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>(); 
		List<Integer> preorder = new ArrayList<Integer>();
		if(root == null) {
			return preorder;
		}
		
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			preorder.add(node.val);
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		
		return preorder;
	}
	
	/***
	 * Implement preorder traversal with traverse method
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversalTraverse(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		traverse(root, result);
		
		return result;
	}
	
	private void traverse(TreeNode root, ArrayList<Integer> result) {
		if(root == null) {
			
			return;
		}
		
		result.add(root.val);
		traverse(root.left, result);
		traverse(root.right, result);
	}
	
	
	/***
	 * Implement preorder traversal with divide and conquer method
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderDivideAndConquer(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(root == null) {
			
			return result;
		}
		
		// Divide
		List<Integer> left = preorderDivideAndConquer(root.left);
		List<Integer> right = preorderDivideAndConquer(root.right);
		
		//Conquer
		result.add(root.val);
		result.addAll(left);
		result.addAll(right);
		
		return result;
	}
}
