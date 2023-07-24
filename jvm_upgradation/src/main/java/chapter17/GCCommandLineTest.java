package chapter17;

public class GCCommandLineTest {
    /**
     * 注意：执行之前需要添加JVM参数-XX:+PrintCommandLineFlags
     * 执行结果:
     * -XX:InitialHeapSize=266668608 -XX:MaxHeapSize=4266697728 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
     * 根据上面的打印结果
     *
     * -XX:+UseSerialGC参数可以指定年轻代和老年带都使用串行收集器
     * 使用命令行查看结果
     * C:\Users\chendom>jinfo -flag UseSerialGC 7520
     * -XX:+UseSerialGC
     *
     *
     * -XX:+UseParNewGC设置使用ParNew垃圾收集器,
     *-XX:InitialHeapSize=266668608 -XX:MaxHeapSize=4266697728 -XX:MaxNewSize=348966912 -XX:MaxTenuringThreshold=6 -XX:OldPLABSize=16 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseConcMarkSweepGC -XX:-UseLargePagesIndividualAllocation -XX:+UseParNewGC
     * 在JDK7以及以前，默认的都是ParNew配合SerialOld使用，但是到了JDK8，就直接去掉了这个组合，转而使用ParNew+ConcMarkSweep+SerialOld(备选)。
     * -XX:ParallelGCThreads=4设置并行收集垃圾的线程数量
     * -XX:InitialHeapSize=266668608 -XX:MaxHeapSize=4266697728 -XX:MaxNewSize=348966912 -XX:MaxTenuringThreshold=6 -XX:OldPLABSize=16 -XX:ParallelGCThreads=4 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseConcMarkSweepGC -XX:-UseLargePagesIndividualAllocation -XX:+UseParNewGC
     *
     *
     *
     *
     *
     */
    public static void main(String[] args) throws InterruptedException {



        Thread.sleep(10000000L);
    }
}
