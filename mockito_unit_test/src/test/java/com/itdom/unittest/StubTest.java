package com.itdom.unittest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StubTest {
    private List list;

    @Before
    public void init() {
        list = mock(List.class);
    }

    @Test
    public void testReturnValu() {
        when(list.get(0)).thenReturn("first");
        assertThat(list.get(0), equalTo("first"));
        when(list.get(anyInt())).thenThrow(new RuntimeException());
        try {
            list.get(0);
        }catch (Exception e){
        assertThat(e,instanceOf(RuntimeException.class));
        }
    }
}
