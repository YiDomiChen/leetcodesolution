package miniwinsubs;

/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Jun 5, 2017
 * @LastEditTime Jun 5, 2017
 *
 */
public class MinimumWindowSubstring {

	public void initTargetHash(int[] targetHash, String t) {
		for(int i = 0; i < t.length(); i++) {
			targetHash[t.charAt(i)] += 1;
		}
	}
	
	public boolean isValid(int[] sourceHash, int[] targetHash) {
		for(int i = 0; i < 256; i++) {
			if(sourceHash[i] < targetHash[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public String minWindow(String s, String t) {
		
		int[] sourceHash = new int[256];
		int[] targetHash = new int[256];
		String minStr = "";
		
		initTargetHash(targetHash, t);
		int range = 0;
		
		
		int left = 0, right = 0;
		for(left = 0; left < s.length(); left++) {
			while(!isValid(sourceHash, targetHash) && right < s.length()) {
				sourceHash[s.charAt(right)]++;
				right++;
			}
			
			if(right == s.length()) break;
			
			if(range > right - left) {
				range = right - left;
			}
			
		}
		
		
		throw new UnsupportedOperationException();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
