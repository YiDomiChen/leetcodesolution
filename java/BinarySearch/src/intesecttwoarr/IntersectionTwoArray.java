package intesecttwoarr;

import java.util.*;

public class IntersectionTwoArray {

	public int[] intersection1(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for (int i1 : nums1) {
			set.add(i1);
		}
		
		Set<Integer> resSet = new HashSet<>();
		for (int i2 : nums2) {
			if (set.contains(i2)) {
				resSet.add(i2);
			}
		}
		
		int[] res = new int[resSet.size()];
		int idx = 0;
		for (int num : resSet) {
			res[idx++] = num;
		}
		
		return res;
    }
	
	public int[] intersection2(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for (int i1 : nums1) {
			set.add(i1);
		}
		
		Set<Integer> resSet = new HashSet<>();
		for (int i2 : nums2) {
			if (set.contains(i2)) {
				resSet.add(i2);
			}
		}
		
		int[] res = new int[resSet.size()];
		int idx = 0;
		for (int num : resSet) {
			res[idx++] = num;
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
