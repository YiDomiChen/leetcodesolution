
package gvalidtree;

public class UnionFind {
	
	private int[] id;
	private int[] sz;
	private int count;
	
	public UnionFind(int n) {
		id = new int[n];
		sz = new int[n];
		count = n;
		
		for(int i = 0; i < n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
		
	}
	
	public int getCount() {
		return this.count;
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
		int pid = root(p), qid = root(q);
		if(pid == qid) return;
		if(sz[pid] > sz[qid]) {
			id[qid] = pid;
			sz[pid] += sz[qid];
		}
		else {
			id[pid] = qid;
			sz[qid] += sz[pid];
		}
		count--;
	} 	
}
