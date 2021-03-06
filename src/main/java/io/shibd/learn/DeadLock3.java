package io.shibd.learn;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by baozi on 2018/2/22.
 */
public class DeadLock3 {

    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void deathLock() {
        new Thread() {
            @Override
            public void run() {
                try {
                    lock1.lockInterruptibly();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        lock2.lockInterruptibly();
                        System.out.println(Thread.currentThread().getName() + "...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock2.unlock();
                    }

                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } finally {
                    lock1.unlock();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    lock2.lockInterruptibly();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        lock1.lockInterruptibly();
                        System.out.println(Thread.currentThread().getName() + "...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock1.unlock();
                    }

                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } finally {
                    lock2.unlock();
                }
            }
        }.start();
    }

    public static void main(String[] args) throws InterruptedException {
        deathLock();

        TimeUnit.SECONDS.sleep(2);
        checkDeadLock();
    }

    //??????JMX??????????????????
    public static void checkDeadLock() {
        //??????Thread???MBean
        ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
        //??????????????????????????????????????????id?????????
        long[] deadLockThreadIds = mbean.findDeadlockedThreads();
        System.out.println("---" + deadLockThreadIds);
        if (deadLockThreadIds != null) {
            //?????????????????????????????????
            ThreadInfo[] threadInfos = mbean.getThreadInfo(deadLockThreadIds);
            //??????JVM????????????????????????
            Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
            for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
                for (int i = 0; i < threadInfos.length; i++) {
                    Thread t = entry.getKey();
                    if (t.getId() == threadInfos[i].getThreadId()) {
                        //???????????????????????????
                        t.interrupt();
                        //??????????????????
                        // for (StackTraceElement ste : entry.getValue()) {
                        // // System.err.println("t" + ste.toString().trim());
                        // }
                    }

                }
            }
        }
    }
}
