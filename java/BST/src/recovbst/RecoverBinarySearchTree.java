/**  
 * Copyright © 2018Yi Chen. All rights reserved.
 *
 * @Title: RecoverBinarySearchTree.java
 * @Description: TODO
 * @author: Yi Chen  
 * @date: Apr 9, 2018
 * @difficulty: 
 * @EditDate: Apr 9, 2018
 * @version: V1.0  
 */
package recovbst;
import util.*;

public class RecoverBinarySearchTree {
	
	private TreeNode firstNode = null;
	private TreeNode secondNode = null;
	
	private TreeNode previousNode = new TreeNode(Integer.MIN_VALUE);
	
	public void recoverTree(TreeNode root) {
        traverse(root);
        
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
        
    }
	
	public void traverse(TreeNode root) {
		if (root == null) {
        	return;
        }
		
		traverse(root.left);
		if (firstNode == null && root.val < previousNode.val) {
			firstNode = previousNode;
		}
		if (secondNode == null && previousNode.val >= root.val) {
			secondNode = root;
		}
		previousNode = root;
		
		traverse(root.right);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
