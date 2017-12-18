/**
 * 
 * @LeetCode 69 Sqrt(X)
 * @Description Implement int sqrt(int x).
 * Compute and return the square root of x.
 * @Difficulty Easy
 * @Tags Binary Search 
 * @Author Yi Chen
 * @CreatedTime Jul 5, 2017
 * @LastEditTime Jul 5, 2017
 *
 */

package sqrtx;

public class SqrtX {
	
	public int mySqrt(int x) {
		if(x <= 0) return x;
		
		int start = 1, end = x;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(mid == x / mid) {
				return mid;
			}
			else if(mid > x / mid) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
		
		return start;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqrtX s = new SqrtX();
		System.out.println(s.mySqrt(2147395598));
	}

}
