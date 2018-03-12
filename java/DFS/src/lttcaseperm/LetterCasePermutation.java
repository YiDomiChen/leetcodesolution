/**
 * 
 * @LeetCode  784. Letter Case Permutation
 * @Difficulty: Given a string S, we can transform every letter individually to be 
 * lowercase or uppercase to create another string.  
 * Return a list of all possible strings we could create.
 * 
 * @Category: Backtracking 
 * @Author: Yi Chen
 * @CreatedTime: Mar 11, 2018
 * @LastEditTime: Mar 11, 2018
 *
 */

package lttcaseperm;

import java.util.*;

public class LetterCasePermutation {
	
	public List<String> letterCasePermutation(String S) {
		List<String> res = new ArrayList<>();
		if (S == "") {
			return res;
		}
		
		helper(res, S, 0, "");
		return res;
    }
	
	public void helper(List<String> res, String s, int startIndex, String substr) {
		if (startIndex == s.length()) {
			res.add(substr);
			return;
		}
		
		if (Character.isAlphabetic(s.charAt(startIndex))) {
			helper(res, s, startIndex + 1, substr + Character.toUpperCase(s.charAt(startIndex)));
			helper(res, s, startIndex + 1, substr + Character.toLowerCase(s.charAt(startIndex)));
		} else {
			helper(res, s, startIndex + 1, substr + s.charAt(startIndex));
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCasePermutation lcp = new LetterCasePermutation();
		List<String> res = lcp.letterCasePermutation("a1b2");
		for (String s : res) {
			System.out.println(s);
		}
		
	}

}
