package insertionsortlist;

import utils.*;

/**
 * 
 * @LeetCode 147. Insertion Sort List 
 * @Description Sort a linked list using insertion sort.
 * @Difficulty Medium
 * @Tags Linked List
 * @Author Yi Chen
 * @CreatedTime May 27, 2017
 * @LastEditTime May 27, 2017
 *
 */
public class InsertionSortList {
	
	public ListNode insertionSortList(ListNode head) {
	    ListNode helper = new ListNode(0);
	    ListNode pre = helper;	//	pre is a reference
	    ListNode current = head;
	    while(current != null) {
	        pre = helper;
	        while(pre.next != null && pre.next.val < current.val) {
	            pre = pre.next;
	        }
	        ListNode next = current.next;
	        current.next = pre.next;
	        pre.next = current;	// for the first loop, set helper.next point to the head node, after that helper node will never move
	        current = next;
	    }
	    
	    return helper.next;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		for (int i = 0; i < 10; i++) {
			int temp = ((int) (Math.random() * 100)) % 100;
			list.insert(i, temp);
			System.out.print(temp + " ");
		}
		
		InsertionSortList i = new InsertionSortList();
		ListNode node = i.insertionSortList(list.head.next);
		System.out.println("After Sorting:");
		
		while(node != null) {
			System.out.print(String.valueOf(node.val) + " ");
			node = node.next;
		}
		
	}

}
