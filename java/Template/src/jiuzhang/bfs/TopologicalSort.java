/**
 * Template by Jiuzhang
 *
 */
package jiuzhang.bfs;

import java.util.*;

public class TopologicalSort {
	/*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        
        // 1. calculate in-degree of all nodes
        HashMap<DirectedGraphNode, Integer> indegree = calcIndegree(graph);
        // 2. get start nodes (in-degree = 0)
        Queue<DirectedGraphNode> starts = getStartNodes(indegree, graph);
        // 3. get the topological order
        ArrayList<DirectedGraphNode> order = getOrder(starts, indegree);
        
        return order;
    }
    
    public ArrayList<DirectedGraphNode> getOrder(Queue<DirectedGraphNode> starts, HashMap<DirectedGraphNode, Integer> indegree) {
        
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        while (!starts.isEmpty()) {
            DirectedGraphNode node = starts.poll();
            if (!order.contains(node)) {
                order.add(node);
            }
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0) {
                    starts.offer(neighbor);
                    order.add(neighbor);
                }
            }
        }
        
        return order;
    }
    
    public Queue<DirectedGraphNode> getStartNodes(HashMap<DirectedGraphNode, Integer> indegree, ArrayList<DirectedGraphNode> graph) {
        Queue<DirectedGraphNode> starts = new LinkedList<>();
        
        for (DirectedGraphNode node : graph) {
            if (!indegree.containsKey(node)) {
                starts.offer(node);
            }
        }
        
        return starts;
    }
    
    public HashMap<DirectedGraphNode, Integer> calcIndegree(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (!indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, 1);
                } else {
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                }
            }
        }
        
        return indegree;
    }
}
