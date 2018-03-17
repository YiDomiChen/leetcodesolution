/**
 * 
 * @LeetCode  56. Merge Intervals
 * @Description: Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18]. 
 * @Difficulty: Medium
 * @Category: Array
 * @Author: Yi Chen
 * @CreatedTime: Mar 12, 2018
 * @LastEditTime: Mar 12, 2018
 *
 */

package mergeintv;

import java.util.*;
import array.utils.*;
public class MergeIntervals {
	
	public class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			// TODO Auto-generated method stub
			if (i1.start != i2.start) {
				return i1.start - i2.start;
			} else {
				return i1.end - i2.end;
			}
		}		
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		LinkedList<Interval> res = new LinkedList<>();
		if (intervals.size() == 0) return res;
		if (intervals.size() == 1) {
			res.add(intervals.get(0));
			
			return res;
		}
		
		Collections.sort(intervals, new IntervalComparator());
		for (Interval inv : intervals) {
			if (res.isEmpty() || res.getLast().end < inv.start) {
				res.add(inv);
			} else {	// there is overlap between merged and start
				res.getLast().end = Math.max(res.getLast().end, inv.end);
			}
			
		}
		
		return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new LinkedList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		
		MergeIntervals mi = new MergeIntervals();
		List<Interval> res = mi.merge(intervals);
		for (Interval inv : res) {
			System.out.println(inv.start + ", " + inv.end);
		}
		
		
	}

}
