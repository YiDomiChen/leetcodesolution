/**
 * 
 * @LeetCode  67. Add Binary
 * @Description:  Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100". 
 * @Difficulty: Easy
 * @Category: String, Math
 * @Author: Yi Chen
 * @CreatedTime: Mar 14, 2018
 * @LastEditTime: Mar 14, 2018
 *
 */
package addbin;

public class AddBinary {
	
	public String addBinary(String a, String b) {
        int indexA = a.length() - 1, indexB = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int anum = 0, bnum = 0;
        int digit = 0, carry = 0;
        while (indexA >= 0 || indexB >= 0) {
            anum = indexA >= 0 ? a.charAt(indexA) - '0' : 0;
            bnum = indexB >= 0 ? b.charAt(indexB) - '0' : 0;
            
            digit = (anum + bnum + carry) % 2;
            carry = (anum + bnum + carry) / 2;
            
            sb.insert(0, digit);
            indexA--;
            indexB--;
        }
        
        
        if (carry != 0) {
        	sb.insert(0, carry);
        }
        
        return sb.toString();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary("1010", "1011"));
	}

}
