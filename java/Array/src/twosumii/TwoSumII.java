package twosumii;

/**
 * 
 * @LeetCode 167. Two Sum II - Input array is sorted 
 * @Description: Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * 
 * @Difficulty: Easy
 * @Tags: Array, Two Pointers, Binary Search
 * @Author: Yi Chen
 * @CreatedTime: May 19, 2017
 * @LastEditTime: May 19, 2017
 *
 */
public class TwoSumII {

	public int[] twoSum(int[] numbers, int target) {		
		int[] res = new int[2];
		int left = 0;
		int right = numbers.length - 1;
		while(true) {
			if(numbers[left] + numbers[right] > target) {
				right--;
			}
			else if(numbers[left] + numbers[right] < target) {
				left++;
			}
			else {
				res[0] = left + 1;
				res[1] = right + 1;
				break;
			}			
		}		
		return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		TwoSumII t = new TwoSumII();
		int[] res = t.twoSum(nums, 9);
		System.out.println(Integer.toString(res[0]) + ", " + Integer.toString(res[1]));
	}

}
