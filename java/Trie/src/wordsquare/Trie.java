/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Jul 1, 2017
 * @LastEditTime Jul 1, 2017
 *
 */

package wordsquare;

public class Trie {
	public class TrieNode {
		private TrieNode[] children;
		private boolean hasWord;
		
		public TrieNode() {
			children = new TrieNode[26];
			hasWord = false;
		}
		
		public void insert(String word, int index) {
			if(index == word.length()) {
				this.hasWord = true;
				
				return;
			}
			
			int pos = word.charAt(index) - 'a';
			if(children[pos] == null) {
				children[pos] = new TrieNode();
			}
			children[pos].insert(word, index + 1);
		}
		
		public TrieNode find(String word, int index) {
			if(index == word.length()) {				
				return this;
			}
			int pos = word.charAt(index) - 'a';
			if(children[pos] == null) {
				
				return null;
			}
			
			return children[pos].find(word, index + 1);
		}
	}
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		root.insert(word, 0);
	}
	
	public boolean search(String word) {
		TrieNode node = root.find(word, 0);
		
		return (node != null && node.hasWord);
	}
	
	public boolean startsWith(String word) {
		TrieNode node = root.find(word, 0);
		
		return node != null;
	}
	
}
