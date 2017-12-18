/**
 * 
 * @LeetCode 78. Subsets
 * @Description  Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets. 
 * @Difficulty Medium 
 * @Tags Backtracking, Array, Bit Manipulation
 * @Author Yi Chen
 * @CreatedTime Jul 4, 2017
 * @LastEditTime Jul 4, 2017
 *
 */

package subsets;
import java.util.*;

public class Subsets {
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null) {
			return res;
		}
		if(nums.length == 0) {
			res.add(new ArrayList<Integer>());
			return res;
		}
		
		List<Integer> subset = new ArrayList<Integer>();
		subsets(nums, 0, subset, res);
		
		return res;
		
    }
	
	public void subsets(int[] nums, 
			int offset, 
			List<Integer> subset, 
			List<List<Integer>> result) {
		result.add(new ArrayList<Integer>(subset));
		
		for(int i = offset; i < nums.length; i++) {
			subset.add(nums[i]);
			subsets(nums, i + 1, subset, result);
			subset.remove(subset.size() - 1);
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4};
		Subsets s = new Subsets();
		List<List<Integer>> subsets = s.subsets(nums);
		for(List<Integer> l : subsets) {
			for(int i : l) {
				System.out.print(Integer.toString(i) + ",");
			}
			System.out.println();
		}
		
	}

}
