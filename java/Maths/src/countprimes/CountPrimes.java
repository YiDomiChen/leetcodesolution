/**
 * 
 * @LeetCode 204. Count Primes
 * @Description: Count the number of prime numbers less than a non-negative number, n.
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Feb 23, 2017
 * @LastEditTime: Feb 23, 2017
 *
 */

package countprimes;
import java.util.*;

public class CountPrimes {

	/**
	 * Get the detailed primes less than n
	 * The Seive of Eratosthenes Method
	 * 
	 * */
	public List<Integer> getPrimes(int n) {
		boolean[] prime = new boolean[n + 1];
		for(int i = 2; i <= n; i++) {
			prime[i] = true;
		}
		
		for(int i = 2; i * i <= n; i++) {
			if(prime[i]) {
				for(int j = i * i; j <= n; j = j + i) {
					prime[j] = false;
				}
			}
		}
		
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 2; i < n; i++) {
			if(prime[i]) {
				res.add(i);
			}
		}
		
		return res;		
	}
	
	public int countPrimes(int n) {
		boolean[] prime = new boolean[n + 1];
		for(int i = 2; i <= n; i++) {
			prime[i] = true;
		}
		
		for(int i = 2; i * i <= n; i++) {
			if(prime[i]) {
				for(int j = i * i; j <= n; j = j + i) {
					prime[j] = false;
				}
			}
		}
		
		int num = 0;
		for(int i = 2; i < n; i++) {
			if(prime[i]) {
				num++;
			}
		}
		
		return num;		
	}
}
