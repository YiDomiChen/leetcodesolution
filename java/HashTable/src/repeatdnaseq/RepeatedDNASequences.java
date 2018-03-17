/**
 * 
 * @LeetCode  187. Repeated DNA Sequences
 * @Description: Write a function to find all the 10-letter-long sequences (substrings) 
 * that occur more than once in a DNA molecule.
 * 
 *  For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @Difficulty: Medium
 * @Category: HashTable
 * @Author: Yi Chen
 * @CreatedTime: Mar 13, 2018
 * @LastEditTime: Mar 13, 2018
 *
 */
package repeatdnaseq;

import java.util.*;

public class RepeatedDNASequences {
	
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> s1 = new HashSet<>(), s2 = new HashSet<>();
		for (int i = 0; i + 9 < s.length(); i++) {
			String seq = s.substring(i, i + 10);
			if (!s1.add(s.substring(i, i + 10))) {
				s2.add(seq);
			}
		}
		
		return new ArrayList<>(s2);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
