package maxsubarray;
/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime May 27, 2017
 * @LastEditTime May 27, 2017
 *
 */


public class MaxSubArray {
	
	
	public int maxSubArray(int[] nums) {
		int[] arr = new int[nums.length];
		arr[0] = nums[0];
		
		int maxSum = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			if(arr[i - 1] > 0) {
				arr[i] = arr[i - 1] + nums[i];				
			}
			else {
				arr[i] = nums[i];
			}
			maxSum = Math.max(maxSum, arr[i]);
		}
		
		return maxSum;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		MaxSubArray m = new MaxSubArray();
		int maxSum = m.maxSubArray(arr);
		System.out.println(maxSum);
		
	}

}
