/**
 * 
 * @LeetCode 237. Delete Node in a Linked List 
 * @Description Write a function to delete a node (except the tail) in a singly linked list, given only access to that node. 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 * the linked list should become 1 -> 2 -> 4 after calling your function. 
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime May 27, 2017
 * @LastEditTime May 27, 2017
 *
 */

package deletenode;

import utils.*;

public class DeleteNode {
	
	
	public void deleteNode(ListNode node) {
		node.val = node.next.val;	//	set the replace the value with next node's value, and delete the next node 
        node.next = node.next.next;
    }

}
