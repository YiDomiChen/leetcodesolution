/**
 * 
 * @LeetCode 203. Remove Linked List Elements 
 * @Description Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5 
 * 
 * @Difficulty Easy
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime May 27, 2017
 * @LastEditTime May 27, 2017
 *
 */

package removelistelem;

import utils.*;

public class RemoveListElements {
	
	public ListNode removeElements(ListNode head, int val) {		
		if(head == null) return null; 
		while(head != null && head.val == val) {
			head = head.next;
		}
		ListNode node = head;
		
		while(node != null && node.next != null) {
			if(node.next.val == val) {
				node.next = node.next.next;
			}
			else {
				node = node.next;
			}
		}
		
		return head;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();
		for (int i = 0; i < 10; i++) {
			int temp = ((int) (Math.random() * 4)) % 4;
//			int temp = i % 4;
			list.insert(i, temp);
			System.out.print(temp + " ");
		}
		
		RemoveListElements r = new RemoveListElements();
		ListNode node = r.removeElements(list.head.next, 0);
		System.out.println("After Removing");
		
		while(node != null) {
			System.out.print(String.valueOf(node.val) + " ");
			node = node.next;
		}

	}

}
