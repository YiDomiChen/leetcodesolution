/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Jun 5, 2017
 * @LastEditTime Jun 5, 2017
 *
 */

package maxsubarraysum;

public class MaximumSizeSubarraySum {
	
	public int minSubArrayLen(int s, int[] nums) {
		int left = 0;
		int right = 0;
		int result = nums.length + 1;
		int sum = 0;
		
		while(right < nums.length) {
			sum += nums[right];
			
			while(sum >= s) {
				result = Math.min(result, right - left + 1);
				sum -= nums[left];
				left++;
			}
			right++;
			
		}		
		
		return result == nums.length + 1 ? 0 : result;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSizeSubarraySum m = new MaximumSizeSubarraySum();
		int[] nums = {1,2,3,4,5};
		System.out.println(m.minSubArrayLen(11, nums));
	}

}
