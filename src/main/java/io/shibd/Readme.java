package io.shibd;

import io.shibd.leetcode.lfu.LFUCache;
import io.shibd.leetcode.string.CountPalindromeSubstr;
import io.shibd.leetcode.lru.LRUCache;
import io.shibd.leetcode.string.LongPalindromeSub;
import io.shibd.qbank.alibaba.*;
import io.shibd.qbank.aqs.countdownlatch.ReaderResult;
import io.shibd.qbank.aqs.cyclicbarrier.TestCyclicBarrier;
import io.shibd.qbank.cache.CacheDemo;
import io.shibd.qbank.jd.OrderService;
import io.shibd.qbank.linked.*;
import io.shibd.qbank.mianshi1.*;
import io.shibd.qbank.printnumber.*;
import io.shibd.qbank.queue.ArrayQueue;
import io.shibd.qbank.stack.ArrayStack;
import io.shibd.qbank.topk.TopkCount;

/**
 * ## 题目目录
 * 1. 检查程序内存泄漏 {@link MyStack}
 * 2. 对象初始化打印顺序 {@link Hello}
 * 3. 两个有序的整数数组求交集 {@link SortArrayIntersection} {@link SortArrayIntersection2}
 * 4. N个线程等待1个线程的计算结果 {@link ReaderResult}
 * 5. CyclicBarrier使用样例代码 {@link TestCyclicBarrier}
 * 6. 使用两个线程,一个线程打印1,3,5..另一个打印2,4,6。要求顺序打印从1~100 {@link PrintNumber} {@link PrintNumberThree}
 * 7. 用读写锁实现一个缓存系统,要求读的时候可以并发...具体参考类 {@link CacheDemo}
 * 8. 客户下单服务, 三个工作(验证，信用，贷款记录)并发执行，如果一个失败，则立即返回失败（京东面试题） {@link OrderService}
 * 9. 检测链表是否有环 {@link CheckRingLinked}
 * 10.求链表中间节点 {@link MiddleNodeLinked}
 * 11.删除链表倒数第N个节点 {@link RemoveNLinked}
 * 12.翻转链表 {@link ReversalLinked}
 * 13.编写两个线程，一个线程打印1~25，另一个线程打印字母A~Z，打印顺序为12A34B56C……5152Z {@link ThreadOne}{@link ThreadTwo}{@link ThreadThree}
 * 14. (TopK)求数据中前K大数据 {@link TopkCount}
 * 17.手写一个队列 {@link ArrayQueue}
 * 18.手写一个栈 {@link ArrayStack}
 * 19.二分查找 (查找小于给定值的最大元素) {@link io.shibd.learn.BinarySearch}
 *
 *
 * ## LeetCode 括号内部是题号
 * 1. (1115)交替打印FooBar {@link io.shibd.leetcode.foobar.FooBar} {@link io.shibd.leetcode.foobar.FooBarLock}
 * 2. (460)LFU缓存 {@link LFUCache}
 * 3. (146)LRU缓存 {@link LRUCache}
 * 4. (912)排序数组 快速排序{@link io.shibd.leetcode.sort.quick.Solution} 归并排序{@link io.shibd.leetcode.sort.merge.Solution}
 * 5. (23)合并K个升序链表 {@link io.shibd.leetcode.mergek.Solution}
 * 6. (215)数组中的第K个最大元素 {@link io.shibd.leetcode.findk.Solution}
 * 7. 剑指 Offer 55 - I. 二叉树的深度 {@link io.shibd.leetcode.binarytree.MaxDepthBinaryTree}
 * 8. 面试题32 - I. 从上到下打印二叉树 {@link io.shibd.leetcode.binarytree.LevelOrderBinaryTree}
 * 8. 剑指 Offer 33. 校验二叉搜索树的后序遍历序列 {@link io.shibd.leetcode.binarytree.VerifyPostorder}
 * 9. 230. 二叉搜索树中第K小的元素(中序遍历) {@link io.shibd.leetcode.binarytree.KthSmallest}
 * 10. 1206. 手写一个跳表 {@link io.shibd.leetcode.skiplist.Skiplist}
 * 11. 51. N 皇后 {@link io.shibd.leetcode.call8queens.Solution}
 * 12. 70. 爬楼梯问题(动态规划) {@link io.shibd.leetcode.climbstairs.Solution}
 * 13. 1143. 最长公共子序列（运行main函数查看动态二维表） {@link io.shibd.leetcode.longestcomsubstr.Solution}
 * 14. 5. 最长回文子串 {@link LongPalindromeSub}
 * 15. 647. 回文子串数量 {@link CountPalindromeSubstr}
 * 16. 214. TODO 最短回文串 {@link io.shibd.leetcode.string.ShortsPalindrome}
 * 17. 131. 分割回文串 {@link io.shibd.leetcode.string.PartitionPalindrome}
 * 18. 416. 分割等和子集 {@link io.shibd.leetcode.dp.CallPartition}
 * 19. 1049. 最后一块石头的重量 II {@link io.shibd.leetcode.dp.LastStoneWeightII}
 * 20. 0-1背包带价值 TODO leetcode没有找到对应题目 {@link io.shibd.leetcode.dp.Knapsack01}
 * 21. 322. 零钱兑换 完全背包 {@link io.shibd.leetcode.dp.CoinChange}
 * 22. 210. (拓扑排序)课程表 II {@link io.shibd.leetcode.topological.ScheduleII}
 *
 *
 * ## 学习样例代码
 * 1. BitMap的实现 {@link io.shibd.learn.bitemaps.BitMap}
 * 2. 使用AQS自己实现一个同步锁 {@link io.shibd.learn.aqs.Mutex}
 *
 *
 * ## 学习资料:
 * 背包问题: https://www.bilibili.com/video/BV1C7411K79w?p=1
 */
public class Readme {
}
