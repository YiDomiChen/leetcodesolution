
package addtwonumberii;

import java.util.*;
import utils.*;

public class AddTwoNumII {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		while(l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while(l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}
		
		int carry = 0, sum, x, y;
		ListNode head = null;
		
		while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			x = stack1.isEmpty()? 0 : stack1.pop();
			y = stack2.isEmpty()? 0 : stack2.pop();	
			
			sum = (x + y + carry) % 10;
			carry = (x + y + carry) / 10;
			
			ListNode newNode = new ListNode(sum);
			newNode.next = head;
			head = newNode;
			
		}
		
        return head;
    }
	
}
