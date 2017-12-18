/**
 * 
 * @LeetCode 162. Find Peak Element 
 * @Description A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ? num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -?.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * 
 * @Difficulty Medium
 * @Tags Binary Search 
 * @Author Yi Chen
 * @CreatedTime Jul 7, 2017
 * @LastEditTime Jul 7, 2017
 *
 */

package findpeakelem;

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if(nums == null) {
			return -1;
		}
		if(nums.length == 1) {
			return 0;
		}
		if(nums.length == 2) {
			return Math.max(nums[0], nums[1]) == nums[0] ? 0 : 1;
		}
		
		int start = 0, end = nums.length - 1;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(nums[mid] > nums[mid - 1] && nums[mid + 1] > nums[mid]) {
				start = mid;
			}
			else if(nums[mid] < nums[mid - 1] && nums[mid + 1] < nums[mid]) {
				end = mid;
			}
			else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return mid;
			}
			else {
				end = mid;
			}
		}
		
		if(start == 0) {
			return start;
		}
		if(end == nums.length - 1) {
			return end;
		}
		
		if(nums[start] > nums[start - 1]) {
			return start;
		}
		else if(nums[end] > nums[end - 1]) {
			return end;
		}
		
		return -1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeakElement f = new FindPeakElement();
		int[] nums = {3, 2, 1};
		System.out.println(f.findPeakElement(nums));
		
		
	}

}
