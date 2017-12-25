/**
 * 
 * @LeetCode 286. Walls and Gates
 * @Description:  You are given a m x n 2D grid initialized with these three possible values.
 *
 *    -1 - A wall or an obstacle.
 *    0 - A gate.
 *   INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 *
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * For example, given the 2D grid:
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *  0  -1 INF INF
 *
 * After running your function, the 2D grid should be:
 *
 *  3  -1   0   1
 *  2   2   1  -1
 *  1  -1   2  -1
 *  0  -1   3   4
 * @Difficulty: Medium
 * @Category: BFS
 * @Author: Yi Chen
 * @CreatedTime: Dec 24, 2017
 * @LastEditTime: Dec 24, 2017
 *
 */
package wallngates;

import java.util.*;

public class WallAndGates {
	
	public int INF = 2147483647;
    public int OBSTACLE = -1;
    public int GATE = 0;
    
    public class Coordinate {
        public int x;
        public int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] dx = {1, 0, 0, -1};
    public int[] dy = {0, 1, -1, 0};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        
        
        int m = rooms.length, n = rooms[0].length;
        Queue<Coordinate> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    q.offer(new Coordinate(i, j));
                }
            }
        }
        int distance = 0; // here level represented by distance
        while (!q.isEmpty()) {
            int size = q.size();
            distance++;
            for (int i = 0; i < size; i++) {
                Coordinate coord = q.poll();
                for (int j = 0; j < 4; j++) {
                    Coordinate neighborCoord = new Coordinate(coord.x + dx[j], coord.y + dy[j]);
                    if (needUpdate(rooms, neighborCoord)) {
                        q.offer(neighborCoord);
                        rooms[neighborCoord.x][neighborCoord.y] = distance;
                    }
                }
            }
        }
    }
    
    public boolean needUpdate(int[][] rooms, Coordinate coord) {
        if (coord.x < 0 || coord.x >= rooms.length) {
		    return false;
		}
		if (coord.y < 0 || coord.y >= rooms[0].length) {
		    return false;
		}
        
        return rooms[coord.x][coord.y] == INF;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generatedmethod stub
		
		int[][] rooms = {
			{2147483647,-1,0,2147483647}, 
			{2147483647,2147483647,2147483647,-1}, 
			{2147483647,-1,2147483647,-1}, 
			{0,-1,2147483647,2147483647}
		};
		
		WallAndGates wg = new WallAndGates();
		wg.wallsAndGates(rooms);
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				System.out.print("" + rooms[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
