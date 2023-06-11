package com.itdom.unittest.unit8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.Serializable;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WildCardUnitTest {

    @Mock
    DemoService demoService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testWildCard(){
        when(demoService.method1(anyInt(),anyString(),anyCollection(),isA(Serializable.class))).thenReturn(100);
        assertThat(demoService.method1(1,"111", Collections.emptyList(),"11"),equalTo(100));

    }

    @Test
    public void testWildCardWithSpec(){
        when(demoService.method1(anyInt(),eq("zhangsan"),anyCollection(),isA(Serializable.class))).thenReturn(100);
        assertThat(demoService.method1(1,"zhangsan", Collections.emptyList(),"11"),equalTo(100));
        when(demoService.method1(anyInt(),eq("lisi"),anyCollection(),isA(Serializable.class))).thenReturn(100);
        assertThat(demoService.method1(1,"lisi", Collections.emptyList(),"11"),equalTo(100));
    }
    @Test
    public void testWildCardWithSpec2(){
        doNothing().when(demoService).method2(anyInt(),anyString(),anyCollection(),isA(Serializable.class));
        demoService.method2(1,"zhangsan", Collections.emptyList(),"11");
        verify(demoService,times(1)).method2(1,"zhangsan", Collections.emptyList(),"11");
    }

    @After
    public void close(){}

}
