package longwordindict;

import java.util.*;

public class LongestWordInDictionary {
	
	public String longestWord(String[] words) {
		Arrays.sort(words);
		Set<String> set = new HashSet<>();
		String res = "";
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() == 1 || set.contains(words[i].substring(0, words[i].length() - 1))) {
				set.add(words[i]);
				if (words[i].length() > res.length()) {
					res = words[i];
				}
			}
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestWordInDictionary lwd = new LongestWordInDictionary();
		String[] arr = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		System.out.println(lwd.longestWord(arr));
	}

}
