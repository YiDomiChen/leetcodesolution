package trimbst;

import util.*;

public class TrimBST {
	
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) {
			return null;
		}
		return helper(root, L, R);
    }
	
	public TreeNode helper(TreeNode root, int L, int R) {
		if (root == null) {
			return null;
		}
		
		if (root.val < L) {
			return helper(root.right, L, R);
		}
		if (root.val > R) {
			return helper(root.left, L, R);
		}
		
		root.left = helper(root.left, L, R);
		root.right = helper(root.right, L, R);
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
