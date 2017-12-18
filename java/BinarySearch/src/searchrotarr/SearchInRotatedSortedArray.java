/**
 * 
 * @LeetCode 33. Search in Rotated Sorted Array 
 * @Description Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * @Difficulty Medium 
 * @Tags Binary Search
 * @Author Yi Chen
 * @CreatedTime Jul 7, 2017
 * @LastEditTime Jul 7, 2017
 *
 */

package searchrotarr;

public class SearchInRotatedSortedArray {
	
	public int search1(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		
		int start = 0, end = nums.length - 1;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(nums[mid] == target) {
				return mid;
			}
			if(nums[start] < nums[mid]) {
				if(nums[start] <= target && target <= nums[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			}
			else {
				if(nums[mid] <= target && target <= nums[end]) {
					start = mid;
				}
				else {
					end = mid;
				}
			}
		}
		
		if(nums[start] == target) {
			return start;
		}
		else if(nums[end] == target) {
			return end;
		}
		else {
			return -1;
		}
	}
	
	
	
	
	public int search2(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		int minIndex = findMinInRotateSortedArray(nums);	//	1. firstly, find out the index of minimum number
		
		//	then divide the array into two parts ([0, minIndex - 1], [minIndex, nums.length - 1]) and search the target separately
		int result = binarySearch(nums, 0, minIndex, target);
		if(result != -1) return result;
		return binarySearch(nums, minIndex, nums.length - 1, target);
    }
	
	private int findMinInRotateSortedArray(int[] nums) {
		int start = 0, end = nums.length - 1, last = nums[nums.length - 1];
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(nums[mid] <= last) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
		if(nums[start] <= last) {
			return start;
		}
		else {
			return end;
		}
	}
	
	private int binarySearch(int[] nums, int start, int end, int target) {
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;	
			if(nums[mid] == target) {
				return mid;
			}
			else if(nums[mid] < target) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		
		if(nums[start] == target) {
			return start;
		}
		if(nums[end] == target) {
			return end;
		}
		
		return -1;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,4,5,6,1,2};
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
		System.out.println(s.search1(nums, 6));
		
		
	}

}
