package chapter16;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReferenceTest weakReferenceTest = new WeakReferenceTest();

        Reference<WeakReferenceTest> reference = new WeakReference<WeakReferenceTest>(weakReferenceTest);
        //将强引用释放掉
        weakReferenceTest = null;
        //第一次获取还能够获取到
        System.out.println("第一次获取:"+reference.get());
        System.gc();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //因为GC的时候只要有虚引用就会直接欸干掉，所以就无法获取到
        System.out.println("第二次获取:"+reference.get());
    }
}
