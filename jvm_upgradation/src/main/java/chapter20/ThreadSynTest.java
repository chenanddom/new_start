package chapter20;

public class ThreadSynTest {
    private static volatile int i=0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (ThreadSynTest.class){
                while (true) {
                    i++;
                    System.out.println(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1").start();
        new Thread(()->{
            while (true) {
                i++;
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();

    }
}