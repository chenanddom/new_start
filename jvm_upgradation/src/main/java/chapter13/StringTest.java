package chapter13;

/**
 * 验证字符串
 */
public class StringTest {
    public static void main(String[] args) {
//        extracted();
        StringTest stringTest = new StringTest();
//        stringTest.test1();
//        stringTest.test2();
//        stringTest.test3();
//        stringTest.test4();
        stringTest.test5();
    }

    private void test5() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";//如果使用拼接符好的前后出现了变量，则相当于在对空间中new String(),具体的内容为拼接的结果
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5); //false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false
        //intern()判断字符串是否在常量池存在，如果存在就直接返回产量池的地址返回赋值给变量，否则就在常量池存放一份常量。
        String s8 = s6.intern();
        System.out.println(s3 == s8);//true


    }

    private void test4() {
        String s1 = "a" + "b" + "c";
        String s2 = "abc";
        System.out.println(s1 == s2);


    }

    /**
     * true
     * abc
     * abc
     */
    public void test1() {
        String s1 = "abc";//字面量定义的方式，"abc"存储在字符串常量池中
        String s2 = "abc";
//        s1 = "hello";
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
    }

    /**
     * false
     * abcdef
     * abc
     */
    public void test2() {
        String s1 = "abc";//字面量定义的方式，"abc"存储在字符串常量池中
        String s2 = "abc";
        s1 += "def";//拼接会重新生成一个字符串
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
    }

    public void test3() {
        String s1 = "abc";
        String s2 = s1.replace("a", "w");//使用replace会重新生成一个字符串
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
    }

    private static void extracted() {
        System.out.println();
        System.out.println("1");//2084
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");//2093

        System.out.println("1");//2094
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("10");//2094
    }
}
