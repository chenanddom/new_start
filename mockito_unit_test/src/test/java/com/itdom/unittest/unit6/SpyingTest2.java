package com.itdom.unittest.unit6;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * 使用spy可以部分模拟某个类的行为，对于第三方的包调式是比较好的
 */
public class SpyingTest2 {

    @Spy
    private List<String> spyList = new ArrayList<>();
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testSpy(){
        spyList.add("first");
        spyList.add("second");
        assertThat(spyList.isEmpty(),equalTo(false));
        //部分模拟
        when(spyList.isEmpty()).thenReturn(true);//对isEmpty()方法进行打桩,在后面调用此方法就会以模拟的方式进行返回
        when(spyList.size()).thenReturn(0);
        assertThat(spyList.isEmpty(),equalTo(true));
        assertThat(spyList.size(),equalTo(0));
    }

}
