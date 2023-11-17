package chapter20;

public class ThreadSleepTest {

    public static void main(String[] args) {

        synchronized(ThreadSynTest.class){
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
