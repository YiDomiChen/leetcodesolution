package bstiter;

import java.util.Stack;

import util.*;

public class BSTIterator {
	
	private Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        stack = new Stack<>();
        while (cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode cur = stack.pop();
    	int res = cur.val;
    	if (cur.right != null) {
    		cur = cur.right;
    		while (cur != null) {
    			stack.push(cur);
    			cur = cur.left;
    		}
    	}
    	
    	return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
