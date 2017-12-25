/**
 * 
 * @LeetCode 207. Course Schedule
 * @Description:  There are a total of n courses you have to take, 
 * labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first 
 * take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, 
 * is it possible for you to finish all courses? 
 * 
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. 
 * So it is possible.
 * 
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
 * and to take course 0 you should also have finished course 1. 
 * So it is impossible.
 * 
 * 
 * @Difficulty: Medium  
 * @Category: BFS, Topological Sort
 * @Author: Yi Chen
 * @CreatedTime: Dec 24, 2017
 * @LastEditTime: Dec 24, 2017
 *
 */
package courseschedule;

import java.util.*;

public class CourseSchedule {
	/*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] indegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int preCourse = queue.poll();
            count++;
            int size = edges[preCourse].size();
            for (int i = 0; i < size; i++) {
                int tar = (int)edges[preCourse].get(i);
                indegree[tar]--;
                if (indegree[tar] == 0) {
                    queue.offer(tar);
                }
            }
            
        }
        
        return count == numCourses;
    }
}
