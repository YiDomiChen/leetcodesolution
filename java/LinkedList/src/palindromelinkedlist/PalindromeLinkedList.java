/**
 * 
 * @LeetCode 234 Palindrome Linked List
 * @Description: Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 * @Difficulty: Easy 
 * @Category: Linked List
 * @Author: Yi Chen
 * @CreatedTime: Feb 28, 2017
 * @LastEditTime: Feb 28, 2017
 *
 */

package palindromelinkedlist;

import utils.*;

public class PalindromeLinkedList {
	
	public boolean isPalindrome(ListNode head) {
		ListNode runner = head, walker = head;
		while(runner.next != null && runner.next.next != null) {
			walker = walker.next;
			runner = runner.next.next;
		}
		
//		if(runner != null) {	//Odd nodes
			walker = walker.next;
//		}
		walker = reverse(walker);
		runner = head;
		
		while(walker != null) {
			if(walker.val != runner.val) {
				return false;
			}
			
			walker = walker.next;
			runner = runner.next;
		}
		
		return true;
    }
	
	public ListNode reverse(ListNode head) {
		ListNode newhead = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = newhead;
			newhead = head;
			head = next;
		}
		
		return newhead;
	}
}
