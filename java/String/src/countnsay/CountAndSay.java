/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Jun 3, 2017
 * @LastEditTime Jun 3, 2017
 *
 */

package countnsay;

public class CountAndSay {
	
	
	public String countAndSay(int n) {		
		String numStr = "1";
		while(n > 1) {
			int index = 0;
			int count = 0;
			StringBuilder sb = new StringBuilder();
			while(index < numStr.length()) {
				if(index == 0 || numStr.charAt(index) == numStr.charAt(index - 1)) {
					count++;
				}
				else {
					sb.append(count).append(numStr.charAt(index - 1));
					count = 1;
				}
				
						
				index++;
			}
			if(count == 0) {
				sb.append(1).append(numStr.charAt(numStr.length() - 1));
			}
			else {
				sb.append(count).append(numStr.charAt(numStr.length() - 1));
			}
			
			numStr = sb.toString();
			n--;
		}
		
		
        return numStr;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountAndSay c = new CountAndSay();
		System.out.println(c.countAndSay(6));
	}

}
