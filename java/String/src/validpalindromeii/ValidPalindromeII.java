/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Nov 4, 2017
 * @LastEditTime Nov 4, 2017
 *
 */

package validpalindromeii;

public class ValidPalindromeII {
	
	public boolean validPalindrome(String s) {
		int start = 0, end = s.length() - 1;
        boolean isDeleted = false;
        while (start < end) {
            if (start < end && s.charAt(start) != s.charAt(end)) {
                if (isDeleted) {
                    return false;
                }
                if (s.charAt(++start) != s.charAt(end)) {
                    start--;
                    end--;
                    if (start > end || s.charAt(start) != s.charAt(end)) {
                        return false;
                    } 
                    isDeleted = true;
                } else {
                	isDeleted = true;
                }
            } else {
            	isDeleted = true;
            }
            start++;
            end--;
        }
        
        return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
		ValidPalindromeII v = new ValidPalindromeII();
		System.out.println(v.validPalindrome(s));
	}

}
