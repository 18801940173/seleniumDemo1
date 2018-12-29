package com.autowebjava.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

/**
 * Created by sundongfeng on 2018/12/24
 */
public class PhantomJsTest {
    @Test
    public void pjsProperty() throws InterruptedException {
        System.setProperty("phantomjs.binary.path","E:\\Selenium_Demo01\\drivers\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();

        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");
        Thread.sleep(3000);
        String a = driver.getTitle();
        System.out.println(a);
        driver.quit();
    }
}
