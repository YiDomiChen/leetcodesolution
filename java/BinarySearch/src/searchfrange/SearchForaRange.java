/**
 * 
 * @LeetCode 34. Search for a range
 * @Description Given an array of integers sorted in ascending order, 
 *  find the starting and ending position of a given target value.
 *  Your algorithm's runtime complexity must be in the order of O(log n).
 *  If the target is not found in the array, return [-1, -1].
 * @Difficulty Medium
 * @Tags Binary Search
 * @Author Yi Chen
 * @CreatedTime Dec 17, 2017
 * @LastEditTime Dec 17, 2017
 *
 */

package searchfrange;

public class SearchForaRange {
	public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        // find the lower bound
        int leftbound = -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            leftbound = start;
        } else if (nums[end] == target) {
            leftbound = end;
        } else {
            return res;
        }
        
        // find the upper bound
        int rightbound = -1;
        start = 0; end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            rightbound = end;
        } else if (nums[start] == target) {
            rightbound = start;
        }
        
        res[0] = leftbound;
        res[1] = rightbound;
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
