/**
 * 
 * @LeetCode 302. Smallest Rectangle Enclosing Black Pixels
 * @Description An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. 
 * The black pixels are connected, i.e., there is only one black region. 
 * Pixels are connected horizontally and vertically. Given the location (x, y) of one of 
 * the black pixels, return the area of the smallest (axis-aligned) rectangle 
 * that encloses all black pixels.
 * 
 *  For example, given the following image:

	[
	  "0010",
	  "0110",
	  "0100"
	]

	and x = 0, y = 2,

	Return 6. 
	
 * @Difficulty: Hard
 * @Tags: Binary Search
 * @Author: Yi Chen
 * @CreatedTime: Dec. 18, 2017
 * @LastEditTime: Dec. 18, 2017
 *
 */

package smallrecpix;

public class SmallestRecEncBlkPixels {
	
	public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0) {
            return 0;
        }
        
        int left = findLeft(image, x, y);
        int right = findRight(image, x, y);
        int top = findTop(image, x, y);
        int bottom = findBottom(image, x, y);
        
        return (right - left + 1) * (bottom - top + 1); 
    }
    
    private int findTop(char[][] image, int x, int y) {
        int start = 0, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (isEmptyRow(image, start)) {
            return end;
        } else {
            return start;
        }
    }
    
    private int findLeft(char[][] image, int x, int y) {
        int start = 0, end = y;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyCol(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (isEmptyCol(image, start)) {
            return end;
        } else {
            return start;
        }
    }
    
    private int findRight(char[][] image, int x, int y) {
        int start = y, end = image[0].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyCol(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (isEmptyCol(image, end)) {
            return start;
        } else {
            return end;
        }
    }
    
    private int findBottom(char[][] image, int x, int y) {
        int start = x, end = image.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (isEmptyRow(image, end)) {
            return start;
        } else {
            return end;
        }
    }
    
    private boolean isEmptyCol(char[][] image, int colIdx) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][colIdx] == '1') {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isEmptyRow(char[][] image, int rowIdx) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[rowIdx][i] == '1') {
                return false;
            }
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
