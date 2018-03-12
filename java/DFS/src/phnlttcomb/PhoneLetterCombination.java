/**
 * 
 * @LeetCode  17. Letter Combinations of a Phone Number
 * @Description: Given a digit string, return all possible letter combinations 
 * that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * @Difficulty:  Medium 
 * @Category: Backtracking, String
 * @Author: Yi Chen
 * @CreatedTime: Jan 6, 2018
 * @LastEditTime: Jan 6, 2018
 *
 */
package phnlttcomb;

import java.util.*;

public class PhoneLetterCombination {
	
	public HashMap<String, ArrayList<String>> map = new HashMap<>();
	
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == "") {
			return res;
		}
		
		map.put("2", new ArrayList<String>(Arrays.asList(new String[] {"a", "b", "c"})));
		map.put("3", new ArrayList<String>(Arrays.asList(new String[] {"d", "e", "f"})));
		map.put("4", new ArrayList<String>(Arrays.asList(new String[] {"g", "h", "i"})));
		map.put("5", new ArrayList<String>(Arrays.asList(new String[] {"j", "k", "l"})));
		map.put("6", new ArrayList<String>(Arrays.asList(new String[] {"m", "n", "o"})));
		map.put("7", new ArrayList<String>(Arrays.asList(new String[] {"p", "q", "r", "s"})));
		map.put("8", new ArrayList<String>(Arrays.asList(new String[] {"t", "u", "v"})));
		map.put("9", new ArrayList<String>(Arrays.asList(new String[] {"w", "x", "y", "z"})));
		
		StringBuilder sb = new StringBuilder();
		helper(res, digits, sb);
		
		return res;
    }
	
	public void helper(List<String> res, String digits, StringBuilder combination) {
		if (combination.length() == digits.length()) {
			res.add(combination.toString());
			
			return;
		}
		
		String digit = digits.substring(combination.length(), combination.length() + 1);
		for (String s : map.get(digit)) {
			combination.append(s);
			helper(res, digits, combination);
			combination.deleteCharAt(combination.length() - 1);
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneLetterCombination plc = new PhoneLetterCombination();
		List<String> res = plc.letterCombinations("235");
		for (String comb : res) {
			System.out.println(comb);
		}
	}

}
