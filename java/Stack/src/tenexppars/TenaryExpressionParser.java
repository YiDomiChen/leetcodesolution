/**
 * 
 * @LeetCode  439. Ternary Expression Parser
 * @Description: Given a string representing arbitrarily nested ternary expressions, 
 * calculate the result of the expression. 
 * You can always assume that the given expression 
 * is valid and only consists of digits 0-9, ?, :, T and F 
 * (T and F represent True and False respectively). 
 * 
 * 
 * Note:

    The length of the given string is ≤ 10000.
    Each number will contain only one digit.
    The conditional expressions group right-to-left (as usual in most languages).
    The condition will always be either T or F. That is, the condition will never be a digit.
    The result of the expression will always evaluate to either a digit 0-9, T or F.

Example 1:

Input: "T?2:3"
Output: "2"
Explanation: If true, then result is 2; otherwise result is 3.

Example 2:

Input: "F?1:T?4:5"
Output: "4"
Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
             "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
          -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
          -> "4"                                    -> "4"

Example 3:
Input: "T?T?F:5:3"
Output: "F"
Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
             "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
          -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
          -> "F"                                    -> "F"

 * 
 * 
 * 
 * @Difficulty:  Medium
 * @Category: Stack
 * @Author: Yi Chen
 * @CreatedTime: Feb 11, 2018
 * @LastEditTime: Feb 11, 2018
 *
 */
package tenexppars;
import java.util.Stack;

public class TenaryExpressionParser {
	
	public String parseTernary(String expression) {
		if (expression == null || expression.length() == 0) {
			return "";
		} 
		
		Stack<String> s = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = expression.length() - 1; i >= 0; i--) {
			if (Character.isDigit(expression.charAt(i))) {
				sb.insert(0, expression.charAt(i));
			} else if (expression.charAt(i) == 'T' || expression.charAt(i) == 'F') {
				s.push(String.valueOf(expression.charAt(i)));
			} else if (expression.charAt(i) == ':') {
				if (sb.length() != 0) {
					s.push(sb.toString());
					sb = new StringBuilder();
				}
			} else if (expression.charAt(i) == '?') {
				i--;
				if (sb.length() != 0) {
					s.push(sb.toString());
					sb = new StringBuilder();
				}
				String left = s.pop();
				String right = s.pop();
				s.push(expression.charAt(i) == 'T' ? left : right);
			}
		}
		
		return s.pop();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expr = "T?T?65:50:35";
		TenaryExpressionParser tep = new TenaryExpressionParser();
		System.out.println(tep.parseTernary(expr));
	}

}
