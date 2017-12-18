/**
 * 
 * @LeetCode 121. Best Time to Buy and Sell Stock 
 * @Description Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * @Difficulty Easy
 * @Tags Arrays, Dynamic Programming
 * @Author Yi Chen
 * @CreatedTime May 27, 2017
 * @LastEditTime May 27, 2017
 *
 */

package besttimestock;

public class BuySellStock {

	public int maxProfit(int[] prices) {
		
		int sofarMin = prices[0];
		int maxProfit = 0;
		
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] < sofarMin) {
				sofarMin = prices[i];
			}
			else {
				maxProfit = Math.max(maxProfit, prices[i] - sofarMin);
			}
		}
		
		return maxProfit;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7, 1, 5, 3, 6, 4};
		BuySellStock b = new BuySellStock();
		System.out.println(b.maxProfit(prices));
		
	}

}
