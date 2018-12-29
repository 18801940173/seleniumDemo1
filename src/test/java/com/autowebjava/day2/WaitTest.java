package com.autowebjava.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.print.attribute.standard.Destination;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

/**
 * Created by sundongfeng on 2018/12/20
 */
public class WaitTest {
    WebDriver driver;

    @BeforeMethod
    //打开Chrome浏览器
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开测试页面
     * 点击wait按钮
     * 获取文本，并判断是否为“wait for display"
     */
    @Test
    public void waitTest() throws InterruptedException {
//        Dimension dimension = new Dimension(8000,800);
//        driver.manage().window().setSize(dimension);
        driver.manage().window().maximize();
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
//        //线程等待
//        Thread.sleep(1000);
//        //全局等待
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //显示等待
        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));

        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");
        sleep(3000);
    }
    @AfterMethod
    //关闭浏览器
    public void closeChrome(){
        driver.quit();
    }
}
