package com.itdom.unittest.unit7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentMatcherTest {

    private List<Integer> list;

    @Before
    public void setUp() {
        this.list = Mockito.mock(ArrayList.class);
    }


    @Test
    public void basicTest() {
        when(list.get(0)).thenReturn(100);
        assertThat(list.get(0), equalTo(100));
        //如果没有打桩，那么就是返回当前的类型的默认值
        assertThat(list.get(1),nullValue());

    }

    @After
    public void close() {
        reset(this.list);
    }

}
