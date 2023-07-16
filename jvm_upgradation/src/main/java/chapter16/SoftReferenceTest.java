package chapter16;

import java.lang.ref.SoftReference;

/**
 *
 */
public class SoftReferenceTest {
    private static class User {
        private Integer id;
        private String name;

        public User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        User user = new User(1, "debo");
        // 建立User对象的软引用
        SoftReference<User> userSoftReference = new SoftReference<>(user);
        // 去掉强引用
        user = null;
        System.out.println(userSoftReference.get());
        // 手动触发GC
        System.gc();
        System.out.println("第一次GC: " + userSoftReference.get());
        try {
            // 分配适量内存空间，造成内存资源紧张，产生GC，同时又不会导致堆内存溢出
            byte[] bytes = new byte[ 7* 1025 * 1050];
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
        System.out.println("第二次GC: " + userSoftReference.get());//由于资源紧张，软引用被回收，无法获取到了。

        }
    }
}
