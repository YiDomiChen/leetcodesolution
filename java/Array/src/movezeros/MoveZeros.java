package movezeros;

/**
 * 
 * @LeetCode 283. Move Zeroes
 * @Description Given an array nums, write a function to move all 0's 
 * to the end of it while maintaining the relative order of the non-zero elements. 
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]. 
 * 
 * Note: 
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of operations.
 * 
 * @Difficulty: Easy
 * @Tags: Array, Two Pointers
 * @Author: Yi Chen
 * @CreatedTime: May 19, 2017
 * @LastEditTime: May 19, 2017
 *
 */
public class MoveZeros {
	public void moveZeroes(int[] nums) {                
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != 0) {
        		nums[index] = nums[i];
        		index++;
        	}
        }
        for(int i = index; i < nums.length; i++) {
        	nums[i] = 0;
        }
    }
	
	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 3, 12, 9, 0, 90, 9, 0, 11};
		
		MoveZeros m = new MoveZeros();
		m.moveZeroes(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		
	}
}
