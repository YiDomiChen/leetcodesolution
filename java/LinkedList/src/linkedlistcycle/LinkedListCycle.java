/**
 * 
 * @LeetCode 141 Linked List Cycle
 * @Description: Given a linked list, determine if it has a cycle in it. 
 * 
 * Follow Up: Can you solve it without using extra space?
 * 
 * @Difficulty: Easy
 * @Category: Linked List
 * @Author: Yi Chen
 * @CreatedTime: Feb 28, 2017
 * @LastEditTime: Feb 28, 2017
 *
 */

package linkedlistcycle;

import utils.*;
public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow) {
				return true;	//If there is a ring, two pointers will meet at last.
			}
		}
		
		return false;
    }
}
