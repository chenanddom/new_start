package chapter20;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms60m -Xmx60 -XX:SurvivorRatio=8
 */
public class GCTest {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            byte[] arr = new byte[1024*100];
            list.add(arr);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
