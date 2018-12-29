package com.autowebjava.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.rmi.runtime.NewThreadAction;

import static java.lang.Thread.*;

/**
 * Created by sundongfeng on 2018/12/13
 */
public class BrowserActionTest {
    WebDriver driver;
    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    //打开百度
    @Test
    public void getTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        sleep(3000);
    }

    //浏览器后退
    @Test
    public void backTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        //浏览器点击后退
        driver.navigate().back();
        Thread.sleep(3000);
    }

    //浏览器前进
    @Test
    public void forwardTest() throws InterruptedException{
        driver.get("http://www.baidu.com");
        Thread.sleep(1000);
        //浏览器点击后退
        driver.navigate().back();
        Thread.sleep(1000);
        //浏览器点击前进
        driver.navigate().forward();
        Thread.sleep(1000);
    }

    @Test
    //浏览器刷新
    public void Relash() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(1000);
    }

    //设置浏览器大小和最大化
    @Test
    public void winTest() throws InterruptedException {
        //设置窗口大小
        Dimension dimension = new Dimension(200,200);
        driver.manage().window().setSize(dimension);
        Thread.sleep(1000);
        //窗口最大化
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    //获取Url并做验证
    @Test
    public void getUrl() throws InterruptedException {
        driver.get("http://www.baidu.com");
        String url = driver.getCurrentUrl();
        Thread.sleep(1000);
        Assert.assertEquals(url,"https://www.baidu.com/");
        System.out.println(url);
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
