package kthsmallelem;

import java.util.*;

public class KthSmallestElementInSortedMatrix {
	
	public class Node {
		public int x;
		public int y;
		public int value;
		public Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	public int kthSmallest(int[][] matrix, int k) {
		if (matrix == null || matrix[0] == null) {
			return -1;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(k, new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				// TODO Auto-generated method stub
				return a.value - b.value;
			}
		});		
		
		pq.offer(new Node(0, 0, matrix[0][0]));
		int[] dx = {1, 0};
		int[] dy = {0, 1};
		boolean[][] hash = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < k - 1; i++) {
			Node cur = pq.poll();
			for (int j = 0; j < 2; j++) {
				int nextX = cur.x + dx[j];
				int nextY = cur.y + dy[j];
				if (nextX < matrix.length && nextY < matrix[0].length && !hash[nextX][nextY]) {
					hash[nextX][nextY] = true;
					pq.offer(new Node(nextX, nextY, matrix[nextX][nextY]));
				}
			}
		}
		
		return pq.peek().value;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
