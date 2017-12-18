/**
 * 
 * @LeetCode
 * @Description TODO
 * @Difficulty 
 * @Tags 
 * @Author Yi Chen
 * @CreatedTime Jun 28, 2017
 * @LastEditTime Jun 28, 2017
 *
 */

package numofconningra;

public class NumOfConnCompInGraph {
	public int countComponents(int n, int[][] edges) {
        UnionFound uf = new UnionFound(n);
        
        for(int[] edge : edges) {
        	if(!uf.connected(edge[0], edge[1])) {
        		uf.union(edge[0], edge[1]);
        	}
        }
        
        
        return uf.getCount();
    }
}
