package com.itdom.unittest.quickstart;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class MockDeepTest {
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private Person person;
//    @Mock
//    private Car car;
    @Test
    public void testDeepTest() {
        //1. 默认的mock是会出现空指针的
//        Car car = person.getCar();
//        car.run();
        //2.通过when..then的方式，但是这种方式比较繁琐
//        when(person.getCar()).thenReturn(car);
//        Car car = person.getCar();
//        car.run();
        person.getCar().run();
    }

}
