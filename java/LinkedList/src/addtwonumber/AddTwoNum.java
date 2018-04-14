/**
 * 
 * @LeetCode 2 Add Two Numbers
 * @Description: You are given two non-empty linked lists representing two non-negative 
 * integers. The digits are stored in reverse order and each of their nodes contain a single 
 * digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * @Difficulty: Medium
 * @Category: Linked List
 * @Author: Yi Chen
 * @CreatedTime: Feb 28, 2017
 * @LastEditTime: May 20, 2017
 *
 */

package addtwonumber;

import utils.*;

public class AddTwoNum {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		
		ListNode prev = new ListNode(-1);
		ListNode head = prev;
		while (l1 != null || l2 != null || carry != 0) {
			int a = l1 == null ? 0 : l1.val;
			int b = l2 == null ? 0 : l2.val;
			int sum = (a + b + carry) / 10;
			carry = (a + b + carry) % 10;
			ListNode cur = new ListNode(sum);
			prev.next = cur;
			
			l1 = l1 == null? null : l1.next;
			l2 = l2 == null? null : l2.next;
		}
		
		return head.next;
    }
	
	public static void main(String[] args) {
		
	}
}
