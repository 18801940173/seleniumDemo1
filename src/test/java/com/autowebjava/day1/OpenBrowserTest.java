package com.autowebjava.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by sundongfeng on 2018/12/13
 */
public class OpenBrowserTest {
    @Test             //如果默认安装火狐到C盘，可以用此方法打开浏览器
    public void openFF(){
        WebDriver webDriver = new FirefoxDriver();
    }
    @Test
    public void OpenBrowserTest2(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }
    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        WebDriver webDriver  = new ChromeDriver();
    }
}
