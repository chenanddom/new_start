package chapter18;

public class SonTest {
    public static void main(String[] args) {
        Father father = new Son();//所以Son的第一次打印时0.
        System.out.println(father.x);
    }

}
