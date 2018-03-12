/**
 * 
 * @LeetCode  392. Is Subsequence
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Mar 3, 2018
 * @LastEditTime: Mar 3, 2018
 *
 */
package issubseq;

import java.util.ArrayList;
import java.util.LinkedList;

public class IsSubsequence {
	
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0) return true;
		int sIdx = 0, tIdx = 0;
		while(tIdx < t.length()) {
			if (s.charAt(sIdx) == t.charAt(tIdx)) {
				sIdx++;
				if (sIdx == s.length()) {
					return true;
				}
			}
			tIdx++;
		}
		
		return false;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsSubsequence is = new IsSubsequence();
		System.out.println(is.isSubsequence("axe", "abcde"));
	}

}
