/**
 * 
 * @LeetCode
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Feb 5, 2018
 * @LastEditTime: Feb 5, 2018
 *
 */
package royalnames;

import java.util.*;
import romantoint.*;

public class RoyalNames {
	
	public List<String> royalNames(List<String> royalList) {
		royalList.sort(new Comparator<String>() {
			public int compare(String a, String b) {
				String[] aInfo = a.split(" ");
				String[] bInfo = b.split(" ");
				
				int nameCmp = aInfo[0].compareTo(bInfo[0]);
				
				if (nameCmp != 0) {
					return nameCmp;
				} else {
					RomanToInteger r = new RomanToInteger();
					int aOrder = r.romanToInt(aInfo[1]);
					int bOrder = r.romanToInt(bInfo[1]);
					return aOrder - bOrder;
				}
			}
		});
		
		return royalList;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> royalNames = new ArrayList<>();
		royalNames.add("Phillip VII");
		royalNames.add("Phillip IX");
		royalNames.add("Yai LII");
		royalNames.add("Michael VII");
		royalNames.add("Sanches XII");
		RoyalNames rn = new RoyalNames();
		List<String> res = rn.royalNames(royalNames);
		for (String name : res) {
			System.out.println(name);
		}
		
		
	}

}
