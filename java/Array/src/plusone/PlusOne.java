package plusone;

/**
 * 
 * @LeetCode 66. Plus One
 * @Description Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 * @Difficulty Easy
 * @Tags Array, Math
 * @Author Yi Chen
 * @CreatedTime May 20, 2017
 * @LastEditTime May 20, 2017
 *
 */
public class PlusOne {
	
	public int[] plusOne(int[] digits) {
		for(int i = digits.length - 1; i >= 0; i--) {
			if(digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
			
		}
		
		if(digits[0] == 0) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			for(int i = 0; i < digits.length; i++) {
				res[i + 1] = digits[i];
			}
			
			return res;
		}
		else {
			return digits;
		}
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] digits = {9,9,8};
		PlusOne p = new PlusOne();
		int[] res = p.plusOne(digits);
		for(int digit : res) {
			System.out.print(digit);
		}
		
	}
	
}
