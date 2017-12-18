/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Jun 3, 2017
 * @LastEditTime Jun 3, 2017
 *
 */

package validpar;

import java.util.Stack;

public class ValidParentheses {

	
	public boolean isValid(String s) {
		Stack stack = new Stack();
		int index = 0;
		
		while(index < s.length()) {
			char c = s.charAt(index);
			switch (c) {
				case '(':
				case '{':
				case '[':
					stack.push(c);
					break;
				case ')':
					if(stack.isEmpty() || (char)stack.pop() != '(') return false;
					break;
				case '}':
					if(stack.isEmpty() || (char)stack.pop() != '{') return false;
					break;
				case ']':
					if(stack.isEmpty() || (char)stack.pop() != '[') return false;
					break;
				default:
					break;
			}
			
			index++;
		}
		
		if(stack.isEmpty()) return true;
		else return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidParentheses v = new ValidParentheses();
		System.out.println(v.isValid("{231{88}]"));
	}

}
