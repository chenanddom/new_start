package chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    byte[] buffer = new byte[1*1024*1024];
    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();
        while (true){
            list.add(new HeapOOM());
        }
    }
}
