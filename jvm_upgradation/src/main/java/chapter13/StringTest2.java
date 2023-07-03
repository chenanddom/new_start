package chapter13;

/**
 * 验证字符串
 */
public class StringTest2 {
    public static void main(String[] args) {
        StringTest2 stringTest = new StringTest2();
//        stringTest.test1();
//        stringTest.test2();
        stringTest.sampleTest();//测试拼接和append的差距
    }

    /**
     * 如下的s1+s2的执行细节：
     * 1. StringBuilder sb = new StringBuilder();
     * 2.sb.append("a");
     * 3.sb.append("b");
     * 4.sb.toString()-->此操作类似与new String("ab");
     * 注意:jdk5.0之前使用的是StringBuffer
     */
    public void test1() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);
    }

    /**
     * 1.字符串拼接操作不一定使用StringBuilder，如果拼接符号左右两边都是常量或者常量引用，
     * 则仍然使用编译优化，即非StringBuilder的方式。
     * 2. 针对final修饰的类、方法、基本数据类型、引用数据类型的常量，最好使用。
     */
    public void test2() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);
    }

    /**
     * 差距对比
     * coast:4598
     * --------------------------
     * coast:2
     * method1()中使用了拼接的方式需要多次的创建StringBuilder、String,这种创建方式是比较耗费性能的，索引耗时比较长
     * method2()则只是始终是一个StringBuilder，只需要不断的往里创建字符串就可以了，但是这种方式虽然块，也有一些问题，因为StringBuilder
     * 底层使用的是数组的方式，如果容量超过了就需要扩容，为了避免多次的扩容可以使用带参的的构造函数来创建StringBuilder,创建之初就指定好容量
     *
     *
     */
    public void sampleTest() {
        long start1 = System.currentTimeMillis();
        method1(100000);
        long end1 = System.currentTimeMillis();
        System.out.println("coast:" + (end1 - start1));
        System.out.println("--------------------------");
        start1 = System.currentTimeMillis();
        method2(100000);
        end1 = System.currentTimeMillis();
        System.out.println("coast:" + (end1 - start1));
    }


    public void method1(int num) {
        String str = "";
        for (int i = 0; i < num; i++) {
            str = str + "a";//每次都创建一个StringBuilder和一个String
        }
    }

    public void method2(int num) {
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < num; i++) {
            sb.append("a");
        }
    }


}
