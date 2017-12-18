package pascatriangle;

import java.util.*;

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
public class PascalTriangle {
	
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		int[][] arr = new int[numRows][numRows];
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0) arr[i][j] = 1;
				else {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}
			
			List<Integer> level = new ArrayList<Integer>();
			for(int j = 0; j <= i; j++) {
				level.add(arr[i][j]);
			}
			res.add(level);
		}		
		
		return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PascalTriangle p = new PascalTriangle();
		List<List<Integer>> res = p.generate(5);
		for(List<Integer> level : res ){
			for(Integer num : level) {
				System.out.print(String.valueOf(num) + ",");
			}
			System.out.println();
		}
	}

}
