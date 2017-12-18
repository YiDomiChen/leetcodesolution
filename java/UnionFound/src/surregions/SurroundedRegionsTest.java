package surregions;

import org.junit.Test;

public class SurroundedRegionsTest {

	@Test
	public void test() {
		SurroundedRegions s = new SurroundedRegions();
		
//		char[][] board = {				
//				{'O', 'X', 'O', 'O', 'X', 'X'},
//				{'O', 'X', 'X', 'X', 'O', 'X'},
//				{'X', 'O', 'O', 'X', 'O', 'O'},
//				{'X', 'O', 'X', 'X', 'X', 'X'},
//				{'O', 'O', 'X', 'O', 'X', 'X'},
//				{'X', 'X', 'O', 'O', 'O', 'O'}
//			};
		
		char[][] board = {
			{'X', 'O', 'X', 'X'},
			{'O', 'X', 'O', 'X'},
			{'X', 'O', 'X', 'O'},
			{'O', 'X', 'O', 'X'},
			{'X', 'O', 'X', 'O'},
			{'O', 'X', 'O', 'X'}
		};
		s.solve(board);
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

}
