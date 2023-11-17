package chapter19;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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
public class ActiveUseClassTest {
    static {
        System.out.println("初始化ActiveUseClassTest");
    }

    public static int n1 = 1;
    //7、当虚拟机启动时，用户需要指定一个要执行的主类(包含main()方法的那个类)，虚拟机会先初始化这个类。
    public static void main(String[] args) {
//        System.out.println(new ActiveUseClassTest());
//        invokeStaticTest();

//        System.out.println(IntTest.NUM1);
//        IntTest.showTest();
            // * 6、如果一个接口定义了default方法，那么直接实现或者间接实现该接口的类的初始化，该接口要在其之前被初始化。
//        System.out.println(Son.NUMBER2);
//        try {
//            4、当使用了java.lang.reflect包中的方法反射类的方法时。比如：Class.forName(“com.itdom.java.Test”)
//            Class<?> son = Class.forName("chapter19.ActiveUseClassTest2");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 2、当调用类的静态方法时，即当使用了字节码invokestatic指令
     */
    public static void invokeStaticTest() {
        System.out.println("invokeStaticTest");
    }
}

interface IntTest {
    public static final Thread t1 = new Thread() {
        {
            System.out.println("初始化IntTest");
        }
    };
    int NUM1 = 1;
    int NUM2 = 2;

    static void showTest() {
        System.out.println("show..");
    }
    default void defaultMethod(){
        System.out.println("defaultMethod");
    }
}

class Father implements IntTest {
    static {
        System.out.println("Father初始化");
    }

    static int NUMBER = 1;
}

class Son extends Father {
    static {
        System.out.println("Son初始化");
    }
    public static int NUMBER2=10;
}
