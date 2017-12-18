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
		ListNode head = null, node = null;
		int carry = 0;
		while(l1 != null || l2 != null || carry != 0) {
			int var1 = l1 == null ? 0 : l1.val;
			int var2 = l2 == null ? 0 : l2.val;
			 
			int sum = (var1 + var2 + carry) % 10;
			carry = (var1 + var2 + carry) / 10;
			if(head == null) {
				head = new ListNode(sum);
				node = head;
			}
			else {
				ListNode next = new ListNode(sum);
				node.next = next;
				node = next;
			}
			
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
			
		}
		
		return head;
    }
	
	public static void main(String[] args) {
		
	}
}
