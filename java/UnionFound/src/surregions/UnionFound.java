package surregions;

public class UnionFound {
	
	private int id[];
	private int sz[];
	
	public UnionFound(int m, int n, char[][] board) {								
		id = new int[m * n + 4];						
		sz = new int[m * n + 4];
		for(int i = 0; i < m * n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
		id[m * n] = m * n;
		id[m * n + 1] = m * n + 1;
		id[m * n + 2] = m * n + 2;
		id[m * n + 3] = m * n + 3;
	}
	
	private int root(int i) {
		while(id[i] != i) {
			id[i] = id[id[i]];
			i = id[i];
		}
		
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
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
	}
}
