package chapter19;

public class ArithmeticTest {

    public void method1() {
        int i = 10;
        double j = i / 0.0;
        System.out.println(j);
        double d1 = 0.0;
        double d2 = d1 / 0.0;
        System.out.println(d2);//NaN: not a number
    }
    public void method2(){
        float i = 10;
        float j = -i;
        i = -j;
    }
    public void method3(int j){
        int i = 100;
        i += 10;
    }
    public static void main(String[] args) {
        new ArithmeticTest().method1();
    }

}
