package mycode.os;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者消费者模型
 *
 * @author pan
 * @create 2020-03-20-16:07
 */
public class PCModel {
    public static void main(String[] args) {
        Model1 m1 = new Model1();
        m1.test();
    }


}

/**
 * 用阻塞队列实现生产者消费者模式，注意必须使用put和take，不然的话队列不会被阻塞
 */
class Model1 {

    private static int capacity = 5;
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(capacity);

    public void test() {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            //模拟每个生产者都能产生10个消息
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep((int)Math.random()*100);
                } catch (InterruptedException e) {
                }
                try {
                    synchronized (this){ //不加这个同步代码块的话，因为线程会随机切换，所以两个输出可能不一样，导致结果混乱不好观察
                        queue.put(Thread.currentThread().getName() + " - " + i);
                        System.out.println(Thread.currentThread().getName() + "生产消息：【" + Thread.currentThread().getName() + " - " + i + "】"+"\n"+"队列现有"+queue.size()+"条消息");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            //模拟每个消费者都能消费10个消息
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep((int)Math.random()*100);
                } catch (InterruptedException e) {
                }
                try {
                    System.out.println(Thread.currentThread().getName() + "消费消息：【" + queue.take() + "】"+"\n"+"队列现有"+queue.size()+"条消息");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
