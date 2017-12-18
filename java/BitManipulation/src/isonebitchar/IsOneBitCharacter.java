/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Oct 28, 2017
 * @LastEditTime Oct 28, 2017
 *
 */

package isonebitchar;

public class IsOneBitCharacter {
	
	public boolean isOneBitCharacter(int[] bits) {
        int i;
        for (i = 0; i < bits.length - 1; i++) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
        }
        
        return i == bits.length - 1;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsOneBitCharacter i = new IsOneBitCharacter();
		int[] arr = {1,1,1,0};
		System.out.println(i.isOneBitCharacter(arr));
	}

}
