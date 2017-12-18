package intersectionoftwolinkedlists;

import utils.*;

/**
 * 
 * @LeetCode 160. Intersection of Two Linked Lists 
 * @Description Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists: 
 * 
 * A:          a1 → a2
                      ↘
                        c1 → c2 → c3
                      ↗            
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * @Difficulty Easy
 * @Tags Linked List
 * @Author Yi Chen
 * @CreatedTime May 26, 2017
 * @LastEditTime May 26, 2017
 *
 */
public class IntersTwoLists {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		/* Suppose list A has a nodes, list B has b nodes.
		 * a > b
		 * if they intersects,
		 * then A must have (b - a) more nodes than B before the intersection.
		 *  
		 *  O - O - O 
		 *           \
		 *            O - O - O 
		 *           /
		 *          O
		 *  
		 */		
		ListNode node1 = headA, node2 = headB;
		int countA = 0, countB = 0;
		while(node1 != null || node2 != null) {
			if(node1 != null) {
				node1 = node1.next;
				countA++;
			}
			if(node2 != null) {
				node2 = node2.next;
				countB++;
			}
		}
		int diff = Math.abs(countA - countB);
		int index = 0;
		node1 = headA;
		node2 = headB;
		//	move the node of long list n steps in advance. (n equals to the difference between two list's length)
		if(countA > countB) {
			while(index < diff) {
				node1 = node1.next;
				index++;
			}
		}
		else {
			while(index < diff) {
				node2 = node2.next;
				index++;
			}
		}
		//	then if the two lists intersects, node1 and node2 will meet at the same intersection.
		while(node1 != null && node2 != null) {
			if(node1 == node2) return node1;
			node1 = node1.next;
			node2 = node2.next;
		}
		
		return null;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
