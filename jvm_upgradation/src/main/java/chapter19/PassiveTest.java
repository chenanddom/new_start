package chapter19;

/**
 * 被动使用的例子：
 * 1、当访问一个静态变量字段时，只有真正什么这个字段的类才会被初始化
 *      * 当通过子类uiny父类的静态变量，不会导致子类初始化
 * 2、 通数组定义类引用，不会触发此类的初始化
 * 3、引用常量不会触发此类或者接口的初始化。因为常量在链接阶段的准备环节就已经赋值了
 * 4、调用ClassLoader类的loadClass()方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 */
public class PassiveTest {
    public static void main(String[] args) {
        //1、当访问一个静态变量字段时，只有真正什么这个字段的类才会被初始化
//        System.out.println(SSon.NUMBER);
        // 2、通数组定义类引用，不会触发此类的初始化
//        SSon[] sSonArray = new SSon[10];
        //3、引用常量不会触发此类或者接口的初始化。因为常量在链接阶段的准备环节就已经赋值了
//        System.out.println(SSon.NUMBER2);
        //4、调用ClassLoader类的loadClass()方法加载一个类，并不是对类的主动使用，不会导致类的初始化
        try {
            Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("chapter19.ActiveUseClassTest2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
class FFather{
    static {
        System.out.println("FFather初始化");
    }
    public static int NUMBER=1;
}
class SSon extends FFather{
    public static final int NUMBER2=2;
    static {
        System.out.println("SSon初始化");
    }

}
