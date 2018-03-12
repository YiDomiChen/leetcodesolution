/**
 * 
 * @LeetCode  740. Delete and Earn
 * @Description:  Given an array nums of integers, you can perform operations on the array.
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. 
 * After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 * You start with 0 points. Return the maximum number of points you can earn by 
 * applying such operations. 
 * @Difficulty: Medium
 * @Category: Dynamic Programming
 * @Author: Yi Chen
 * @CreatedTime: Feb 5, 2018
 * @LastEditTime: Feb 5, 2018
 *
 */
package deleteandearn;

public class DeleteAndEarn {
	
	public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int num : nums) {
            count[num] += num;
        }
        int take = 0, skip = 0;
        for (int i = 0; i < count.length; i++) {
            int takei = skip + count[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        
        return Math.max(take, skip);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
