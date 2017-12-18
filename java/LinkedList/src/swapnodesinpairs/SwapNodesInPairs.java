package swapnodesinpairs;

import insertionsortlist.InsertionSortList;
import utils.*;

/**
 * 
 * @LeetCode 24. Swap Nodes in Pairs 
 * @Description Given a linked list, swap every two adjacent nodes and return its head. 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.  
 * @Difficulty Medium
 * @Tags Linked List
 * @Author Yi Chen
 * @CreatedTime Jun 1, 2017
 * @LastEditTime Jun 1, 2017
 *
 */
public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode fakehead = new ListNode(0);
		fakehead.next = head;
		ListNode pre = fakehead;
		
		ListNode node1 = head;
		while(node1 != null && node1.next != null) {
			ListNode node2 = node1.next;
			ListNode next = node2.next;
			
			pre.next = node2;
			node2.next = node1;
			node1.next = next;
			
			pre = node1;
			node1 = next;
		}
		
		
		return fakehead.next;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();
		for (int i = 0; i < 11; i++) {
			int temp = ((int) (Math.random() * 100)) % 100;
			list.insert(i, temp);
			System.out.print(temp + " ");
		}
		
		SwapNodesInPairs s = new SwapNodesInPairs();
		ListNode node = s.swapPairs(list.head.next);
		System.out.println("After Swapping:");
		
		while(node != null) {
			System.out.print(String.valueOf(node.val) + " ");
			node = node.next;
		}

	}

}
