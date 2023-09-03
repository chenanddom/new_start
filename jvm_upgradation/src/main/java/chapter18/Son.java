package chapter18;

public class Son extends Father {
    int x = 30;

    public Son() {
        this.print();//此处调用的时Son的自己的print(),此时Son的成员变量还没有初始化。
        this.x=40;
    }

    @Override
    public void print() {
        System.out.println("Son is x="+x);
    }
}
