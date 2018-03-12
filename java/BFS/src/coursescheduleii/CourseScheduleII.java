/**
 * 
 * @LeetCode 210. Course Schedule II
 * @Description: TODO
 * @Difficulty: Medium
 * @Category: Topological Sort
 * @Author: Yi Chen
 * @CreatedTime: Dec 24, 2017
 * @LastEditTime: Dec 24, 2017
 *
 */
package coursescheduleii;

import java.util.*;

public class CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        
        
        HashMap<Integer, Integer> indegrees = calcIndegree(numCourses, prerequisites);
        HashMap<Integer, ArrayList<Integer>> adjacency = getAdjacencyMatrix(numCourses, prerequisites);
        Queue<Integer> queue = getStartCourse(indegrees);
        
        ArrayList<Integer> res = getOrder(queue, indegrees, adjacency);
        
        if (res.size() == numCourses) {
            int[] order = new int[numCourses];
            int index = 0;
            for (int course : res) {
                order[index++] = course;
            }
            
            return order;
        } else {
            return new int[0];
        }
        
    }
    
    public ArrayList<Integer> getOrder(Queue<Integer> queue, HashMap<Integer, Integer> indegrees, HashMap<Integer, ArrayList<Integer>> adjacency) {
        ArrayList<Integer> res = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (!res.contains(course)) {
                res.add(course);
            }
            for (Integer neighbor : adjacency.get(course)) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    res.add(neighbor);
                }
            }
        }
        
        return res;
    }
    
    public Queue<Integer> getStartCourse(HashMap<Integer, Integer> indegrees) {
        Queue<Integer> queue = new LinkedList<>();
        for (Integer course : indegrees.keySet()) {
            if (indegrees.get(course) == 0) {
                queue.offer(course);
            }
        }
        
        return queue;
    }
    
    public HashMap<Integer, Integer> calcIndegree(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, 0);
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int v = prerequisites[i][0];
            map.put(v, map.get(v) + 1);
        }
        
        return map;
    }
    
    public HashMap<Integer, ArrayList<Integer>> getAdjacencyMatrix(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            
            map.get(u).add(v);
//            map.get(v).add(u);
        }
        
        return map;
        
    }
	
//	public int[] findOrder(int numCourses, int[][] prerequisites) {
//        // if (prerequisites == null || prerequisites.length == 0) {
//        //     return new int[2];
//        // }
//        
//        if (numCourses == 0) {
//            return new int[0];
//        }
//        
//        int[] degree = new int[numCourses];
//        List[] edges = new ArrayList[numCourses];
//        
//        for (int i = 0; i < numCourses; i++) {
//            edges[i] = new ArrayList<Integer>();
//        }
//        
//        for (int i = 0; i < prerequisites.length; i++) {
//            degree[prerequisites[i][0]]++;
//            edges[prerequisites[i][1]].add(prerequisites[i][0]);
//        }
//        
//        int count = 0;
//        int[] order = new int[numCourses]; 
//        Queue<Integer> q = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (degree[i] == 0) {
//                order[count++] = i;
//                q.offer(degree[i]);
//            }
//        }
//        
//        while (!q.isEmpty()) {
//            Integer course = q.poll();
//            int size = edges[course].size();
//            for (int i = 0; i < size; i++) {
//                int tar = (int)edges[course].get(i);
//                degree[tar]--;
//                if (degree[tar] == 0) {
//                    order[count++] = tar;
//                    q.offer(tar);
//                }
//            }
//        }
//        
//        if (count == numCourses) {
//            return order;
//        } else {
//            return new int[0];
//        }
//    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		
		CourseScheduleII c = new CourseScheduleII();
		c.findOrder(4, prerequisites);
		
	}

}
