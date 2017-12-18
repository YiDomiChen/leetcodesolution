

package removeelem;

/**
 * 
 * @LeetCode 27. Remove Element 
 * @Description Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @Difficulty Easy
 * @Tags Array, Two Pointers
 * @Author Yi Chen
 * @CreatedTime May 28, 2017
 * @LastEditTime May 28, 2017
 *
 */
public class RemoveElement {
	
	public int removeElement(int[] nums, int val) {
		int index = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != val) {
				nums[index++] = nums[i];
			}
		}
		
		return index;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {1,3,5,1,2,3,4,5};
		RemoveElement r = new RemoveElement();
		int length = r.removeElement(array, 5);
		System.out.println(length);
		
		for(int elem : array) {
			System.out.print(String.valueOf(elem) + ",");
		}
		
	}

}
