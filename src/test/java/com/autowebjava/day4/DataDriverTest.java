package com.autowebjava.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by sundongfeng on 2018/12/28
 */
public class DataDriverTest {
    @DataProvider(name = "loginUser")
    public Object[][] data1(){
        return new Object[][]{
                {"user1","pwd1"},
                {"user2","pwd2"},
                {"user3","pwd3"}
        };
    }

    @Test(dataProvider = "loginUser")
    public void loginTest(String user,String pwd){
        System.out.println("user" + user);
        System.out.println("pwd" + pwd);
    }
}
