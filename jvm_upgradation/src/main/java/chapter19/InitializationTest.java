package chapter19;

/**
 * 以下场景不会生成<clinit>()方法
 *
 */
public class InitializationTest {
    //对于非静态的字段，不管是不是显式的赋值，都不会生成<clinit>()
    public int a=1;
    //对于静态的变量，如果不做显式的赋值就不会生成<clinit>()
    public static int b;
    //对于声明为static+final修饰的基本数据类型，不管是否显式赋值，都不会生成<clinit>()

    public static void main(String[] args) {

    }
}
