package chapter13;

/**
 * 1、测试String s1 = new String("ab");创建了几个对象？
 * 2、String s2 = new String("a")+new String("b");呢？
 * 答案，查看字节码
 */
public class StringNewTest {
    public static void main(String[] args) {
//        String s1 = new String("ab");
       String s2 = new String("a")+new String("b");
    }
}
