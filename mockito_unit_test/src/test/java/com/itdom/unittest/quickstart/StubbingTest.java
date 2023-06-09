package com.itdom.unittest.quickstart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class StubbingTest {
    private List list;
    @Before
    public void setUp(){
        this.list = mock(ArrayList.class);
    }
    @Test
    public void howToUseStubbingTest(){
        when(this.list.get(0)).thenReturn("first");
        Object o = this.list.get(0);
        assertThat(o,equalTo("first"));
        when(this.list.get(anyInt())).thenThrow(new RuntimeException());

        try {
            this.list.get(0);
            fail();//如果上面的调用没有抛出运行时异常，那么此处就会抛出错误
        }catch (Exception e){
            assertThat(e,instanceOf(RuntimeException.class));
        }
    }
@After
 public void destroy(){
        reset(list);
}

}
