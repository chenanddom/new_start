package chapter16;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {
    public static PhantomReferenceTest obj;

    static ReferenceQueue<PhantomReferenceTest> phantomQueue = null;

    public static class CheckRefQueue extends Thread{

        @Override

        public void run() {

//跟踪引用队列

            while(true){

                if(phantomQueue != null){

                    PhantomReference<PhantomReferenceTest> objt = null;

                    try{

                        objt = (PhantomReference<PhantomReferenceTest>)phantomQueue.remove();

                    }catch(Exception e){

                        e.printStackTrace();

                    }

                    if(objt != null){

                        System.out.println("TraceCanReliveObj is delete by GC");

                    }

                }

            }

        }

    }

    @Override

    protected void finalize() throws Throwable {

        super.finalize();

        System.out.println("CanReliveObj finalize called");

        obj = this;

    }

    @Override

    public String toString() {

        return "I am CanReliveObj";

    }

    public static void main(String[] args) throws InterruptedException {

        Thread t = new CheckRefQueue();

        t.setDaemon(true);

        t.start();

        phantomQueue = new ReferenceQueue<PhantomReferenceTest>();

        obj = new PhantomReferenceTest();

        PhantomReference<PhantomReferenceTest> phantomRef = new PhantomReference<PhantomReferenceTest>(obj,phantomQueue);

        obj = null;

        System.gc();

        Thread.sleep(1000);

        if(obj==null){

            System.out.println("obj是null");

        }else{

            System.out.println("obj可用");

        }

        System.out.println("第2次GC");

        obj = null;

        System.gc();

        Thread.sleep(1000);

        if(obj == null){

            System.out.println("obj是null");

        }else{

            System.out.println("obj可用");

        }

    }
}
