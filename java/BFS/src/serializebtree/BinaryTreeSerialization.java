/**
 * 
 * @LeetCode
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Dec 22, 2017
 * @LastEditTime: Dec 22, 2017
 *
 */
package serializebtree;

import java.util.*;
import util.*;

public class BinaryTreeSerialization {

	/**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "{}";
        }
        
        StringBuilder sb = new StringBuilder("{");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("#,");
                    continue;
                } else {
                    sb.append(node.val + ",");
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        for (int i = sb.length() - 1; i >= 0; i--) {
        	if (sb.charAt(i) == '#' || sb.charAt(i) == ',') {
        		sb.deleteCharAt(i);
        	} else {
        		break;
        	}
        }
        
        return sb.append("}").toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == "{}") {
            return null;
        }
        
        String[] arr = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < arr.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                if (index >= arr.length) break;
                if (!arr[index].equals("#")) {
                	TreeNode child = new TreeNode(Integer.parseInt(arr[index]));
                    queue.offer(child);
                    node.left = child;
                }
                index++;
                if (index >= arr.length) break;
                if (!arr[index].equals("#")) {
                	TreeNode child = new TreeNode(Integer.parseInt(arr[index]));
                    queue.offer(child);
                    node.right = child;
                }
                index++;
            }
        }
        
        return root;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		root.left = node1;
		TreeNode node2 = new TreeNode(20);
		root.right = node2;
		TreeNode node3 = new TreeNode(15);
		node2.left = node3;
		TreeNode node4 = new TreeNode(7);
		node2.right = node4;
		
		BinaryTreeSerialization b = new BinaryTreeSerialization();
		System.out.println(b.serialize(root));
		TreeNode after = b.deserialize(b.serialize(root));
		System.out.println(after.val);
	}

}
