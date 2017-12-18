package numofislands;

public class NumOfIslandsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] grid = {{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}};
		
		NumOfIslands ni = new NumOfIslands();
		System.out.println(ni.numIslands(grid));
	}

}
