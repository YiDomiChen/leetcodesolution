/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Oct 2, 2017
 * @LastEditTime Oct 2, 2017
 *
 */

package twopointers;

public class FindDuplicateNumber {
	
	public int findDuplicate_binarysearch(int[] nums) {
        int start = 1, end = nums.length - 1;
		// the range of nums is [1, nums.length]
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (getSmallerNumCount(mid, nums) <= mid) {
				start = mid;	// the duplicate num is bigger than mid
			} else {
				end = mid;	// the duplicate num is smaller than mid
			}
		}
		
		if (getSmallerNumCount(end, nums) >= start) {
		    return end;
		} else {
		    return start;
		}
    }
	
	private int getSmallerNumCount(int num, int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= num) {
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,5,4,3,2,1};
		FindDuplicateNumber f = new FindDuplicateNumber();
		System.out.println(f.findDuplicate_binarysearch(arr));
	}

}
