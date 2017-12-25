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
        // if (prerequisites == null || prerequisites.length == 0) {
        //     return new int[2];
        // }
        
        if (numCourses == 0) {
            return new int[0];
        }
        
        int[] degree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        int count = 0;
        int[] order = new int[numCourses]; 
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                order[count++] = i;
                q.offer(degree[i]);
            }
        }
        
        while (!q.isEmpty()) {
            Integer course = q.poll();
            int size = edges[course].size();
            for (int i = 0; i < size; i++) {
                int tar = (int)edges[course].get(i);
                degree[tar]--;
                if (degree[tar] == 0) {
                    order[count++] = tar;
                    q.offer(tar);
                }
            }
        }
        
        if (count == numCourses) {
            return order;
        } else {
            return new int[0];
        }
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] prerequisites = new int[1][2];
		prerequisites[0] = new int[] {0, 1};
		CourseScheduleII c = new CourseScheduleII();
		c.findOrder(2, prerequisites);
		
	}

}
