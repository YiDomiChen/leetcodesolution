/**
 * 
 * @LeetCode 51. N-Queens
 * @Description: The n-queens puzzle is the problem of placing n queens 
 * on an n×n chessboard such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Jan 4, 2018
 * @LastEditTime: Jan 4, 2018
 *
 */
package nqueens;

import java.util.*;

public class NQueens {
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		if (n <= 0) {
			return res;
		}
		List<Integer> cols = new ArrayList<>();
		helper(res, cols, n);
		
		return res;
    }
	
	public void helper(List<List<String>> res, List<Integer> cols, int n) {
		if (cols.size() == n) {
			res.add(buildBoard(cols, n));
			
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!isValid(cols, i)) {
				continue;
			}
			cols.add(i);
			helper(res, cols, n);
			cols.remove(cols.size() - 1);
		}
	}
	
	public List<String> buildBoard(List<Integer> cols, int n) {
		List<String> board = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			int colIdx = cols.get(i);
			for (int j = 0; j < n; j++) {
				if (j != colIdx) {
					sb.append(".");
				} else {
					sb.append("Q");
				}
			}
			board.add(sb.toString());
		}
		
		return board;
	}
	
	public boolean isValid(List<Integer> cols, int rowIndex) {
		int colIndex = cols.size();
		for (int i = 0; i < colIndex; i++) {
			if (cols.get(i) == rowIndex) {
				return false;
			}
			if (cols.get(i) + i == rowIndex + colIndex) {
				return false;
			}
			if (cols.get(i) - i == rowIndex - colIndex) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens n = new NQueens();
		List<List<String>> res = n.solveNQueens(4);
		for (List<String> sol : res) {
			for (String row : sol) {
				System.out.println(row);
			}
			System.out.println("======================");
		}
	}

}
