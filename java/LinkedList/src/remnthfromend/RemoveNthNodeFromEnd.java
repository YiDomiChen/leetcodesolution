package remnthfromend;

import utils.*;

/**
 * 
 * @LeetCode 19. Remove Nth Node From End of List 
 * @Description Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 *  After removing the second node from the end, the linked list becomes 1->2->3->5.
 *  Note:
 *  Given n will always be valid.
 *  Try to do this in one pass. 
 * 
 * 
 * @Difficulty Easy
 * @Tags Linked List, Two Pointers
 * @Author Yi Chen
 * @CreatedTime May 26, 2017
 * @LastEditTime May 26, 2017
 *
 */
public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int index = 0;
		ListNode fast = head, slow = head;
		ListNode result = head;
		while(index < n && fast != null) {	//	set the fast node n steps ahead of the slow node.
			fast = fast.next;
			index++;
		}
		if(fast == null) return head.next;
		
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		slow.next = slow.next.next;	//	delete nth node.
		
		return result;
    }
	
	
	public static void main(String[] args)  throws Exception{
		LinkedList list = new LinkedList();
		for (int i = 0; i < 10; i++) {
			int temp = ((int) (Math.random() * 100)) % 100;
			list.insert(i, temp);
			System.out.print(temp + " ");
		}
		
		RemoveNthNodeFromEnd r = new RemoveNthNodeFromEnd();
		ListNode node = r.removeNthFromEnd(list.head.next, 10);
		System.out.println("After Removing");
		
		while(node != null) {
			System.out.print(String.valueOf(node.val) + " ");
			node = node.next;
		}
	}
}
