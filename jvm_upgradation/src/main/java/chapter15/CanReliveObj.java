package chapter15;

/**
 * finalize()方法将对象复活
 *
 *
 */
public class CanReliveObj {
    public static CanReliveObj canReliveObj;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("重写了对象的finalize()方法");
        canReliveObj = this;
    }

    /**
     * 执行结果：
     * 重写了对象的finalize()方法
     * 第一次调用GC
     * canReliveObj still alive
     * 第二次GC
     * canReliveObj is dead
     */
    public static void main(String[] args) throws InterruptedException {
        canReliveObj = new CanReliveObj();
        canReliveObj=null;
        System.gc();
        System.out.println("第一次调用GC");
        Thread.sleep(2000L);
        if (canReliveObj==null){
            System.out.println("canReliveObj is dead");
        }else {
            System.out.println("canReliveObj still alive");
        }
        System.out.println("第二次GC");
        canReliveObj=null;
        System.gc();
        Thread.sleep(2000L);
        if (canReliveObj==null){
            System.out.println("canReliveObj is dead");
        }else {
            System.out.println("canReliveObj still alive");
        }
    }
}
