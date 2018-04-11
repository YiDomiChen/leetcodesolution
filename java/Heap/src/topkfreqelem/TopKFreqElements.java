package topkfreqelem;

import java.util.*;
import java.util.Map.Entry;

public class TopKFreqElements {
	
	public class Tuple {
		public int item;
		public int count;
		public Tuple(int item, int count) {
			this.item = item;
			this.count = count;
		}
		
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hash = new HashMap<>();
		for (int num : nums) {
			if (hash.containsKey(num)) {
				hash.put(num, hash.get(num) + 1);
			} else {
				hash.put(num, 1);
			}
		}
		
		
		
		PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>() {
			@Override
			public int compare(Tuple t1, Tuple t2) {
				if (t1.count != t2.count) {
					return t2.count - t1.count;
				} else {
					return t1.item - t2.item;
				}
			}
		});
		for (Entry<Integer, Integer> entry : hash.entrySet()) {
			Tuple tuple = new Tuple(entry.getKey(), entry.getValue()); 
			pq.offer(tuple);
		}
		
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(pq.poll().item);
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
