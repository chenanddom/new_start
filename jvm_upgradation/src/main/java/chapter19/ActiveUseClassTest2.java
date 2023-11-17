package chapter19;

/**
 * 主动使用类的示例：
 * 1、当创建一个类的实例时，比如使用new关键字，或者通过反射、克隆、反序列化
 * 2、当调用类的静态方法时，即当使用了字节码invokestatic指令
 * 3、当使用类、接口静态字段时(final修饰特殊考虑)，比如getstatic 或者putstatic指令。(或者访问变量、赋值变量操作)
 * 4、当使用了java.lang.reflect包中的方法反射类的方法时。比如：Class.forName(“com.itdom.java.Test”)
 * 5、当初始化子类时，如果发现其父类还没有进行初始化，则需要先触发父类的初始化。
 * 6、如果一个接口定义了default方法，那么直接实现或者间接实现该接口的类的初始化，该接口要在其之前被初始化。
 * 7、当虚拟机启动时，用户需要指定一个要执行的主类(包含main()方法的那个类)，虚拟机会先初始化这个类。
 * 8、当初次调用了MethodHandle实例时，初始化该MethodHandle指向的方法所在的类，(涉及解析REF_getStatic、REF_putStatic、REF_invokeStatic方法句柄对应的类)
 */
public class ActiveUseClassTest2 {
    static {
        System.out.println("初始化ActiveUseClassTest2");
    }

}

