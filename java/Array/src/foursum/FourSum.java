package foursum;

import java.util.*;

/**
 * 
 * @LeetCode 18. 4 Sum
 * @Description Given an array S of n integers, are there elements a, b, c, and d 
 * in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets. 
 * @Difficulty Medium
 * @Tags Array, Hashtable, Two Pointers
 * @Author Yi Chen
 * @CreatedTime May 23, 2017
 * @LastEditTime May 23, 2017
 *
 */
public class FourSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1,0,1,2,-1,-4};
		int target = -1;
		FourSum f = new FourSum();
		List<List<Integer>> res = f.fourSum(arr, target);
		
		for(List<Integer> quadrapuplet : res) {
			for(int num : quadrapuplet) {
				System.out.print(num);
				System.out.print(',');
			}
			System.out.println();
		}
		
		
	}
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		int first, second, third, fourth;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length < 4) return res;
		
		
		Arrays.sort(nums);
		
		for(first = 0; first < nums.length - 3; first++) {
			if(first > 0 && nums[first] == nums[first - 1]) continue;
			int sumthree = target - nums[first];
			for(second = first + 1; second < nums.length - 2; second++) {
				int sumtwo = sumthree - nums[second];
				if(second > first + 1 && nums[second] == nums[second - 1]) continue;
				third = second + 1;
				fourth = nums.length - 1; 
				while(third < fourth) {
					if(nums[third] + nums[fourth] == sumtwo) {
						int tmp_third = nums[third], tmp_fourth = nums[fourth];
						List<Integer> quadruplet = Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]);
						res.add(quadruplet);
						
						while(third < fourth && nums[third] == tmp_third) third++;
						while(third < fourth && nums[fourth] == tmp_fourth) fourth--;
					}
					else if(nums[third] + nums[fourth] < sumtwo) {
						third++;
					}
					else {
						fourth--;
					}
				}
				
			}
			
		}
		
		return res;
    }
	
}
