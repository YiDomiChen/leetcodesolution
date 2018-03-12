/**
 * 
 * @LeetCode 541. Reverse String II
 * @Description: Given a string and an integer k, you need to reverse the first k characters 
 * for every 2k characters counting from the start of the string. 
 * If there are less than k characters left, reverse all of them. 
 * If there are less than 2k but greater than or equal to k characters, 
 * then reverse the first k characters and left the other as original. 
 * @Difficulty: Easy
 * @Category: String
 * @Author: Yi Chen
 * @CreatedTime: Jan 5, 2018
 * @LastEditTime: Jan 5, 2018
 *
 */
package revstrii;

public class ReverseStringII {
	
	public String reverseStr(String s, int k) {
		if (s == null || s.length() == 0) {
			return s;
		}
		
		boolean needReverse = true;
		int remain = s.length() % k; 
		int end = s.length() - remain;
		int index = 0;
		StringBuilder sb = new StringBuilder();
		while (index + k <= end) {
			if (needReverse) {
				sb.append(reverse(s.substring(index, index + k)));
			} else {
				sb.append(s.substring(index, index + k));
			}
			index += k;
			needReverse = !needReverse;
		}
		
		if (needReverse) {
			sb.append(reverse(s.substring(end, s.length())));
		} else {
			sb.append(s.substring(end, s.length()));
		}
		
		return sb.toString();
    }
	
	public String reverse(String s) {
		char[] arr = new char[s.length()];
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			arr[i] = s.charAt(j);
			arr[j] = s.charAt(i);
			i++;
			j--;
		}
		
		return new String(arr);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseStringII r = new ReverseStringII();
		System.out.println(r.reverseStr("abcdefghijk", 3));
	}

}
