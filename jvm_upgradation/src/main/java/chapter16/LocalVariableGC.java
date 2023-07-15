package chapter16;

public class LocalVariableGC {

    /**
     * GC的日志
     * [GC (System.gc()) [PSYoungGen: 15487K->10744K(76288K)] 15487K->10904K(251392K), 0.0067192 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     * [Full GC (System.gc()) [PSYoungGen: 10744K->0K(76288K)] [ParOldGen: 160K->10890K(175104K)] 10904K->10890K(251392K), [Metaspace: 3305K->3305K(1056768K)], 0.0106672 secs] [Times: user=0.00 sys=0.02, real=0.01 secs]
     * Heap
     *  PSYoungGen      total 76288K, used 655K [0x000000076b380000, 0x0000000770880000, 0x00000007c0000000)
     *   eden space 65536K, 1% used [0x000000076b380000,0x000000076b423ee8,0x000000076f380000)
     *   from space 10752K, 0% used [0x000000076f380000,0x000000076f380000,0x000000076fe00000)
     *   to   space 10752K, 0% used [0x000000076fe00000,0x000000076fe00000,0x0000000770880000)
     *  ParOldGen       total 175104K, used 10890K [0x00000006c1a00000, 0x00000006cc500000, 0x000000076b380000)
     *   object space 175104K, 6% used [0x00000006c1a00000,0x00000006c24a2a78,0x00000006cc500000)
     *  Metaspace       used 3312K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 360K, capacity 388K, committed 512K, reserved 1048576K
     */
    public void m1(){
        byte[] buffer = new byte[10*1024*1024];//10M
        System.gc();//无法释放内存
    }

    /**
     * 可以看到新生代GC已经不足10M,GC后老年代GC已经将内存少于10M,所以时GC成功了。
     * [GC (System.gc()) [PSYoungGen: 15487K->712K(76288K)] 15487K->720K(251392K), 0.0015495 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (System.gc()) [PSYoungGen: 712K->0K(76288K)] [ParOldGen: 8K->650K(175104K)] 720K->650K(251392K), [Metaspace: 3310K->3310K(1056768K)], 0.0040628 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
     * Heap
     *  PSYoungGen      total 76288K, used 655K [0x000000076b380000, 0x0000000770880000, 0x00000007c0000000)
     *   eden space 65536K, 1% used [0x000000076b380000,0x000000076b423ee8,0x000000076f380000)
     *   from space 10752K, 0% used [0x000000076f380000,0x000000076f380000,0x000000076fe00000)
     *   to   space 10752K, 0% used [0x000000076fe00000,0x000000076fe00000,0x0000000770880000)
     *  ParOldGen       total 175104K, used 650K [0x00000006c1a00000, 0x00000006cc500000, 0x000000076b380000)
     *   object space 175104K, 0% used [0x00000006c1a00000,0x00000006c1aa2a68,0x00000006cc500000)
     *  Metaspace       used 3317K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 360K, capacity 388K, committed 512K, reserved 1048576K
     */
    public void m2(){
        byte[] buffer = new byte[10*1024*1024];
        buffer=null;
        System.gc();
    }

    /**
     * 可以看到GC是失败了，虽然已经离开了分配内存的作用域后GC，但是内存仍然没有被释放
     * [GC (System.gc()) [PSYoungGen: 15487K->10728K(76288K)] 15487K->10952K(251392K), 0.0065101 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
     * [Full GC (System.gc()) [PSYoungGen: 10728K->0K(76288K)] [ParOldGen: 224K->10890K(175104K)] 10952K->10890K(251392K), [Metaspace: 3310K->3310K(1056768K)], 0.0137282 secs] [Times: user=0.03 sys=0.01, real=0.01 secs]
     * Heap
     *  PSYoungGen      total 76288K, used 655K [0x000000076b380000, 0x0000000770880000, 0x00000007c0000000)
     *   eden space 65536K, 1% used [0x000000076b380000,0x000000076b423ee8,0x000000076f380000)
     *   from space 10752K, 0% used [0x000000076f380000,0x000000076f380000,0x000000076fe00000)
     *   to   space 10752K, 0% used [0x000000076fe00000,0x000000076fe00000,0x0000000770880000)
     *  ParOldGen       total 175104K, used 10890K [0x00000006c1a00000, 0x00000006cc500000, 0x000000076b380000)
     *   object space 175104K, 6% used [0x00000006c1a00000,0x00000006c24a2b10,0x00000006cc500000)
     *  Metaspace       used 3317K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 360K, capacity 388K, committed 512K, reserved 1048576K
     */
    public void m3(){
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        System.gc();
    }

    /**
     * 这段代码只是比上面的m3方法多了一个变量，但是确GC成功了，因为value变量在变量表里面将buffer变量代替了。所以buffer对于的对内存没有了引用，只能GC掉
     * [GC (System.gc()) [PSYoungGen: 14176K->696K(76288K)] 14176K->704K(251392K), 0.0044041 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (System.gc()) [PSYoungGen: 696K->0K(76288K)] [ParOldGen: 8K->650K(175104K)] 704K->650K(251392K), [Metaspace: 3306K->3306K(1056768K)], 0.0078261 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     * Heap
     *  PSYoungGen      total 76288K, used 655K [0x000000076b380000, 0x0000000770880000, 0x00000007c0000000)
     *   eden space 65536K, 1% used [0x000000076b380000,0x000000076b423ee8,0x000000076f380000)
     *   from space 10752K, 0% used [0x000000076f380000,0x000000076f380000,0x000000076fe00000)
     *   to   space 10752K, 0% used [0x000000076fe00000,0x000000076fe00000,0x0000000770880000)
     *  ParOldGen       total 175104K, used 650K [0x00000006c1a00000, 0x00000006cc500000, 0x000000076b380000)
     *   object space 175104K, 0% used [0x00000006c1a00000,0x00000006c1aa2b70,0x00000006cc500000)
     *  Metaspace       used 3313K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 360K, capacity 388K, committed 512K, reserved 1048576K
     */
    public void m4(){
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        int value=4;
        System.gc();
    }

    /**
     * 从上面的m1方法的调用是失败的，但是，这个方法调用GC确实成功了，因为m1调完出栈了，所以局部变量表也就无需buffer,对应的内存也需要GC
     * [GC (System.gc()) [PSYoungGen: 15487K->10744K(76288K)] 15487K->10936K(251392K), 0.0059298 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     * [Full GC (System.gc()) [PSYoungGen: 10744K->0K(76288K)] [ParOldGen: 192K->10891K(175104K)] 10936K->10891K(251392K), [Metaspace: 3310K->3310K(1056768K)], 0.0059273 secs] [Times: user=0.01 sys=0.03, real=0.01 secs]
     * [GC (System.gc()) [PSYoungGen: 0K->0K(76288K)] 10891K->10891K(251392K), 0.0003165 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (System.gc()) [PSYoungGen: 0K->0K(76288K)] [ParOldGen: 10891K->651K(175104K)] 10891K->651K(251392K), [Metaspace: 3310K->3310K(1056768K)], 0.0037801 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * Heap
     *  PSYoungGen      total 76288K, used 655K [0x000000076b380000, 0x0000000770880000, 0x00000007c0000000)
     *   eden space 65536K, 1% used [0x000000076b380000,0x000000076b423ee8,0x000000076f380000)
     *   from space 10752K, 0% used [0x000000076fe00000,0x000000076fe00000,0x0000000770880000)
     *   to   space 10752K, 0% used [0x000000076f380000,0x000000076f380000,0x000000076fe00000)
     *  ParOldGen       total 175104K, used 651K [0x00000006c1a00000, 0x00000006cc500000, 0x000000076b380000)
     *   object space 175104K, 0% used [0x00000006c1a00000,0x00000006c1aa2c38,0x00000006cc500000)
     *  Metaspace       used 3317K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 360K, capacity 388K, committed 512K, reserved 1048576K
     */
    public void m5(){
        m1();
        System.gc();
    }
    public static void main(String[] args) {
        LocalVariableGC localVariableGC = new LocalVariableGC();
//        localVariableGC.m1();
//        localVariableGC.m2();
//        localVariableGC.m3();
//        localVariableGC.m4();
        localVariableGC.m5();
    }
}
