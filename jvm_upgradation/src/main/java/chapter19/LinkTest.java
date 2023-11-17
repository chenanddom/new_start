package chapter19;

/**
 * 如果时基本类型的类变量：非final修饰的，在解析阶段就是默认值初始化
 *                      final修饰的，在解析阶段就是显式的赋值初始化。
 */
public class LinkTest {
    private static int a = 0;
    private static final  int b=10;
    //使用字面量创建的字符串常量就会在解析阶段将进行显式初始化赋值
    private static final String c="abc";
    //如果时new创建的字符串就需要在初始化阶段进行初始化赋值
    private static final String d=new String("bcd");

    public Object getObject(){
        return null;
    }
}
