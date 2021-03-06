package io.shibd.learn.executorthread;

import java.util.concurrent.*;

/**
 * @Auther: baozi
 * @Date: 2019/4/26 15:16
 * @Description:
 */
public class FutureTest {

    public static void main(String[] args) {
        FutureTest futureTest = new FutureTest();
        futureTest.useExecutor();
//        futureTest.useThread();
    }

    private void useExecutor() {

        SumTask sumTask = new SumTask(1000);
        ExecutorService executor = Executors.newCachedThreadPool();

        FutureTask<Integer> futureTask = new
                FutureTask<Integer>(sumTask);

        executor.submit(futureTask);
        executor.shutdown();

        try {
            System.out.println(Thread.currentThread().getName()+"::useExecutor运行结果" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

//    private void useThread() {
//        SumTask sumTask = new SumTask(500);
//
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(sumTask) {
//            @Override
//            protected void done() {
//                super.done();
//                try {
//                    // 这是在后台线程
//                    System.out.println(Thread.currentThread().getName()+"::useThread运行结果" + get());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Thread io.shibd.learn.thread = new Thread(futureTask);
//        io.shibd.learn.thread.start();
//
//        try {
//            //这是在主线程，会阻塞
//            System.out.println(Thread.currentThread().getName()+"::useThread运行结果" + futureTask.get().getName());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//    }

    class SumTask implements Callable<Integer> {
        int number;

        public SumTask(int num) {
            this.number = num;
        }

        @Override
        public Integer call() throws Exception {

            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000);

            int sum = 0;
            for (int i = 0; i < number; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
