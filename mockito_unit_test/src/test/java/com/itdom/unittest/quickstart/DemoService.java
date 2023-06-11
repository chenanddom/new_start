package com.itdom.unittest.quickstart;

public class DemoService {

    public int getI(){
        System.out.println("调用真正的方法");
        return 10;
    }
    public void getSource(){
        throw new RuntimeException();
    }
}
