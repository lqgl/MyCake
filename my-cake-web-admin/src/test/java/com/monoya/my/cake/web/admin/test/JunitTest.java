package com.monoya.my.cake.web.admin.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试单元测试是否生效
 */
public class JunitTest {
    @Before
    public void before(){
        System.out.println("before test------>");
    }

    @Test
    public void junitTest(){
        System.out.println("Hello Junit!");
    }

    @After
    public void after(){
        System.out.println("after test------>");
    }
}
