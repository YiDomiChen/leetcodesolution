/**
 * 
 * @LeetCode 444. Sequence Reconstruction
 * @Description: Check whether the original sequence org can be uniquely reconstructed 
 * from the sequences in seqs. The org sequence is a permutation of the integers 
 * from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a 
 * shortest common supersequence of the sequences in seqs 
 * (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). 
 * Determine whether there is only one sequence that can be reconstructed from seqs and 
 * it is the org sequence.
 * @Difficulty: Medium
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Jan 3, 2018
 * @LastEditTime: Jan 3, 2018
 *
 */
package seqrecon;

import java.util.*;

public class SequenceReconstruction {
	
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> edges = new HashMap<>();
        
        for (int i = 0; i < org.length; i++) {
            indegree.put(org[i], 0);
            edges.put(org[i], new HashSet<Integer>());
        }
        
        HashSet<Integer> set = new HashSet<>();
        int n = org.length;
        for (List<Integer> seq : seqs) {
            if (seq.size() == 0) continue;
            if (seq.get(0) <= 0 || seq.get(0) > org.length) return false;
            set.add(seq.get(0));
            for (int i = 1; i < seq.size(); i++) {
                if (seq.get(i) <= 0 || seq.get(i) > org.length) return false;
                set.add(seq.get(i));
                
                if (edges.get(seq.get(i - 1)).add(seq.get(i))) {
                    indegree.put(seq.get(i), indegree.get(seq.get(i)) + 1);
                }
            }
        }
        
        if (set.size() != org.length) {
            return false;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (Integer elem : indegree.keySet()) {
            if (indegree.get(elem) == 0) {
                queue.offer(elem);
            }
        }
        
        int index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() != 1) {
                return false;
            }
            int elem = queue.poll();
            if (org[index++] != elem) {
                return false;
            }
            for (Integer neighbor : edges.get(elem)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        
        return index == org.length;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] org = {1, 2, 3};
		List<List<Integer>> seqs = new ArrayList<>();
		seqs.add(Arrays.asList(1, 2));
		seqs.add(Arrays.asList(1, 3));
		seqs.add(Arrays.asList(2, 3));
		SequenceReconstruction seqRecon = new SequenceReconstruction();
		seqRecon.sequenceReconstruction(org, seqs);
		
	}

}
