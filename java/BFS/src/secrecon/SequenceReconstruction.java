/**
 * 
 * @LeetCode 444. Sequence Reconstruction
 * @Description: Check whether the original sequence org can be uniquely reconstructed 
 * from the sequences in seqs. The org sequence is a permutation of the integers from 
 * 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence
 * of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs 
 * are subsequences of it). Determine whether there is only one sequence that can be 
 * reconstructed from seqs and it is the org sequence.
 * 
 * Example 1:

 * Input:
 * org: [1,2,3], seqs: [[1,2],[1,3]]
 * Output:
 * false

 * Explanation:
 * [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.

 * Example 2:
 * Input:
 * org: [1,2,3], seqs: [[1,2]]
 * Output:
 * false

 * Explanation:
 * The reconstructed sequence can only be [1,2].

 * Example 3:
 * Input:
 * org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
 * Output:
 * true

 * Explanation:
 * The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].

 * Example 4:
 * Input:
 * org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
 * Output:
 * true

 * 
 * 
 * @Difficulty: Medium 
 * @Category: BFS, Topological Sort
 * @Author: Yi Chen
 * @CreatedTime: Dec 24, 2017
 * @LastEditTime: Dec 24, 2017
 *
 */
package secrecon;

import java.util.*;

public class SequenceReconstruction {
	/**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {        
        HashMap<Integer, Integer> degree = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> edges = new HashMap<>();
        
        for (int i = 0; i < org.length; i++) {
            degree.put(org[i], 0);
            edges.put(org[i], new HashSet<Integer>());
        }
        
        int count = 0;
        for (int i = 0; i < seqs.length; i++) {
            count += seqs[i].length;
            if (seqs[i].length >= 1 && (seqs[i][0] <= 0 || seqs[i][0] > org.length)) {
                return false;
            }
            for (int j = 1; j < seqs[i].length; j++) {
                if (seqs[i][j] <= 0 || seqs[i][j] > org.length) {
                    return false;
                }
                
                degree.put(seqs[i][j], degree.get(seqs[i][j]) + 1);
                edges.get(seqs[i][j - 1]).add(seqs[i][j]);
            }
        }
        if (count < org.length) {
            return false;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < org.length; i++) {
            if (degree.get(org[i]) == 0) {
                q.offer(org[i]);
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            if (size > 1) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                Integer sequence = q.poll();
                for (Integer neighbor : edges.get(sequence)) {
                    degree.put(neighbor, degree.get(neighbor) - 1);
                    if (degree.get(neighbor) == 0) {
                        q.offer(neighbor);
                    }
                }
            }
            
        }
        
        return true;
    }
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] seqs = {};
		int[] org = {1};
		SequenceReconstruction sr = new SequenceReconstruction();
		System.out.println(sr.sequenceReconstruction(org, seqs));
		
	}
}
