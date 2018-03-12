from collections import deque

class Solution(object):
    def validTree(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: bool
        """
        if n == 0:
            return True
        if len(edges) != n - 1:
            return False
        
        graph = self.configAdjacency(n, edges)
        queue = deque([0])
        nodes_set = set()
        while queue:
            node = queue.popleft()
            for neighbor in graph.get(node):
                if not neighbor in nodes_set:
                    continue
                nodes_set.add(neighbor)
                queue.append(neighbor)
        
        return n == len(nodes_set)
        
    
    def configAdjacency(self, n, edges):
        graph = {}
        for i in range(n):
            graph[i] = set()
        
        for i in range(len(edges)):
            graph[edges[i][0]].add(edges[i][1])
            graph[edges[i][1]].add(edges[i][0])
        
        return graph

def main():
    

if __name__=="__main__":
    main()