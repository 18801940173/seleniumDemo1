package com.autowebjava.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by sundongfeng on 2018/12/13
 */
public class testNGDemo2 {
    //校验a == a;
    @Test
    public  void  assertEqualTest(){
        String a = "asdf";
        String b = "asdf";
        Assert.assertEquals(a,b,"a等于b");
        System.out.println("assertEquals验证成功！");
    }

    @Test
    public void assertNotEqualsTest(){
        String a = "asdf";
        String b = "asdf1";
        Assert.assertNotEquals(a,b,"a不等于b");
        System.out.println("assertNotEquals验证成功！");
    }

    @Test
    public void assertNull(){
        String a = null;
        Assert.assertNull(a);
        System.out.println("验证assertNull成功！");
    }

    @Test
    public void assertNotNull(){
        String a = "sdfs";
        Assert.assertNotNull(a);
        System.out.println("验证assertNotNull成功！");
    }

    @Test
    public void aVoid(){
//        Boolean a = false;
        Boolean a = false;
        Assert.assertFalse(a);
        System.out.println("验证assertFalse成功！");
    }

    @Test
    public void aVoid1(){
//        Boolean a = true;
        Boolean a  = true;
        Assert.assertTrue(a);
        System.out.println("验证assertTrue成功！");
    }
}
