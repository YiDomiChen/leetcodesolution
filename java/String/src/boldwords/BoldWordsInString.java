/**
 * 
 * @LeetCode 758. Bold Words in String
 * @Description:  Given a set of keywords words and a string S, 
 * make all appearances of all keywords in S bold. 
 * Any letters between <b> and </b> tags become bold.
 * 
 * The returned string should use the least number of tags possible, 
 * and of course the tags should form a valid combination.
 * 
 * For example, given that words = ["ab", "bc"] and S = "aabcd", 
 * we should return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" 
 * would use more tags, so it is incorrect. 
 * 
 * @Difficulty: Easy
 * @Category: String
 * @Author: Yi Chen
 * @CreatedTime: Jan 20, 2018
 * @LastEditTime: Jan 20, 2018
 *
 */
package boldwords;

public class BoldWordsInString {
	
	public String boldWords(String[] words, String S) {
		if (words.length == 0) {
            return S;
        }
        if (S.length() == 0) {
            return S;
        }
        
        boolean[] marked = new boolean[S.length()];
        for (String word : words) {
        	markSubstr(S, word, marked);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
        	if (marked[i] && (i == 0 || !marked[i - 1])) {
        		sb.append("<b>");
        	}
        	sb.append(S.charAt(i));
        	if (marked[i] && (i == S.length() - 1 || !marked[i + 1])) {
        		sb.append("</b>");
        	}
        }
        
        return sb.toString();
    }
	
	public void markSubstr(String S, String word, boolean[] marked) {
		for (int i = 0; i < S.length() - word.length(); i++) {
			String substr = S.substring(i, i + word.length());
			if (substr.equals(word)) {
				for (int j = i; j < i + word.length(); j++) {
					marked[j] = true;
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}