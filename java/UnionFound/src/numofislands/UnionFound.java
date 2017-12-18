package numofislands;

public class UnionFound {
	protected int id[];
	protected int sz[];
	public int count = 0;
	
	public UnionFound(int m, int n, char[][] grid) {
//		id = new int[n];
//		sz = new int[n];
//		for(int i = 0; i < n; i++) {
//			id[i] = i;
//			sz[i] = 1;
//		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == '1') count++;
			}
		}
		id = new int[m * n];
		sz = new int[m * n];
		for(int i = 0; i < m * n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	protected int root(int i) {
		while(id[i] != i) {
			id[i] = id[id[i]];
			i = id[i];
		}
		
		return i;
	}
	
	
	public void union(int p, int q) {
		int pid = root(p);
		int qid = root(q);
		
		if(pid == qid) return;
		if(sz[pid] < sz[qid]) {
			id[pid] = qid;
			sz[qid] += sz[pid];
		}
		else {
			id[qid] = pid;
			sz[pid] += sz[qid];
		}
		count--;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
}
