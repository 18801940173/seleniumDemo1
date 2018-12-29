package com.autowebjava.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.*;

/**
 * Created by sundongfeng on 2018/12/19
 */
public class AlertsTests {
    WebDriver driver;

    @BeforeMethod
    //打开Chrome浏览器
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开“UI自动化测试”页面
     * 点击Alert按钮
     * 在alert警告框点击确定按钮
     */
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        sleep(3000);
        driver.findElement(By.className("alert")).click();
        //把控制权转交给alert
        Alert alert = driver.switchTo().alert();
        //获取警告框的文本值
        String text = alert.getText();
        sleep(3000);
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
        sleep(3000);
    }

    /**
     * 打开“UI自动化测试”页面
     * 点击Confirm按钮
     * 在Confirm警告框点击取消按钮
     * 再次点击确定按钮
     */
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        //把控制权转交给alert
        Alert alert = driver.switchTo().alert();
        sleep(3000);
        //点击取消
        alert.dismiss();
        sleep(3000);
        //点击确定
        alert.accept();
        sleep(3000);
    }

    /**
     *  打开“UI自动化测试”页面
     *  点击Prompt按钮
     *  在Prompt弹窗中，输入“这是个Prompt”
     *  点击确定按钮
     *  再次点击确定按钮
     */
    @Test
    public void promptTest() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Alert alert = driver.switchTo().alert();
        sleep(3000);
        alert.sendKeys("这是个Prompt");        //chromeDriver的bug这里无法输入进去
        sleep(3000);
        alert.accept();
        sleep(3000);
        alert.accept();
        sleep(3000);
        driver.quit();
    }

    /**
     * 打开测试页面
     * 点击百度链接
     * 点击登陆界面
     */
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        sleep(3000);
//        //通过ID或者name方式 转交控制权
//        driver.switchTo().frame("aa");
//        driver.findElement(By.linkText("baidu")).click();
//        sleep(3000);
        //通过webelement方式
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("baidu")).click();
        sleep(3000);

        //driver 控制权转交给原来的节目
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面")).click();
        sleep(3000);
    }
    @AfterMethod
    //关闭浏览器
    public void closeChrome(){
        driver.quit();
    }
}
