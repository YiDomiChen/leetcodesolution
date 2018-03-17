/**
 * 
 * @LeetCode  119. Pascal's Triangle II
 * @Description: Given an index k, return the kth row of the Pascal's triangle.

 * For example, given k = 3,
 * Return [1,3,3,1].
 *  
 * @Difficulty: Easy 
 * @Category: Array
 * @Author: Yi Chen
 * @CreatedTime: Mar 14, 2018
 * @LastEditTime: Mar 14, 2018
 *
 */
package pascatriangleii;

import java.util.*;

public class PascalTriangleII {
	
	public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                if (j == i) {
                    res.add(1);
                } else {
                    res.set(j, res.get(j - 1) + res.get(j));
                }
            }
        }
        
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
