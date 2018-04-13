package buildbintreeprein;

import util.*;

public class ConstructBinaryTreeFromPreorderInorder {
		
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }
	
	public TreeNode helper(int[] preorder, int startPre, int[] inorder, int startIn, int endIn) {
		if (startPre > preorder.length - 1 || startIn > endIn) {
			return null;
		}
		
		int rootVal = preorder[startPre];
		TreeNode root = new TreeNode(rootVal);
		
		int splitIn = -1;
		for (int i = startIn; i <= endIn; i++) {
			if (inorder[i] == rootVal) {
				splitIn = i;
				break;
			}
		}
		root.left = helper(preorder, startPre + 1, inorder, startIn, splitIn - 1);
		root.right = helper(preorder, startPre + splitIn - startIn + 1, inorder, splitIn + 1, endIn);
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
