package kthlargestelem;

import java.util.*;

public class KthLargestElement {
	
	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<>(k);
		for (int i = 0; i < nums.length; i++) {
			if (pq.size() == k) {
				if (nums[i] > pq.peek()) {
					pq.poll();
					pq.offer(nums[i]);
				}
			} else {
				pq.offer(nums[i]);
			}
		}
		
		return pq.peek();
    }
	
	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4};
		int k = 2;
		KthLargestElement kle = new KthLargestElement();
		System.out.println(kle.findKthLargest(arr, k));
	}

}
