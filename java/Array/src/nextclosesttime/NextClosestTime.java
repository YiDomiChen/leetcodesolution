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

package nextclosesttime;

import java.util.*;

public class NextClosestTime {
	
	public static String nextClosestTime2(String time) {
    	int[] numbers = new int[4];
    	Set<String> candidates = new HashSet<String>();
    	int num1 = time.charAt(0)-'0';
    	int num2 = time.charAt(1)-'0';
    	int num3 = time.charAt(3)-'0';
    	int num4 = time.charAt(4)-'0';
    	numbers[0]= num1;
    	numbers[1]= num2;
    	numbers[2]= num3;
    	numbers[3]= num4;
    	//System.out.println(numbers[0]);
    	for (int i = 0; i < numbers.length; i ++ ){
    		for (int j = 0; j < numbers.length; j ++ ){
    			for (int m = 0; m < numbers.length; m ++ ){
    				for (int n = 0; n < numbers.length; n ++ ){
    					candidates.add(String.valueOf(numbers[i]) + String.valueOf(numbers[j])+":"+ String.valueOf(numbers[m]) + String.valueOf(numbers[n]));
    				}
    			}
    		}
    	}
    	String result = "";
    	int inputHour = Integer.valueOf(time.substring(0, 2));
    	int inputMinute = Integer.valueOf(time.substring(3, 5));
    	if( inputHour > 24 || inputMinute>60 ) {
    		return result ;
    	}
    	
    	int minInterval = Integer.MAX_VALUE;
    	
    	for (String i : candidates) {
    		//System.out.println(i);
    		int diff = 0;
    		int compareHour = Integer.valueOf(i.substring(0, 2));
    		int compareMinute = Integer.valueOf(i.substring(3, 5));
    		if(compareHour > 24 || compareMinute > 60) {
    			continue;
    		}
    		diff = (compareHour - inputHour)*60 + compareMinute - inputMinute;
    		if (diff<= 0){
    			diff = diff + 24*60;
    		}
    		if(diff < minInterval) {
    			minInterval = diff;
    			result = i;
    		}
		
    	}   	
    	return result;
    	
    }
	
	public static void main(String[] args){
		String s = "10:19";
		String t = nextClosestTime2(s);
		System.out.println(t);
		
	}

}
