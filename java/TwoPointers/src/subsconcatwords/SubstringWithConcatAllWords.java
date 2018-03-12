/**
 * 
 * @LeetCode  30. Substring with Concatenation of All Words
 * @Description: You are given a string, s, and a list of words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word 
 * in words exactly once and without any intervening characters.
 * 
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter.)
 * 
 * @Difficulty: Hard
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Jan 8, 2018
 * @LastEditTime: Jan 8, 2018
 *
 */
package subsconcatwords;

import java.util.*;

public class SubstringWithConcatAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		HashMap<String, Integer> countMap = new HashMap<>();
		for (String word : words) {
			if (countMap.containsKey(word)) {
				countMap.put(word, countMap.get(word) + 1);
			} else {
				countMap.put(word, 1);
			}
		}
		
		int wordLen = words[0].length();
		int substrLen = wordLen * words.length;
		
		for (int i = 0; i + substrLen < s.length(); i++) {
			
		}
		
        return null;
    }
	
    public List<Integer> findSubstring_zhaoyang(String s, String[] words) {
      List<Integer> ans = new ArrayList<Integer>();
      if(s == null ||words == null || words.length == 0 || words[0] == null) return ans;
      int wordsNum = words.length, wordLength = words[0].length();
      int substringLength = wordsNum * wordLength;
      if(s.length() == 0) {
        if(substringLength != 0){
          return ans;
        }
        ans.add(0);   //s = "", words = {""}, match at 0
        return ans;
      }
      //initialize count
      Map<String, Integer> originCount = new HashMap<String, Integer>();
      for (String word: words){
        originCount.put(word, originCount.containsKey(word) ? originCount.get(word) + 1 : 1);
      }
      // wordLength possibilities of window start position
      for (int startFrom = 0; startFrom < wordLength && startFrom <= s.length() - substringLength; startFrom++) {
        Map<String, Integer> count = new HashMap<String, Integer>(originCount);
        int outWordNum = 0, negWordNum = 0;
        //initialize window
        for (int i = startFrom; i < startFrom + substringLength; i += wordLength) {
          String thisWord = s.substring(i, i + wordLength);
          if (!count.containsKey(thisWord)) outWordNum++;
          else {
            count.put(thisWord, count.get(thisWord) - 1);
            if (count.get(thisWord) < 0)  negWordNum++;
          }
        }
        //check and move window
        int i = startFrom;
        boolean justChecked = false;
        for (; i < s.length() - substringLength; i += wordLength) {
          if (outWordNum == 0 && negWordNum == 0) ans.add(i);
          justChecked = true;
          String thisMoveOutWord = s.substring(i, i + wordLength);
          if (!count.containsKey(thisMoveOutWord)) outWordNum--;
          else {
            count.put(thisMoveOutWord, count.get(thisMoveOutWord) + 1);
            if (count.get(thisMoveOutWord) <= 0)  negWordNum--;
          }
          if(i + substringLength + wordLength > s.length()) break;
          String newWord = s.substring(i + substringLength, i + substringLength + wordLength);
          justChecked = false;
          if (!count.containsKey(newWord)) outWordNum++;
          else {
            count.put(newWord, count.get(newWord) - 1);
            if (count.get(newWord) < 0)  negWordNum++;
          }
        }
        if (!justChecked && outWordNum == 0 && negWordNum == 0) ans.add(i); //last check
      }
      return ans;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
