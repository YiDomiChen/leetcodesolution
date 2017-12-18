/**
 * 
 * @LeetCode 547. Friend Circles
 * @Description  There are N students in a class. Some of them are friends, while some are not. 
 * Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, 
 * then A is an indirect friend of C. 
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 * 
 * Given a N*N matrix M representing the friend relationship between students in the class. 
 * If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. 
 * And you have to output the total number of friend circles among all the students. 
 * 
 * 
 * url: https://leetcode.com/problems/friend-circles/#/description
 * 
 * @Difficulty Medium 
 * @Tags Union-Found
 * @Author Yi Chen
 * @CreatedTime Jun 27, 2017
 * @LastEditTime Jun 27, 2017
 *
 */

package fricir;

public class FriendCircles {
	
	private int[] get2dIndex(int id, int[][] m) {
		int[] coords = new int[2]; 
		coords[0] = id / m.length;
		coords[1] = id % m.length;
		
		return coords;
	}
	
	private int get1dIndex(int i, int j, int[][] m) {
		return i * m.length + j;	//	m.length
	}
	
	public int findCircleNum(int[][] M) {
		if(M.length == 0 || M[0].length == 0) return 0;
		int m = M.length, n = M[0].length;
		UnionFound uf = new UnionFound(m, n);
		
		for(int i = 0; i < m; i++) {
			for(int j = i + 1; j < n; j++) {
				if(uf.count == 1) return 1;
				
				if(M[i][j] == 1) {
					uf.union(i, j);
				}
			}
		}
		
		return uf.count;
    }
}
