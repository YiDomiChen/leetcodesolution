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

package thirdmaxnum;

import java.util.*;

public class ThirdMaximumNumber {
	
	public int thirdMax(int[] nums) {
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				if(i1 > i2) return -1;
				else if(i1 < i2) return 1;
				else return 0;
			}
		});
		
		for(int i = 0; i < nums.length; i++) {
			queue.add(nums[i]);
		}
		
		Integer max = queue.peek();
		Integer orimax = max;
		int index = 0;
		for(int i = 1; i < 3; i++) {
			Integer num = queue.poll();
			if(num != null) {
				if(num == max) {
					i--;
				}
				else {
					index++;
				}
				max = num;
			}
		}
		
		return index >= 2 ? max : orimax;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThirdMaximumNumber t = new ThirdMaximumNumber();
		
		int[] nums = {-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
		System.out.println(t.thirdMax(nums));
		
	}

}
