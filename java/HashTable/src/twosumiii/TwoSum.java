
package twosumiii;

import java.util.HashMap;


/**
 * 
 * @LeetCode 170. Two Sum III - Data structure design
 * @Description Design and implement a TwoSum class. It should support the following operations: add and find.
 * <br />
 * add - Add the number to an internal data structure.
 * <br />
 * find - Find if there exists any pair of numbers which sum is equal to the value. 
 * 
 * @Difficulty Easy
 * @Tags Hashtable, Design
 * @Author Yi Chen
 * @CreatedTime May 19, 2017
 * @LastEditTime May 19, 2017
 *
 */
public class TwoSum {
	
	private HashMap<Integer, Integer> map;		
	/** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
//    	map.put(number, map.getOrDefault(number, 1) + 1);
        map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {    	    	
        for (Integer num : map.keySet()) {
        	if ((map.containsKey(value - num) && value - num != num) || (value - num == num && map.get(num) > 1)) return true;
        }
        
        return false;
    }
}
