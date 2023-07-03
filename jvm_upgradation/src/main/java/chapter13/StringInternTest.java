package chapter13;

/**
 *
 */
public class StringInternTest {
    public static void main(String[] args) {
        String s1 = new String("1");
        s1.intern();//调用intern方法钱，字符串常量池已经存在"1"
        String s2="1";
        System.out.println(s1==s2);//JDK6 false JDK7/JDK8：false

        String s3 = new String("1")+new String("1");// s3变量记录的地址为:new String("11");
        s3.intern();//指向玩上一行代码之后，字符串常量池中，是否存在常量”11“呢？答案是：不存在！！
                    //jdk6创建了一个新的对象”11“，特就是新的地址。
                    //jdk7/jdk8 此时没有创建”11“,而是创建了一个执行堆空间的new String("11");
        String s4 = "11";//s4变量记录的地址：使用的是上一行代码执行时，在常量池生成的”11“的地址
        System.out.println(s3==s4);//jdk6:false jdk8:true
    }
}
