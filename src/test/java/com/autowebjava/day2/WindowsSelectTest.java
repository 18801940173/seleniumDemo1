package com.autowebjava.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.*;

/**
 * Created by sundongfeng on 2018/12/19
 */
public class WindowsSelectTest {
    WebDriver driver;

    @BeforeMethod
    //打开Chrome浏览器
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    /**
     * 打开测试页面
     * 点击Open new window
     * 点击baidu
     */
    @Test
    public void testWin() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        sleep(3000);
        String handle1 = driver.getWindowHandle();
        for (String handles:driver.getWindowHandles()) {
            if (handles.equals(handle1)){
                continue;
            }else {
                driver.switchTo().window(handles);
            }
        }
        driver.findElement(By.linkText("baidu")).click();
    }

    @AfterMethod
    //关闭浏览器
    public void closeChrome(){
        driver.quit();
    }
}
