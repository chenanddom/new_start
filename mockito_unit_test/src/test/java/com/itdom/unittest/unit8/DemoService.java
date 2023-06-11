package com.itdom.unittest.unit8;

import java.io.Serializable;
import java.util.Collection;

public class DemoService {

    public int method1(Integer p1, String p2, Collection<?> p3, Serializable p4) {
        throw new RuntimeException();
    }

    public void method2(Integer p1, String p2, Collection<?> p3, Serializable p4) {
        throw new RuntimeException();
    }
}
