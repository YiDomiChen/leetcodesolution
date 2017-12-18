/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime May 28, 2017
 * @LastEditTime May 28, 2017
 *
 */

package reversestr;

public class ReverseString {

	public String reverseString(String s) {
		if(s.length() <= 1) return s;
        int left = 0, right = s.length() - 1;
        
        char[] res = new char[s.length()];
        while(left < right) {
        	res[left] = s.charAt(right);
        	res[right] = s.charAt(left);
        	left++;
        	right--;
        }
        res[left] = s.charAt(right);
        
        return String.valueOf(res);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseString r = new ReverseString();
		System.out.println(r.reverseString("hello"));

	}

}
