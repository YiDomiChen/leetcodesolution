/**
 * 
 * @LeetCode 421. Maximum XOR of Two Numbers in an Array 
 * @Description Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 2^31.
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 * 
 * Implemented by Trie
 * 
 * @Difficulty Medium
 * @Tags Bit Manipulation, Trie
 * @Author Yi Chen
 * @CreatedTime Jul 1, 2017
 * @LastEditTime Jul 1, 2017
 *
 */

package maxxornum;

public class MaximumXORofTwoNums {

	public class TrieNode {
		public TrieNode[] children;
		
		public TrieNode() {
			children = new TrieNode[2];
		}
		
	}
	
	
	public int findMaximumXOR(int[] nums) {
		if(nums == null || nums.length == 0) {
            return 0;
        }
		
		TrieNode root = new TrieNode();
		for(int i = 0; i < nums.length; i++) {
			int num = nums[i];
			TrieNode curNode = root;
			//	Construct the trie.
			for(int j = 31; j >= 0; j--) {	
				int curBit = (num >>> j) & 1;
				if(curNode.children[curBit] == null) {
					curNode.children[curBit] = new TrieNode();
				}
				curNode = curNode.children[curBit];
			}
		}
		
		int max = Integer.MIN_VALUE;		
		for(int i = 0; i < nums.length; i++) {
			int num = nums[i];
			TrieNode curNode = root;
			int value = 0;
			for(int j = 31; j >= 0; j--) {
				int curBit = (num >>> j) & 1;
				if(curNode.children[curBit ^ 1] != null) {
					value += (1 << j);
					curNode = curNode.children[curBit ^ 1];
				}
				else {
					curNode = curNode.children[curBit];
				}	
			}
			max = Math.max(value, max);
		}
		
		return max;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 10, 5, 25, 2, 8};
		
		MaximumXORofTwoNums m = new MaximumXORofTwoNums();
		System.out.println(m.findMaximumXOR(arr));
	}

}
