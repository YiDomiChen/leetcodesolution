/**
 * 
 * @LeetCode 211. Add and Search Word - Data structure design 
 * @Description Design a data structure that supports the following two operations: 
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters 
 * a-z or .. A . means it can represent any one letter.
 * 
 * @Difficulty Medium
 * @Tags Trie
 * @Author Yi Chen
 * @CreatedTime Jul 1, 2017
 * @LastEditTime Jul 1, 2017
 *
 */

package addsearch;

public class WordDictionary {
		
	public class TrieNode {
		private TrieNode[] children;
		private boolean hasWord;
		
		public TrieNode() {
			children = new TrieNode[26];
			hasWord = false;
		}
		
//		public void insert(String word, int index) {
//			if(index == word.length()) {
//				this.hasWord = true;
//				
//				return;
//			}
//			
//			int pos = word.charAt(index) - 'a';
//			if(children[pos] == null) {
//				children[pos] = new TrieNode();
//			}
//			
//			children[pos].insert(word, index + 1);
//		}
		
//		public TrieNode find(String word, int index) {
//			if(index == word.length()) {	
//				return this;
//			}
//			
//			if(word.charAt(index) == '.') {
//				for(int i = 0; i < 26; i++) {
//					if(children[i] != null) {
//						if(children[i].find(word, index + 1) != null) {
//							return children[i].find(word, index + 1);
//						}
//					}
//				}
//				return null;
//			}
//			else {
//				int pos = word.charAt(index) - 'a';
//				if(children[pos] == null) {
//					return null;
//				}
//					
//				return children[pos].find(word, index + 1);
//			}
//		}
		
	}
	
	private TrieNode root;
	
	/** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	TrieNode cur = root;
    	for(int i = 0; i < word.length(); i++) {
    		Character c = word.charAt(i);
    		if(cur.children[c - 'a'] == null) {
    			cur.children[c - 'a'] = new TrieNode();
    		}
    		cur = cur.children[c - 'a'];
    	}
    	cur.hasWord = true;	
//        root.insert(word, 0);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
//    	TrieNode node = root.find(word, 0);
//    	
//    	
//    	return (node != null && node.hasWord);    	
    	return find(word, 0, root);
    }
    
    private boolean find(String word, int index, TrieNode node) {
    	if(index == word.length()) {
    		
    		return node.hasWord;
    	}
    	
    	Character c = word.charAt(index);
    	if(c == '.') {
    		for(int i = 0; i < 26; i++) {
    			if(node.children[i] != null) {
    				if(find(word, index + 1, node.children[i])) {
    					
    					return true;
    				}
    			}
    		}
    		
    		return false;
    	}
    	
    	else if(node.children[c - 'a'] != null) {
    		
    		return find(word, index + 1, node.children[c - 'a']);
    	}
    	else {
    		
    		return false;
    	}
    }
    
}
