package com.autowebjava.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.sql.Time;

/**
 * Created by sundongfeng on 2018/12/13
 */
public class CloseBrowserTest {
    @Test
    public void closeChrome() throws InterruptedException{
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        //实例化chromedriver
        WebDriver driver  = new ChromeDriver();
        //关闭浏览器
        Thread.sleep(5000);    //等待5秒
//        driver.close();        //但chromedriver不关闭,只是关闭当前窗口
        driver.quit();          //完全退出，关闭所有窗口并退出
    }

    @Test
    public void closeFireFox() throws InterruptedException{
        //设置FireFox路径
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        //实例化
        WebDriver driver = new FirefoxDriver();
        //关闭浏览器
        Thread.sleep(5000);    //等待5秒
//        driver.close();        //但chromedriver不关闭,只是关闭当前窗口
        driver.quit();          //完全退出，关闭所有窗口并退出
    }
}
