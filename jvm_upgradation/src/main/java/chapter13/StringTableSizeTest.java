package chapter13;

/**
 * -XX:StringTableSize=10
 */
public class StringTableSizeTest {

    public static void main(String[] args) {
        System.out.println("测试Tablesize");
        try {
            Thread.sleep(500000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
