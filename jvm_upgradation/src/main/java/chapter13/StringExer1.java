package chapter13;

public class StringExer1 {
    public static void main(String[] args) {
       String s = new String("a")+new String("b");
        String s2 = s.intern();
        System.out.println(s=="ab");//jdk6:false jdk8:true
        System.out.println(s2=="ab");//jdk6:true jdk8:true
    }
}
