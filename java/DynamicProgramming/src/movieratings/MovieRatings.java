/**
 * 
 * @LeetCode
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Feb 5, 2018
 * @LastEditTime: Feb 5, 2018
 *
 */
package movieratings;

public class MovieRatings {
	
	public int maximizeRatings(int[] ratings) {
		int[] dp = new int[ratings.length];
		int res = 0;
		
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2]);
		}
		
		return dp[ratings.length - 1];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieRatings mr = new MovieRatings();
		int[] ratings = {9, -1, -3, 4, 5};
		System.out.print(mr.maximizeRatings(ratings));
	}

}
