/**
 * 
 * Template by Jiuzhang
 * 
 * 
 * */

package jiuzhang.sortnsearch;

public class BinarySearch {
	
	public int findPosition(int[] nums, int target) {
		
		if(nums == null || nums.length == 0) {
			return -1;
		}
		
		int start = 0, end = nums.length - 1;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if(nums[mid] == target) {
//				end = mid; //	binary search (first number)
//				start = mid; //	binary search (last number)
				return mid;	//	classical binary search
			}
			else if(nums[mid] < target) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		
		if(nums[start] == target) {
			return start;
		}		
		if(nums[end] == target) {
			return end;
		}
		
		return -1;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2,2,3,3,3,4,5,5,6,6,7,7,8,10};
		BinarySearch b = new BinarySearch();
		System.out.println(b.findPosition(nums, 3));				
	}

}
