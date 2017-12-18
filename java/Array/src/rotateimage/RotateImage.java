package rotateimage;

/**
 * 
 * @LeetCode 48. Rotate Image 
 * @Description You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * @Difficulty Medium
 * @Tags Array
 * @Author Yi Chen
 * @CreatedTime May 30, 2017
 * @LastEditTime May 30, 2017
 *
 */
public class RotateImage {
	
	
	public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length / 2; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {	//	flip the pixels horizontally
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[matrix.length - i - 1][j];
        		matrix[matrix.length - i - 1][j] = tmp;
        	}
        }
        
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = i + 1; j < matrix[0].length; j++) {
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = tmp;
        	}
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
		RotateImage r = new RotateImage();
		r.rotate(arr);
		 for(int i = 0; i < arr.length; i++) {
        	for(int j = 0; j < arr[0].length; j++) {
        		System.out.print(String.valueOf(arr[i][j]) + ",");
        		
        	}
        	System.out.println();
		 }
		
	}

}
