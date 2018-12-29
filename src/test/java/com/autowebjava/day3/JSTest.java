package com.autowebjava.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sundongfeng on 2018/12/24
 */
public class JSTest {
    WebDriver driver;

    @BeforeMethod
    //打开Chrome浏览器
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //打開JS
    @Test
    public void exJsTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('kw').setAttribute('value','webdriver')");
//        Thread.sleep(3000);
    }

    @AfterMethod
    //关闭浏览器
    public void closeChrome() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
