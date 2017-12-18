package numofislandsii;

public class UnionFind {
	private int[] id;
	private int[] sz;
	private int rowNum;
	private int colNum;
	private int count = 0;
	
	public UnionFind(int m, int n) {
		id = new int[m * n + 1];
		sz = new int[m * n + 1];
		rowNum = m;
		colNum = n;
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
		count--;
	}
	
	public int addLand(int x, int y) {
		int index = colNum * x + y + 1; 
		id[index] = index;
		sz[index] = 1;
		count++;
		
		return index;
	}
	
	public int getID(int x, int y) {
		if(x < 0 || y < 0 || x >= rowNum || y >= colNum) return 0;
		else return id[x * colNum + y + 1];
	}
}
