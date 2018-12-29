package com.autowebjava.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sundongfeng on 2018/12/26
 */
public class SendEmailTest {
    WebDriver driver;

    @BeforeMethod
    //打开Chrome浏览器
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void sendEmailTest() throws InterruptedException {
        //调用登录
        LoginTest.login(driver,"meyoungtester","meyoung123");
        //显示等待
        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")));

        //点击写信按钮
        driver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
        //输入收件人
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("18801940173@163.com");
        //填写主题
        driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("测试主题");
        //添加附件
        driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\easecredit19\\Downloads\\1755b805054199424a079af60e8538ce.jpg");
        Thread.sleep(20000);
        //填写文本框内容
        //1.定位iframe
        WebElement frame = driver.findElement(By.className("APP-editor-iframe"));
        //2.转移控制权限
        driver.switchTo().frame(frame);
        //3.定位元素并填写内容
        driver.findElement(By.xpath("/html/body")).sendKeys("测试");
        //4、转交控制权回页面
        driver.switchTo().defaultContent();
//        driver.findElement(By.linkText("发送")).click();
        driver.findElement(By.xpath(".//*[text()=\"发送\"]")).click();

        //校验
//        Boolean bl =  driver.findElement(By.xpath(".//*[text()=\"发送成功\"]")).isDisplayed();
//        Assert.assertTrue(bl);
    }
    @AfterMethod
    //关闭浏览器
    public void closeChrome() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
