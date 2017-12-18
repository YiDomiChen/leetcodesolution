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

package addsearch;

public class WordDictionaryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary w = new WordDictionary();
//		w.addWord("ran");
//		w.addWord("rune");
//		w.addWord("runner");
//		w.addWord("runs");
		w.addWord("add");
		w.addWord("adds");
		w.addWord("adder");
		w.addWord("addee");
		
//		System.out.println(w.search("r.n"));
//		System.out.println(w.search("ru.n.e"));
		System.out.println(w.search("add"));
		System.out.println(w.search("add."));
		System.out.println(w.search("add.f"));
	}

}
