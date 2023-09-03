package chapter18;

/**
 * 成员变量初始化得过程:1.默认初始化 2.显示初始化/代码块中初始化 3. 构造器初始化 4. 有了对象之后使用 对象.属性的方式
 */
public class Father {
    int x = 10;

    public Father() {
        this.print();
        this.x = 20;
    }

    public void print() {
        System.out.println("father's x=" + x);
    }

}
