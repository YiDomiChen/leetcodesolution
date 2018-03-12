/**
 * 
 * @LeetCode 13. Roman to Integer
 * @Description: Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @Difficulty: Easy
 * @Category: String
 * @Author: Yi Chen
 * @CreatedTime: Jan 20, 2018
 * @LastEditTime: Jan 20, 2018
 *
 */
package rm2int;

public class RomanToInteger {
	
	public int romanToInt(String s) {
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
		RomanToInteger r2i = new RomanToInteger();
		System.out.println(r2i.romanToInt("LXXVIII"));
	}

}
