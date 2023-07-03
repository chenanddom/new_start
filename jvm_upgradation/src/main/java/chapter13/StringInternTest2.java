package chapter13;

/**
 *
 */
public class StringInternTest2 {
    public static void main(String[] args) {
        String s3 = new String("1")+new String("1");
        String s4 = "11";//在常量池创建的字符串”11“
        String s5 = s3.intern();//返回上一步在字符串常量池创建的常量的地址
        System.out.println(s5==s4);//true
        System.out.println(s3==s4);//false
    }
}
