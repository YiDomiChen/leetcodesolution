/**
 * 
 * @LeetCode  340. Longest Substring with At Most K Distinct Characters
 * @Description:  Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3. 
 * @Difficulty: Hard
 * @Category: Two Pointers
 * @Author: Yi Chen
 * @CreatedTime: Jan 14, 2018
 * @LastEditTime: Jan 14, 2018
 *
 */
package longsubstrkdistinctchars;

import java.util.*;

public class LongestSubstrWithKDistinctChars {
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		HashMap<String, Integer[]> hashMap = new HashMap<>();
		hashMap.put("U", new Integer[] {1,2});
		
		int res = 0;
		if (s == null || s.length() == 0) {
			return res;
		}
		int i, j = 0;
		HashMap<Character, Integer> hash = new HashMap<>();
		
		for (i = 0; i < s.length(); i++) {
			while (j < s.length() && isValidSubstring(s.charAt(j), k, hash)) {
				if (!hash.containsKey(s.charAt(j))) {
					hash.put(s.charAt(j), 1);
				} else {
					hash.put(s.charAt(j), hash.get(s.charAt(j)) + 1);
				}
				
				j++;
			}
			
			res = Math.max(res, j - i);
			
			if (hash.get(s.charAt(i)) - 1 == 0) {
				hash.remove(s.charAt(i));
			} else {
				hash.put(s.charAt(i), hash.get(s.charAt(i)) - 1);
			}
		}
		
		
		return res;
    }
	
	public boolean isValidSubstring(char c, int k, HashMap<Character, Integer> hash) {
		if (hash.size() == k) {
			if (!hash.containsKey(c)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestSubstrWithKDistinctChars l = new LongestSubstrWithKDistinctChars();
		System.out.println(l.lengthOfLongestSubstringKDistinct("ecebeteqea", 3));

	}

}
