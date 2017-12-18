/**
 * 
 * @LeetCode 142 Linked List Cycle II
 * @Description: Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null. 
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up:
 * Can you solve it without using extra space? 
 * 
 * @Difficulty: Medium
 * @Category: Linked List
 * @Author: Yi Chen
 * @CreatedTime: Feb 28, 2017
 * @LastEditTime: Feb 28, 2017
 *
 */

package linkedlistcycleii;

import utils.*;;
public class LinkedListCycleII {

	public ListNode detectCycle(ListNode head) {
		ListNode runner = head;
		ListNode walker = head;
		
		while(runner.next != null && runner.next.next != null) {
			if(runner == walker) {
				walker = head;
				while(walker != runner) {
					walker = walker.next;
					runner = runner.next;
				}
				
				return walker;
			}
			
			runner = runner.next.next;
			walker = walker.next;
		}
		
		return null;
    }
	
}
