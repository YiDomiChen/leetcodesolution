/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Oct 26, 2017
 * @LastEditTime Oct 26, 2017
 *
 */

package kemptyslot;

import java.util.*;
public class KEmptySlot {
		
	public static int kemptyslots(int[] flowers, int k) {
		//corner case
		if(flowers == null || flowers.length == 0 ) {
			return -1;
		}
		if(flowers.length == k) {
			return 0;
		}
		
		//build tree set
		TreeSet<Integer> intervalSet = new TreeSet<>();
		intervalSet.add(0);
		intervalSet.add(flowers.length + 1);
		
		for(int i = 0; i < flowers.length; i++) {
			int current = flowers[i];
			Integer before = intervalSet.lower(current);
			Integer after = intervalSet.higher(current);
			intervalSet.add(current);
			if (before != null && current - before == k + 1) {
				return i + 1;
			} else if (after != null && after - current == k + 1) {
				return i + 1;
			}		
		}
		return -1;
		
	}
	
	public static void main(String[] args){
		int[] flowers = {4,2,3,1,5};
		int k = 3;
		int res = kemptyslots(flowers,k);
		System.out.println(res);
	}

}
