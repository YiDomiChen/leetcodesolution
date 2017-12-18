/**
 * 
 * @LeetCode 206 Reversed Linked List
 * @Description: Reverse a singly linked list.
 * @Difficulty: Easy
 * @Category: Linked List
 * @Author: Yi Chen
 * @CreatedTime: Feb 28, 2017
 * @LastEditTime: Feb 28, 2017
 *
 */

package reversedlinkedlist;
import utils.*;

public class ReversedLinkedList {
	//Implemented by iteration
	public ListNode reverseList(ListNode head) {
		ListNode newhead = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = newhead;
			newhead = head;
			head = next;
		}
		
		return newhead;
    }
	
	public ListNode reverseList2(ListNode head) {
		
		return reverseList2(head, null);
    }
	
	//Implemented by recursion
	public ListNode reverseList2(ListNode head, ListNode newhead) {
		if(head == null) return newhead;
		
		ListNode next = head.next;
		head.next = newhead;
		return reverseList2(next, head);
    }
}
