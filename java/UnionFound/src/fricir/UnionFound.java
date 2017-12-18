package fricir;

public class UnionFound {
	
	private int[] sz;
	private int[] id;
	public int count = 0;
	
	
	public UnionFound(int m, int n) {
		id = new int[m * n];
		sz = new int[m * n];
		for(int i = 0; i < m * n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
		
		count = m;
	}
	
	
	private int root(int i) {
		if(id[i] != i) {
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
		
		if(sz[pid] > sz[qid]) {
			id[qid] = pid;
			sz[pid] += sz[qid];
		}
		else {
			id[pid] = qid;
			sz[qid] += sz[pid]; 
		}
		if(count > 1) count--;
	}
}
