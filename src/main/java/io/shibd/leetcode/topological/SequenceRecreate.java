package io.shibd.leetcode.topological;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author baozi
 */
public class SequenceRecreate {


    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {

        // 序列最大值为10^4
        int[] input = new int[10000 + 10];
        List<List<Integer>> graph = new ArrayList<>(10000 + 10);
        for (int i = 0; i < 10000 + 10; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> sequence : sequences) {
            for (int i = 0; i < sequence.size() - 1; i++) {
                graph.get(sequence.get(i)).add(sequence.get(i + 1));
            }
        }
        for (List<Integer> values : graph) {
            for (Integer value : values) {
                input[value]++;
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        queue.add(nums[0]);

        int index = 0;
        while (!queue.isEmpty()) {
            Integer value = queue.poll();

            // 其中一个数字不匹配,则返回失败
            if (nums[index++] != value) {
                return false;
            } else {
                // 置原始序列数字为-1以便判断是否序列完整性
                nums[index - 1] = -1;
            }

            List<Integer> nexts = graph.get(value);
            for (Integer next : nexts) {
                input[next]--;
                if (input[next] == 0) {
                    queue.add(next);
                }
            }

            if (queue.size() > 1) {
                return false;
            }
        }
        return nums[nums.length - 1] == -1;
    }

    public static void main(String[] args) {
        SequenceRecreate sequenceRecreate = new SequenceRecreate();
//        List<List<Integer>> seq = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(2, 3));
//        System.out.println(sequenceRecreate.sequenceReconstruction(new int[]{1, 2, 3}, seq));
//        List<List<Integer>> seq2 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3));
//        System.out.println(sequenceRecreate.sequenceReconstruction(new int[]{1, 2, 3}, seq2));
        List<List<Integer>> seq3 = Arrays.asList(Arrays.asList(5,2,6,3), Arrays.asList(4,1,5,2));
        System.out.println(sequenceRecreate.sequenceReconstruction(new int[]{4,1,5,2,6,3}, seq3));
    }

}
