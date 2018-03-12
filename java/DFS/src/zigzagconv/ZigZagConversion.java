/**
 * 
 * @LeetCode  6. ZigZag Conversion
 * @Description: 
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 * 
 * @Difficulty: Medium
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Jan 6, 2018
 * @LastEditTime: Jan 6, 2018
 *
 */
package zigzagconv;

public class ZigZagConversion {
	
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0) {
			return s;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < numRows; i++) {
			int index = i * 2;
			int lastIndex = -1;
			for (int j = i; j < s.length(); j += index) {
				if (lastIndex != j) {
					sb.append(s.charAt(j));
				}
				lastIndex = j;
				if (index == (numRows - i) * 2 - 2) index = i * 2;
				else { index = (numRows - i) * 2 - 2; }
			}
		}
		
		return sb.toString();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversion zigzag = new ZigZagConversion();
		System.out.println(zigzag.convert("PAYPALISHIRING", 4));
	}

}
