package chapter13;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 *
 */
public class StringInternTest3 {
    private static final int MAX_COUNT = 1000 * 10000;
    private static final String[] arr = new String[MAX_COUNT];

    public static void main(String[] args) {
        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_COUNT; i++) {
//            arr[i] = new String(String.valueOf(data[i % data.length]));//耗费时间：耗费时间:3646

            arr[i] = new String(String.valueOf(data[i%data.length])).intern();//耗费时间:1350

        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间:" + (end - start));
        try {
            Thread.sleep(1000000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
    }
}
