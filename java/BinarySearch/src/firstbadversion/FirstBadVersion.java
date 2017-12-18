/**
 * 
 * @LeetCode 278. First Bad Version
 * @Description  You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. You should minimize the number of calls to the API. 
 * @Difficulty Easy
 * @Tags Binary Search
 * @Author Yi Chen
 * @CreatedTime Jul 7, 2017
 * @LastEditTime Jul 7, 2017
 *
 */

package firstbadversion;

public class FirstBadVersion {
	
	
	private boolean isBadVersion(int version) {
		throw new UnsupportedOperationException();
	}
	
	
	public int firstBadVersion(int n) {
		int start = 1, end = n;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        
        if(isBadVersion(start)) {
            return start;
        }
        if(isBadVersion(end)) {
            return end;
        }
        
        return -1;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
