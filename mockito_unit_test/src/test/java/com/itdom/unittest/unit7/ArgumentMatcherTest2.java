package com.itdom.unittest.unit7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentMatcherTest2 {
    private Foo foo;
    @Before
    public void setUp(){
        this.foo = Mockito.mock(Foo.class);
    }
    @After
    public void close(){
        Mockito.reset(this.foo);
    }
    /**
     * 测试isA,any
     */
    @Test
    public void testComplex() {
        when(foo.function(isA(Parent.class))).thenReturn(100);
        when(foo.function(any(Child1.class))).thenReturn(100);
        assertThat(foo.function(new Child1()),equalTo(100));
        reset(foo);
        when(foo.function(isA(Child1.class))).thenReturn(100);
        int result = foo.function(new Child2());
        System.out.println(result);
        assertThat(result,equalTo(100));
    }


    static class Foo {
        int function(Parent p) {
            return p.work();
        }
    }

    interface Parent {
        int work();
    }

    class Child1 implements Parent {

        @Override
        public int work() {
            throw new RuntimeException();
        }
    }
    class Child2 implements Parent {

        @Override
        public int work() {
            throw new RuntimeException();
        }
    }

}
