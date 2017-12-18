package surregions;


/**
 * 
 * @LeetCode 130. Surrounded Regions
 * @Description  Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *  
 * @Difficulty Medium 
 * @Tags: Breath-first Search, Union Found
 * @Author: Yi Chen
 * @CreatedTime: May 18, 2017
 * @LastEditTime: May 18, 2017
 *
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
		int m = board.length;
        int n = board[0].length;
		if (m == 0 || n == 0) return;
        
        UnionFound uf = new UnionFound(m, n, board);
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		int curIdx = i * n + j;
        		if (board[i][j] == 'O') {
        			int lastIdx = -1;
        			if(i - 1 >= 0 && board[i - 1][j] == 'O') {
        				lastIdx = curIdx - n;
        				uf.union(curIdx, lastIdx);
        			}
        			if(j - 1 >= 0 && board[i][j - 1] == 'O') {
        				lastIdx = curIdx - 1;
        				uf.union(curIdx, lastIdx);
        			}
        			
        			if(i == 0) uf.union(curIdx, m * n);
        			if(i == m - 1) uf.union(curIdx, m * n + 1);
        			if(j == 0) uf.union(curIdx, m * n + 2);
        			if(j == n - 1) uf.union(curIdx, m * n + 3);
        		}
        	}
        }
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(board[i][j] == 'O') {
        			int curIdx = i * n + j;
        			if(!uf.connected(curIdx, m * n) && !uf.connected(curIdx, m * n + 1) 
        					&& !uf.connected(curIdx, m * n + 2) && !uf.connected(curIdx, m * n + 3)) {
        				board[i][j] = 'X';
        			}
        		}
        	}
        }
        
    }
}
