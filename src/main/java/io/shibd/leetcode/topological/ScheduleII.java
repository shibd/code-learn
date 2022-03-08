package io.shibd.leetcode.topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. 课程表 II
 *
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是[0,1,2,3] 。另一个正确的排序是[0,2,1,3]
 *
 * @author baozi
 */
public class ScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int input[] = new int[numCourses];
        int result[] = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        // 1. 统计入度
        for (int[] edg : prerequisites) {
            input[edg[0]]++;
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                queue.add(i);
            }
        }

        // 2. 从入度为0的这个节点开始广搜即可
        int index = 0;
        while (!queue.isEmpty()) {
            Integer res = queue.poll();
            result[index++] = res;
            // 这里可以通过邻接表或者邻接矩阵优化查询
            for (int i = 0; i < prerequisites.length; i++) {
                int[] pres = prerequisites[i];
                if (pres[1] == res) {
                    input[pres[0]]--;
                    if (input[pres[0]] == 0) {
                        queue.add(pres[0]);
                    }
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) {

        int input[] = new int[numCourses];
        int result[] = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // 1. 统计入度&构建邻接矩阵
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edg : prerequisites) {
            input[edg[0]]++;
            graph.get(edg[1]).add(edg[0]);
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                queue.add(i);
            }
        }

        // 2. 从入度为0的这个节点开始广搜即可
        int index = 0;
        while (!queue.isEmpty()) {
            Integer res = queue.poll();
            result[index++] = res;
            for (Integer next : graph.get(res)) {
                input[next]--;
                if (input[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }

    public static void main(String[] args) {
        ScheduleII scheduleII = new ScheduleII();
        int[][] prerequisites = new int[][]{{1, 0}};
        int[] order = scheduleII.findOrder2(2, prerequisites);
        for (int i : order) {
            System.out.println(i);
        }
    }

}
