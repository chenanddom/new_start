package chapter19;

public class ClinitTest2 extends ClinitTest1{
    public static int number2;
    static{
        number2=2;
        System.out.println("chapter19.ClinitTest2.number2="+number2);
    }

    public static void main(String[] args) {
        System.out.println(number2);
    }
}
