/**
 * 
 * @LeetCode 354. Russian Doll Envelopes
 * @Description: You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
 * One envelope can fit into another if and only if both the width and height of 
 * one envelope is greater than the width and height of the other envelope.

 * What is the maximum number of envelopes can you Russian doll? (put one inside other) 
 * @Difficulty: Hard
 * @Category: Dynamic Programming
 * @Author: Yi Chen
 * @CreatedTime: Mar 10, 2018
 * @LastEditTime: Mar 10, 2018
 *
 */
package rusdollenv;

import java.util.*;

public class RussianDollEnvelopes {
	
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}
		if (envelopes[0] == null || envelopes[0].length == 0) {
			return 0;
		}
		
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) return a[1] - b[1];
				return a[0] - b[0];
			}
		});
		
		int res = 1;
		int[] dp = new int[envelopes.length];
		for (int i = 0; i < envelopes.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			
			res = Math.max(res, dp[i]);
		}
		
		return res;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RussianDollEnvelopes rde = new RussianDollEnvelopes();
		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(rde.maxEnvelopes(envelopes));
	}

}
