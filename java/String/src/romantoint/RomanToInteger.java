/**
 * 
 * @LeetCode 13. Roman to Integer
 * @Description: Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @Difficulty:  Easy 
 * @Category: String, Math
 * @Author: Yi Chen
 * @CreatedTime: Feb 5, 2018
 * @LastEditTime: Feb 5, 2018
 *
 */
package romantoint;

import java.util.Arrays;
import java.util.Comparator;

public class RomanToInteger {	
	public int romanToInt(String s) {
		String[] arr = new String[10];
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String a, String b) {
				return -1;
			}
		});
		
		
		if (s == null || s.length() == 0) {
			return 0;
		}
		int res = getDigit(s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; i--) {
			int curVal = getDigit(s.charAt(i));
			int prevVal = getDigit(s.charAt(i + 1));
			if (curVal >= prevVal) {
				res += curVal;
			} else {
				res -= curVal;
			}	
		}
		
		return res;
    }
	
	public int getDigit(char c) {
		int res = 0;
		switch (c) {
			case 'I':
				res = 1;
				break;
			case 'V':
				res = 5;
				break;
			case 'X':
				res = 10;
				break;
			case 'L':
				res = 50;
				break;
			case 'C':
				res = 100;
				break;
			case 'D':
				res = 500;
				break;
			case 'M':
				res = 1000;
				break;
			default:
				break;
		}
		
		return res;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
