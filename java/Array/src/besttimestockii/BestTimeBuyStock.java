

package besttimestockii;

/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime May 27, 2017
 * @LastEditTime May 27, 2017
 *
 */
public class BestTimeBuyStock {

	public int maxProfit(int[] prices) {
		if(prices.length < 2) return 0;
		
		int total = 0;
		int sofarMin = prices[0];
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] < prices[i - 1]) {
				total += prices[i - 1] - sofarMin;
				sofarMin = prices[i];
			}
			if(i == prices.length - 1 & prices[i] > sofarMin) {
				total += prices[i] - sofarMin;
			}	
		}		
		return total;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7, 1, 5, 3, 6, 4, 1, 3, 2};
		BestTimeBuyStock b = new BestTimeBuyStock();
		System.out.println(b.maxProfit(prices));
	}

}
