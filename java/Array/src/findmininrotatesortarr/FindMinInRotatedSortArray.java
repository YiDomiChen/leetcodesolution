package findmininrotatesortarr;

/**
 * 
 * @LeetCode 153. Find Minimum in Rotated Sorted Array 
 * @Description Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * @Difficulty Medium 
 * @Tags Array, Binary Search
 * @Author Yi Chen
 * @CreatedTime May 28, 2017
 * @LastEditTime May 28, 2017
 *
 */
public class FindMinInRotatedSortArray {
	
	public int findMin(int[] nums) {		
		int left = 0, right = nums.length - 1;
		if(nums[left] <= nums[right]) return nums[left];	//	if not rotate, return the first element
		while (right - left > 1) {	//	loop until locating the minimum (must be on the right hand side)
			int mid = (left + right) / 2;
			if(nums[mid] < nums[left]) {	//	if nums[mid] is less than nums[left], then the minimum must be in (left, mid]
				right = mid;
			}
			else {	//	otherwise the minimum is in (mid, right]
				left = mid;
			}						
		}
		
		return nums[right];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,3};
		FindMinInRotatedSortArray f = new FindMinInRotatedSortArray();
		int i = f.findMin(arr);
		System.out.println(i);
	}

}
