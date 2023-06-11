package com.itdom.unittest.unit9;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.CombinableMatcher.either;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class AssertMatcherTest {
    @Test
    public void testAssertMatcher(){
        int i=100;
        assertThat(i,equalTo(100));
        assertThat(i,not(equalTo(200)));
        assertThat(i, Is.is(100));
        assertThat(i, Is.is(not(200)));

        double price=23.54;
        //表示满足price为23.54或者23.45都可以
        assertThat(price,either(equalTo(23.54)).or(equalTo(23.45)));
        //表示两个条件都满足才可顺利通过
        assertThat(price,both(equalTo(23.54)).and(not(equalTo(23.45))));
        // 表示符合任意一个就可以
        assertThat(price,anyOf(Is.is(23.54), Is.is(23.45),Is.is("23.00")));
        //表示所有条件都满足才可以酸正确
        assertThat(price,allOf(Is.is(23.54),not(Is.is(23.45))));
        //任何一个满足于得益于2就啊u和
        assertThat(Stream.of(1,2,3).anyMatch(e->e>2),equalTo(true));
    }
}


























