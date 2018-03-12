/**
 * 
 * @LeetCode 25. Reverse Nodes in k-Group
 * @Description:  Given a linked list, reverse the nodes of a linked list k 
 * at a time and return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list. 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5

 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5 
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Dec 31, 2017
 * @LastEditTime: Dec 31, 2017
 *
 */
package revenodeskgroup;

import utils.*;

public class ReverseNodesInKGroup {
	
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        
        while (true) {
            head = reverseKNodes(head, k);
            if (head == null) {
                break; 
            }
        }
        
        return dummy.next;
    }
    
    public ListNode reverseKNodes(ListNode head, int k) {
        ListNode nodeK = head;
        for (int i = 0; i < k; i++) {
            if (nodeK == null) {
                return null;
            }
            
            nodeK = nodeK.next;
        }
        if (nodeK == null) {
            return null;
        }
        
        ListNode nodeKPlus = nodeK.next;
        ListNode n1 = head.next;
        
        ListNode prev = null;
        ListNode cur = n1;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        head.next = nodeK;
        n1.next = nodeKPlus;
        
        return n1;
        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
