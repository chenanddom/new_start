package oom.stack;

/**
 * 设置JVM参数
 * -Xms10m -Xmx10m -Xss156k -verbose:gc
 */
public class StackOOM {


    public void invoke(int i) {
        System.out.println("i:" + i);
        i++;
        try {
            Thread.sleep(10);
            invoke(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StackOOM().invoke(0);
    }
}
