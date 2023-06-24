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
        stringTest.test3();
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
        String s2 = s1.replace("a","w");//使用replace会重新生成一个字符串
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
