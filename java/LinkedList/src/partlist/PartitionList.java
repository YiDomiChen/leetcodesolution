/**
 * 
 * @LeetCode 86. Partition List
 * @Description: Given a linked list and a value x, partition it such that all nodes 
 * less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5. 
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Dec 30, 2017
 * @LastEditTime: Dec 30, 2017
 *
 */
package partlist;

import utils.*;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            
            head = head.next;
        }
        
        right.next = null;	// avoid circle
        left.next = rightDummy.next;
        
        return leftDummy.next;
    }
}
