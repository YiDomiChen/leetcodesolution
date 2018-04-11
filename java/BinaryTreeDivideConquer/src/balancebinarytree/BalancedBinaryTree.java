package balancebinarytree;

import util.*;

public class BalancedBinaryTree {
	
	public class ResultType {
		public int depth;
		public boolean balanced;
		public ResultType(int depth, boolean balanced) {
			this.depth = depth;
			this.balanced = balanced;
		}
	}
	
	public boolean isBalanced(TreeNode root) {
		ResultType resultType = helper(root);
		return resultType.balanced;
    }
	
	public ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0 , true);
		}
		
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		if (!left.balanced || !right.balanced) {
			return new ResultType(-1, false);
		}
		if (Math.abs(left.depth - right.depth) > 1) {
			return new ResultType(-1, false);
		}	
		int curDepth = Math.max(left.depth, right.depth) + 1;
		
		return new ResultType(curDepth, true);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
