package com.autowebjava.day1;

import org.testng.Assert;
import org.testng.annotations.*;

import javax.sound.midi.SoundbankResource;

/**
 * Created by sundongfeng on 2018/12/12
 */
public class TestNGDemo1 {
    @BeforeTest
    public void beforeTest01(){
        System.out.println("这是BeforeTest注解");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是BeforeMethod注解");
    }
    @Test
    public void testCase1(){
        System.out.println("这是@Test注解,case1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是@Test注解,case2");
        Assert.assertNotEquals(2,2);
    }
    @AfterMethod
    public void afterMethod1(){
        System.out.println("这是AfterMethod注解");
    }
    @AfterTest
    public void afterTest1(){
        System.out.println("这是AfterTest注解");
    }

}
