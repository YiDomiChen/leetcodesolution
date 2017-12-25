/**
 * 
 * @LeetCode
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Dec 24, 2017
 * @LastEditTime: Dec 24, 2017
 *
 */
package shortdistbuild;

import java.util.*;

public class ShortestDistanceFromAllBuildings {
	public class Coordinate {
		int x, y;
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public int EMPTY = 0;
	public int HOUSE = 1;
	public int WALL = 2;
	
	private int[][] grid;
	private int m, n;
	private int[] dx = {1, 0, 0, -1}; 
	private int[] dy = {0, 1, -1, 0};
	/**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
    	if (grid == null || grid.length == 0 || grid[0].length == 0) {
    		return -1;
    	}
    	
    	this.grid = grid;
    	n = grid.length;
    	m = grid[0].length;
    	
    	List<Coordinate> housesCoord = getCoordinates(HOUSE);
    	int[][][] distance = new int[n][m][housesCoord.size()]; 
    	for (int i = 0; i < n; i++) {
    	    for (int j = 0; j < m; j++) {
    	        for (int k = 0; k < housesCoord.size(); k++) {
    	            distance[i][j][k] = Integer.MAX_VALUE;
    	        }
    	    }
    	}
    	
    	for (int i = 0; i < housesCoord.size(); i++) {
    	    bfs(housesCoord.get(i), i, distance);
    	}
    	
    	int smallest = Integer.MAX_VALUE;
    	for (int i = 0; i < n; i++) {
    	    for (int j = 0; j < m; j++) {
    	        int curDis = 0;
    	        boolean canBuild = true;
    	        for (int k = 0; k < housesCoord.size(); k++) {
    	            if (distance[i][j][k] == Integer.MAX_VALUE) {
    	                canBuild = false;
    	                break;
    	            } else {
    	                curDis += distance[i][j][k];
    	            }
    	        }
    	        if (canBuild) {
    	            smallest = Math.min(smallest, curDis);
    	        }
    	    }
    	}
    	
    	return smallest == Integer.MAX_VALUE ? -1 : smallest;
    }
	
    private List<Coordinate> getCoordinates(int type) {
        List<Coordinate> coords = new ArrayList<>();
    	for (int i = 0; i < n; i++) {
    	    for (int j = 0; j < m; j++) {
    	        if (grid[i][j] == type) {
    	            Coordinate coord = new Coordinate(i, j);
    	            coords.add(coord);
    	        }
    	    }
    	}
    	
    	return coords;
    }
    
    private boolean inBound(Coordinate coord) {
    	if (coord.x < 0 || coord.x >= n) {
    		return false;
    	}
    	if (coord.y < 0 || coord.y >= m) {
    		return false;
    	}
    	
    	return grid[coord.x][coord.y] == EMPTY;
    }
    
    private void bfs(Coordinate house, int houseIndex, int[][][] distance) {
    	Queue<Coordinate> queue = new LinkedList<>();
    	queue.offer(house);
    	int step = 0;
    	boolean[][] visited = new boolean[n][m];
    	while (!queue.isEmpty()) {
    	    int size = queue.size();
    	    step++;
    	    for (int i = 0; i < size; i++) {
    	        Coordinate curPos = queue.poll();
    	        for (int j = 0; j < 4; j++) {
    	            Coordinate newPos = new Coordinate(curPos.x + dx[j], curPos.y + dy[j]);
    	            if (inBound(newPos) && !visited[newPos.x][newPos.y]) {
    	                queue.offer(newPos);
    	                distance[newPos.x][newPos.y][houseIndex] = step;
    	                visited[newPos.x][newPos.y] = true;
    	            }
    	        }
    	    }
    	}
    	
    }
}
