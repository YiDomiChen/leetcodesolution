/**
 * 
 * @LeetCode  47. Permutations II
 * @Description:  Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.

 * For example,
 * [1,1,2] have the following unique permutations:

 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]

 * @Difficulty: Medium
 * @Category: DFS
 * @Author: Yi Chen
 * @CreatedTime: Mar 12, 2018
 * @LastEditTime: Mar 12, 2018
 *
 */
package permutationii;

import java.util.*;

public class PermutationII {
	
	public void helper(List<List<Integer>> res, List<Integer> permutation, int[] nums, int[] visited) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<Integer>(permutation));
            
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i > 0 && nums[i] == nums[i - 1]) && visited[i - 1] == 0) {
                continue;
            }
            visited[i] = 1;
            permutation.add(nums[i]);
            helper(res, permutation, nums, visited);
            permutation.remove(permutation.size() - 1);
            visited[i] = 0;
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        int[] visited = new int[nums.length];
        for ( int i = 0; i < visited.length; i++){
            visited[i] = 0;
        }
        
        helper(res, permutation, nums, visited);
        
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
