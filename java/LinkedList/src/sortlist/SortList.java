package sortlist;

import utils.*;
/**
 * 
 * @LeetCode 148. Sort List
 * @Description Sort a linked list in O(n log n) time using constant space complexity.
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Jun 1, 2017
 * @LastEditTime Jun 1, 2017
 *
 */
public class SortList {
	
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode walker = head, runner = head;
		while(runner.next != null && runner.next.next != null) {
			walker = walker.next;
			runner = runner.next.next;
		}
		runner = walker.next;
		walker.next = null;
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(runner);
		
		return mergeSort(l1, l2);
    }
	
	public ListNode mergeSort(ListNode l1, ListNode l2) {				
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;	//	node cur: always points to the latest merging node  
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				cur.next = l1;
				cur = l1;
				l1 = l1.next;
			}
			else {
				cur.next = l2;
				cur = l2;
				l2 = l2.next;
			}
		}
		if(l1 != null) {
			cur.next = l1;
		}
		if(l2 != null) {
			cur.next = l2;
		}
		
		return dummy.next;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		for (int i = 0; i < 10; i++) {
			int temp = ((int) (Math.random() * 100)) % 100;
			list.insert(i, temp);
			System.out.print(temp + " ");
		}
		
		SortList s = new SortList();
		ListNode node = s.sortList(list.head.next);
		System.out.println("After Sorting:");
		
		while(node != null) {
			System.out.print(String.valueOf(node.val) + " ");
			node = node.next;
		}

	}

}
