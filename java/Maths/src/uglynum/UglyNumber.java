package uglynum;

/**
 * 
 * @LeetCode 263. Ugly Number
 * @Description  Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number. 
 * @Difficulty Easy
 * @Tags Maths
 * @Author Yi Chen
 * @CreatedTime May 31, 2017
 * @LastEditTime May 31, 2017
 *
 */
public class UglyNumber {
	public boolean isUgly(int num) {
		while(num % 2 == 0) num = num / 2;
		while(num % 3 == 0) num = num / 3;
		while(num % 5 == 0) num = num / 5;
		
		return num == 1;
		
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UglyNumber u = new UglyNumber();
		
		System.out.println(u.isUgly(8));

	}

}
