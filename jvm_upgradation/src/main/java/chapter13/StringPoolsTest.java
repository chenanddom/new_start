package chapter13;

import java.util.HashSet;
import java.util.Set;

/**
 * jdk1.6
 *
 * -XX:PermSize=6m -XX:MaxPermSize=6m -Xms6m -Xmx6m
 *
 * jdk1.8
 * -XX:MetaspaceSize=6m -XX:MaxMetaspaceSize=6m -Xms6m -Xmx6m
 */
public class StringPoolsTest {
    public static void main(String[] args) {
        //使用Set保持常量池的引用，避免full gc回收常量池行为
        Set<String> set = new HashSet<>();
        //在short可以取值的范围内足以让6MB的PermSize或者heap产生OOM
        short i=0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
