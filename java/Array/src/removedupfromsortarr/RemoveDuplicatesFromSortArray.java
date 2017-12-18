

package removedupfromsortarr;
/**
 * 
 * @LeetCode 26. Remove Duplicates from Sorted Array 
 * @Description  Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory. 
 * 
 * For example,
 * Given input array nums = [1,1,2], 
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
 * It doesn't matter what you leave beyond the new length.
 * 
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime May 28, 2017
 * @LastEditTime May 28, 2017
 *
 */
public class RemoveDuplicatesFromSortArray {
	
	
	public int removeDuplicates(int[] nums) {
		int index = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i - 1]) {
				;
			}
			else {
				nums[index++] = nums[i];
			}
			
		}
		
		return index;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,1,2,3,3,3,4,5,5,5,6,6,7,8,8};
		RemoveDuplicatesFromSortArray r = new RemoveDuplicatesFromSortArray();
		int length = r.removeDuplicates(arr);
		System.out.println(length);
		
		for(int elem : arr) {
			System.out.print(String.valueOf(elem) + ",");
		}
	}

}
