package chapter13;

/**
 * 字符串分析
 */
public class StringAnlysis {
    public static void main(String[] args) {
        Object object = new Object();
        StringAnlysis stringAnlysis = new StringAnlysis();
        stringAnlysis.foo(object);
    }

    public void foo(Object param) {
        String str = param.toString();//会在内存中生成一个字符串存储在堆中
        System.out.println(str);
    }
}
