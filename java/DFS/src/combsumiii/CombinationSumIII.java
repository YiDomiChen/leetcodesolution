/**
 * 
 * @LeetCode  216. Combination Sum III
 * @Description: Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Dec 25, 2017
 * @LastEditTime: Dec 25, 2017
 *
 */
package combsumiii;

import java.util.*;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        int[] candidates = new int[9];
        for (int i = 1; i <= 9; i++) {
            candidates[i - 1] = i;
        }
        
        helper(res, candidates, combination, 0, k, n);
        return res;
    }
    
    public void helper(List<List<Integer>> res, int[] candidates, List<Integer> combination, int startIndex, int k, int n) {
        if (combination.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<Integer>(combination));
                return;
            }
        }
        
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > n) break;
            if (i > startIndex && candidates[i - 1] == candidates[i]) {
                continue;
            }
            
            combination.add(candidates[i]);
            helper(res, candidates, combination, i + 1, k, n - candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }
}	
