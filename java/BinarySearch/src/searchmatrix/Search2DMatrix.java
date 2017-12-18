/**
 * 
 * @LeetCode 74. Search a 2D Matrix 
 * @Description Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties: *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * @Difficulty Medium 
 * @Tags Binary Search
 * @Author Yi Chen
 * @CreatedTime Jul 7, 2017
 * @LastEditTime Jul 7, 2017
 *
 */

package searchmatrix;

public class Search2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		
		int m = matrix.length, n = matrix[0].length;
		int start = 0, end = m * n - 1;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			int rowIdx = mid / n, colIdx = mid % n;
			if(matrix[rowIdx][colIdx] == target) {
				return true;
			}
			else if(matrix[rowIdx][colIdx] < target){
				start = mid;
			}
			else {
				end = mid;
			}
		}
		
		if(matrix[start / n][start % n] == target) {
			return true;
		}
		if(matrix[end / n][end % n] == target) {
			return true;
		}
		
        return false;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {
		                 {1,   3,  5,  7},
		                 {10, 11, 16, 20},
		                 {23, 30, 34, 50}
		               };
		Search2DMatrix search2dMatrix = new Search2DMatrix();
		System.out.println(search2dMatrix.searchMatrix(nums, 50));
		
	}

}
