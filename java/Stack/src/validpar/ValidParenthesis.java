/**
 * 
 * @LeetCode
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Feb 11, 2018
 * @LastEditTime: Feb 11, 2018
 *
 */
package validpar;

import java.util.*;

public class ValidParenthesis {
	public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '{': case '[': case '(':
                    stack.push(s.charAt(i));
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
            }
        }
        
        return stack.isEmpty();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParenthesis vp = new ValidParenthesis();
		System.out.println(vp.isValid("()"));
	}

}
