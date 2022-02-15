package io.shibd;

import io.shibd.qbank.alibaba.*;
import io.shibd.qbank.aqs.countdownlatch.ReaderResult;
import io.shibd.qbank.aqs.cyclicbarrier.TestCyclicBarrier;
import io.shibd.qbank.cache.CacheDemo;
import io.shibd.qbank.jd.OrderService;
import io.shibd.qbank.linked.*;
import io.shibd.qbank.mianshi1.*;
import io.shibd.qbank.printnumber.*;
import io.shibd.qbank.sort.BigHeapSort;
import io.shibd.qbank.sort.QuitSort;
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
 * 14.堆排序 {@link BigHeapSort}
 * 15.快速排序 {@link QuitSort}
 * 16.(TopK)求数据中前K大数据 {@link TopkCount}
 * 17.(TopK)求数据中前K大数据 {@link TopkCount}
 *
 *
 * ## LeetCode 括号内部是题号
 * 1. (1115)交替打印FooBar {@link io.shibd.leetcode.foobar.FooBar} {@link io.shibd.leetcode.foobar.FooBarLock}
 * 2. (460)LFU缓存 {@link com.baozi.leetcode.lfu.LFUCache}
 * 3. TODO LRU实现
 * 4.
 *
 * ## 学习样例代码
 * 1. BitMap的实现 {@link io.shibd.learn.bitemaps.BitMap}
 * 2. 使用AQS自己实现一个同步锁 {@link io.shibd.learn.aqs.Mutex}
 */
public class Readme {
}
