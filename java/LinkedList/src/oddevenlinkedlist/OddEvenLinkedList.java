/**
 * 
 * @LeetCode
 * @Description: Given a singly linked list, group all odd nodes together followed by the 
 * even nodes. Please note here we are talking about the node number and not the value in the 
 * nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and 
 * O(nodes) time complexity.
 * 
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 *  
 * @Difficulty: Medium
 * @Category: Linked List
 * @Author: Yi Chen
 * @CreatedTime: Feb 28, 2017
 * @LastEditTime: Feb 28, 2017
 *
 */

package oddevenlinkedlist;

import utils.*;

public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode oddNode = head;
		ListNode evenNode = head.next;
		ListNode firstEvenNode = head.next;
		while(oddNode.next != null && evenNode.next != null) {
			oddNode.next = oddNode.next.next;
			evenNode.next = evenNode.next.next;
			oddNode = oddNode.next;
			evenNode = evenNode.next;
		}
		oddNode.next = firstEvenNode;
		
		return head;
        
    }
	
}
