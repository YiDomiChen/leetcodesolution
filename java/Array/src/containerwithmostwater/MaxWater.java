/**
 * 
 * @LeetCode 11 Container With Most Water 
 * @Description: Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn 
 * such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water. 
 * 
 * Note: You may not slant the container and n is at least 2. 
 * 
 * @Difficulty: Medium
 * @Category: Array
 * @Author: Yi Chen
 * @CreatedTime: Mar 1, 2017
 * @LastEditTime: Mar 1, 2017
 *
 */

package containerwithmostwater;

public class MaxWater {

	public int maxArea(int[] height) {
		if(height.length == 2) return Math.min(height[0], height[1]);
		int start = 0, end = height.length - 1;
		int maxArea = 0;
		while(start < end) {
			maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));
			if(height[start] < height[end]) {	//Compare area while moving left side of the container
				start++;
			}
			else if(height[start] > height[end]) {
				end--;
			}
			
		}
		
		return maxArea;
    }
}
