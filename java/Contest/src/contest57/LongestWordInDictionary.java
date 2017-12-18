/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Nov 4, 2017
 * @LastEditTime Nov 4, 2017
 *
 */

package contest57;

import java.util.*;

public class LongestWordInDictionary {
	
	
	public String longestWord(String[] words) {
        if (words.length == 0) {
            return "";
        }
        
        Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() > s2.length()) {
					return 1;
				} else if (s1.length() < s2.length()) {
					return -1;
				} else {
					return s1.compareTo(s2);
				}
			}
		});
//        
//		for (String word : words) {
//			System.out.println(word);
//		}
        
        Set<String> hashset = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
        	if (words[i].length() == 1 || hashset.contains(words[i].substring(0, words[i].length() - 1))) {
        		hashset.add(words[i]);
        	}
        }
        
        if (hashset.size() <= 1) {
        	return "";
        }
        
        Iterator<String> iter = hashset.iterator();
        String[] res = new String[hashset.size()];
        int i = 0;
        while (iter.hasNext()) {
        	 res[i++] = iter.next();
        }
       
        Arrays.sort(res, new Comparator<String>() {
        	public int compare(String s1, String s2) {
        		if (s1.length() < s2.length()) {
        			return 1;
        		} else if (s1.length() > s2.length()) {
        			return -1;
        		} else {
        			return s1.compareTo(s2);
        		}
        	}
		});
        
        return res[0];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
//		
//		for (String word : words) {
//			System.out.println(word);
//		}
		
		LongestWordInDictionary l = new LongestWordInDictionary();
		System.out.println(l.longestWord(words));
	}

}
