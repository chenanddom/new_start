package chapter20;

import java.util.concurrent.TimeUnit;

public class ThreadDeadLockTest {
    public static void main(String[] args) {


        Object A = new Object();

        Object B = new Object();

        //线程1
        /**
         * ()->{} 此为jdk8新增的新特性  但要求目标接口只有一个抽象方法，而Runnable恰好符合此条件
         */
        Thread thread1 = new Thread(() -> {
            synchronized (A) {
                System.out.println("线程1此时获取锁A");
                try {
                    /**
                     * TimeUnit是一个时间工具类，更好的帮助我们定义休眠时间
                     *TimeUnit.DAYS //天
                     * TimeUnit.HOURS //小时
                     * TimeUnit.MINUTES //分钟
                     * TimeUnit.SECONDS //秒
                     * TimeUnit.MILLISECONDS //毫秒
                     * TimeUnit.NANOSECONDS //毫微秒
                     * TimeUnit.MICROSECONDS //微秒
                     */
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //对象A苏醒之后再去尝试获取锁2
                synchronized (B) {
                    System.out.println("线程1此时获取锁B");
                }
            }
        },"t1");


        //线程2
        Thread thread2 = new Thread(() -> {
            synchronized (B) {
                System.out.println("线程2此时获取锁A");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //对象A苏醒之后再去尝试获取锁2
                synchronized (A) {
                    System.out.println("线程2此时获取锁B");
                }
            }
        },"t2");
        thread1.start();

        thread2.start();
    }
}

