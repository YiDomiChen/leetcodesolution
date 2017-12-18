/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Jun 30, 2017
 * @LastEditTime Jun 30, 2017
 *
 */

package rotatearray;

public class RotateArray {
	
	public void rotate(int[] nums, int k) {
		int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
	
	private void reverse(int[] nums, int start, int end) {
		while(start <= end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,8};
		int step = 3;
		RotateArray r = new RotateArray();
		r.rotate(nums, step);
		for(int i : nums) {
			System.out.println(i);
		}
	}

}
