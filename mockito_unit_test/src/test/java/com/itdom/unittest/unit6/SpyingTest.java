package com.itdom.unittest.unit6;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * 使用spy可以部分模拟某个类的行为，对于第三方的包调式是比较好的
 */
public class SpyingTest {

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testSpy(){
        List<String> list = new ArrayList<>();
        List<String> spyList = Mockito.spy(list);
        spyList.add("first");
        spyList.add("second");
        assertThat(spyList.isEmpty(),equalTo(false));
    }

}
