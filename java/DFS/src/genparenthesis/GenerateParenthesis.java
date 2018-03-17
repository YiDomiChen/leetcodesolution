/**
 * 
 * @LeetCode  22. Generate Parentheses
 * @Description:  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *	For example, given n = 3, a solution set is:
 *	
 *	[
 *	  "((()))",
 *	  "(()())",
 *	  "(())()",
 *	  "()(())",
 *	  "()()()"
 *	]
 * @Difficulty: Medium
 * @Category: Backtracking, DFS
 * @Author: Yi Chen
 * @CreatedTime: Mar 12, 2018
 * @LastEditTime: Mar 12, 2018
 *
 */
package genparenthesis;

import java.util.*;

public class GenerateParenthesis {
	
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		String par = "";
		helper(n, n, res, par);
		
		return res;
    }
	
	public void helper(int left, int right, List<String> res, String parenthesis) {
		if (left > right) return;
		if (left == 0 && right == 0) {
			res.add(new String(parenthesis.toString()));
			return;
		}
		
		if (left > 0) {
			helper(left - 1, right, res, parenthesis + "(");
		}
		if (right > 0) {
			helper(left, right - 1, res, parenthesis + ")");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis gp = new GenerateParenthesis();
		List<String> res = gp.generateParenthesis(3);
		for (String s : res) {
			System.out.println(s);
		}
		
	}

}
