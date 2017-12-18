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

package arrayparti;

import java.util.Arrays;

public class ArrayPartitionI {

	public int arrayPairSum(int[] nums) {		
		Arrays.sort(nums);
		int sum = 0;
		for(int i = 0; i < nums.length - 1; i = i + 2) {
			sum += nums[i];
		}
		
		return sum;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,5,6,8,9,18,13,10,20};
		ArrayPartitionI a = new ArrayPartitionI();
		int sum = a.arrayPairSum(arr);
		System.out.println(sum);

	}

}
