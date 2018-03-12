/**
 * 
 * @LeetCode 3. Longest Substring Without Repeating Characters
 * @Description: Given a string, find the length of the longest substring without repeating characters.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 
 * 
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Jan 8, 2018
 * @LastEditTime: Jan 8, 2018
 *
 */
package longsubstrworepchars;

public class LongestSubstrWithoutRepeatChars {
	
	public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        
        int[] hash = new int[256];
        int i = 0, j = 0;
        for (i = 0; i < s.length(); i++) {
        	while (j < s.length() && !hasRepeat(s.charAt(j), hash)) {
        		hash[s.charAt(j)]++;
        		j++;
        	}
        	res = Math.max(j - i, res);
        	hash[s.charAt(i)]--;
        }
        
        return res;
        
    }
	
	public boolean hasRepeat(char c, int[] hash) {
		if (hash[c] > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstrWithoutRepeatChars l = new LongestSubstrWithoutRepeatChars();
		System.out.println(l.lengthOfLongestSubstring("pwwkew"));
		
	}

}
