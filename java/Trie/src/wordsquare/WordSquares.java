/**
 * 
 * @LeetCode 425. Word Squares 
 * @Description Given a set of words (without duplicates), find all word squares you can build from them.
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, 
 * where 0 ≤ k < max(numRows, numColumns).
 * For example, the word sequence ["ball","area","lead","lady"] 
 * forms a word square because each word reads the same both horizontally and vertically.
 * @Difficulty Hard
 * @Tags Trie
 * @Author Yi Chen
 * @CreatedTime Jul 1, 2017
 * @LastEditTime Jul 1, 2017
 *
 */

package wordsquare;

import java.util.*;

public class WordSquares {
	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> res = new ArrayList<List<String>>();
		Trie trie = new Trie();
		for(String word : words) {
			trie.insert(word);
		}
		
		
		
		
        throw new UnsupportedOperationException();
    }
}
