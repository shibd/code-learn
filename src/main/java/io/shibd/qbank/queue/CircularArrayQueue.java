package io.shibd.qbank.queue;

/**
 * @Auther: baozi
 * @Date: 2019/3/4 13:51
 * @Description:
 */
public class CircularArrayQueue {

    private Object[] queue;
    private int n;

    private int head = 0;
    private int tail = 0;

    public CircularArrayQueue(int n) {
        queue = new Object[n];
        this.n = n;
    }

    public boolean enqueue(Object object) {
        if((tail + 1) % n == head) {
            return false;
        }
        queue[tail] = object;
        tail = (tail + 1) % n;
        return true;
    }

    public Object dequeue() {

        // 队列中没有数据
        if (head == tail) {
            return null;
        }

        Object ret = queue[head];
        head = (head + 1) % n;

        return ret;
    }

    public static void main(String[] args) {

        CircularArrayQueue queue = new CircularArrayQueue(5);

        for (int i = 0; i < 200; i++) {
            boolean enqueue = queue.enqueue(i + "");
            if (!enqueue) {
                Object dequeue = queue.dequeue();
                System.out.println("出队" + dequeue);
            } else {
                System.out.println("入队" + i);
            }
        }
    }

}
