/**
 * 
 * @LeetCode 21 Merge Two Sorted Lists 
 * @Description: Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by 
 * splicing together the nodes of the first two lists.
 * 
 * @Difficulty: Easy
 * @Category: Linked List
 * @Author: Yi Chen
 * @CreatedTime: Mar 1, 2017
 * @LastEditTime: Mar 1, 2017
 *
 */
package mergetwolists;

import utils.*;

public class MergeTwoLists {

	
	//Solved by recursion
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		ListNode head = null;
		if(l1.val < l2.val) {
			head = l1;
			head.next = mergeTwoLists(l1.next, l2);
		}
		else {
			head = l2;
			head.next = mergeTwoLists(l1, l2.next);
		}
		
		return head;
    }
	
	//Solved by iteration
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				p.next = l1;
				p = l1;
				l1 = l1.next;
			}
			else {
				p.next = l2;
				p = l2;
				l2 = l2.next;
			}
		}
		
		if(l1 != null) {
			p.next = l1;
		}
		if(l2 != null) {
			p.next = l2;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		System.out.println("list l1:");
		for (int i = 0; i < 10; i++) {
//			int temp = ((int) (Math.random() * 100)) % 100;
			l1.insert(i, i);
			System.out.print(i + " ");
		}
		System.out.println();
		LinkedList l2 = new LinkedList();
		System.out.println("list l2:");
		for (int i = 0; i < 5; i++) {
//			int temp = ((int) (Math.random() * 100)) % 100;
			l2.insert(i, i);
			System.out.print(i + " ");
		}
		System.out.println();
		MergeTwoLists m = new MergeTwoLists();
		ListNode node = m.mergeTwoLists2(l1.head.next, l2.head.next);
		System.out.println("After Merge:");
		
		while(node != null) {
			System.out.print(String.valueOf(node.val) + " ");
			node = node.next;
		}
	}
}
