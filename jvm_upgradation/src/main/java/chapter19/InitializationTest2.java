package chapter19;

import java.util.Random;

/**
 * 说明，使用static+final修饰的字段显式赋值的操作，到底是在哪个阶段进行赋值呢？
 * 场景1：在链接阶段准备环节赋值
 * 场景2：在初始化阶段的饿<clinit>()中赋值
 * 结论：
 * 1、对于基本数据类型的字段来说，如果使用了static final修饰，则显式赋值通常市在链接阶段的准备环节进行的，
 * 2、对与String来说，如果使用字面量的方式赋值，使用static final修饰的话，则显式赋值通常市在链接阶段的准备环节进行的。
 *
 * 在初始话阶段<clinit>()中赋值的情况
 * 排除上述的在准备环节的情况之外的情况
 *
 * 最终结论:使用static+final修饰的，且显式赋值不设计到方法或者构造器的调用的基本类型或String类型的显式赋值，市在链接阶段的准备环节进行的
 *
 */
public class InitializationTest2 {

    public static int a=1;// 在初始化阶段的<clinit>()中赋值
    public static final int INT_CONSTANT=10;//在链接阶段的准备环节赋值
    public static final Integer INTEGER_CONSTANT_1=Integer.valueOf(100);//在链接阶段中的<clinit>()方法中赋值
    public static final Integer INTEGER_CONSTANT_2=Integer.valueOf(1000);//在链接阶段中的<clinit>()方法中赋值

    public static final String str1="hello world";//在链接阶段的准备环节赋值
    public static final String  str2 = new String("hello world");//在链接阶段的<clinit>()方法中赋值

    public static String str3="hello world2";


    public static final int str4 = new Random().nextInt();



    public static void main(String[] args) {

    }
}
