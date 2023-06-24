package chapter13;

public class StringExer {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char[] ch) {
        str =" test ok";
        ch[0]='1';
    }

    public static void main(String[] args) {
        /**
         * 运行结果：
         * good
         * 1est
         */
        StringExer stringExer = new StringExer();
        stringExer.change(stringExer.str, stringExer.ch);
        System.out.println(stringExer.str);
        System.out.println(stringExer.ch);
    }
}
