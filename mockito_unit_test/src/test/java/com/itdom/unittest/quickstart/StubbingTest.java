package com.itdom.unittest.quickstart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;

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
    private DemoService demoService;
    @Before
    public void setUp() {
        this.list = mock(ArrayList.class);
        this.demoService = mock(DemoService.class);
    }

    /**
     * 如何使用Stubbing
     */
    @Test
    public void howToUseStubbingTest() {
        when(this.list.get(0)).thenReturn("first");
        Object o = this.list.get(0);
        assertThat(o, equalTo("first"));
        when(this.list.get(anyInt())).thenThrow(new RuntimeException());

        try {
            this.list.get(0);
            fail();//如果上面的调用没有抛出运行时异常，那么此处就会抛出错误
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    /**
     * void返回值方法如何使用stubbing
     */
    @Test
    public void howToUseStubbingVoidMethod() {
        doNothing().when(this.list).clear();//返回值为空的方法调用，此处调用的是List的clear方法
        list.clear();
        verify(list, times(1)).clear();//验证是否调用了clear方法
        //调用返回值为Void抛异常
        doThrow(new RuntimeException()).when(this.list).clear();
        try {
            this.list.clear();
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    /**
     * 使用doReturn模拟when().thenReturn()
     */
    @Test
    public void doReturnTest() {
        when(this.list.get(0)).thenReturn("first");
        when(this.list.get(1)).thenReturn("second");
        doReturn("third").when(this.list).get(3);
        assertThat(list.get(3), equalTo("third"));
    }

    /**
     * 模拟迭代调用
     */
    @Test
    public void mockIterator() {
        /**
         * 此处比每次调用返回对于的值，分别为1，2，3，4，5
         */
        when(this.list.size()).thenReturn(1, 2, 3, 5, 4);
        assertThat(this.list.size(), equalTo(1));
        assertThat(this.list.size(), equalTo(2));
        assertThat(this.list.size(), equalTo(3));
        assertThat(this.list.size(), equalTo(5));
        assertThat(this.list.size(), equalTo(4));
    }

    /**
     * 使用answer实现多次迭代，避免手动编写多次不方便
     */
    @Test
    public void testWithAnswer() {
        when(this.list.get(anyInt())).thenAnswer(invocationOnMock -> {
            Integer value = invocationOnMock.getArgumentAt(0, Integer.class);//获取方法的入参
            return String.valueOf(value * 10);
        });
        System.out.println(list.get(9));
        assertThat(list.get(9),equalTo("90"));
    }

    /**
     * 调用真正的方法
     */
    @Test
    public void callRealMethod(){
        System.out.println(demoService.getI());//默认情况指挥返回默认值
        when(demoService.getI()).thenReturn(5);
        System.out.println(demoService.getI());
        //上面都是靠打桩的方式进行植入的模拟数据，实际并没有真正的调用方法
        when(demoService.getI()).thenCallRealMethod();//真正的调用方法
        System.out.println(demoService.getI());
        doThrow(new RuntimeException()).when(demoService).getSource();
        try {
            demoService.getSource();
            fail();
        }catch (Exception e){
            assertThat(e,instanceOf(RuntimeException.class));
        }

    }



    @After
    public void destroy() {
        reset(list);
    }

}
