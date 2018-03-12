/**
 * 
 * @LeetCode  159. Longest Substring with At Most Two Distinct Characters
 * @Description:  Given a string, find the length of the longest substring T 
 * that contains at most 2 distinct characters.
 * For example, Given s = “eceba”,
 * T is "ece" which its length is 3. 
 * @Difficulty:  Hard 
 * @Category: Two Pointers
 * @Author: Yi Chen
 * @CreatedTime: Jan 12, 2018
 * @LastEditTime: Jan 12, 2018
 *
 */
package longsubstr2distinctchars;

import java.util.*;

public class LongestSubstrWithTwoDistinctChars {
	
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int i = 0, j = 0;
        int res = 0;
        while (i < s.length()) {
        	while (j < s.length() && isValidSubstring(s.charAt(j), hash)) {
        		if (!hash.containsKey(s.charAt(j))) {
        			hash.put(s.charAt(j), 1);
        		} else {
        			hash.put(s.charAt(j), hash.get(s.charAt(j)) + 1);
        		}
        		j++;
        	}
        	if (j - i > res) {
        		res = j - i;
        	}   
        	
        	
        	if (hash.get(s.charAt(i)) - 1 == 0) {
        		hash.remove(s.charAt(i));
        	} else {
        		hash.put(s.charAt(i), hash.get(s.charAt(i)) - 1);
        	}
        	i++;
        }
        
        return res;
    }
	
	public boolean isValidSubstring(char c, HashMap<Character, Integer> hash) {
		if (hash.size() == 2) {
			if (!hash.containsKey(c)) {
				return false;
			} else {
				return true;
			} 
		} else {
			return true;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstrWithTwoDistinctChars l = new LongestSubstrWithTwoDistinctChars();
		System.out.println(l.lengthOfLongestSubstringTwoDistinct("ecebabbb"));
	}

}
