package com.autowebjava.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.*;

/**
 * Created by sundongfeng on 2018/12/19
 */
public class SelectTest {
    WebDriver driver;

    @BeforeMethod
    //打开Chrome浏览器
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开测试页面
     * 下拉框选择vivo
     * 第二次选择huawei
     * 第三次选择iphone
     */
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        WebElement slectEl = driver.findElement(By.id("moreSelect"));
        //实例化 Select 类
        Select select = new Select(slectEl);
        //通过 索引选择下拉框
        select.selectByIndex(2);
        sleep(2000);
        //通过 value值选择下拉框
        select.selectByValue("huawei");
        sleep(2000);
        //通过 文本内容选择下拉框
        select.selectByVisibleText("iphone");
        sleep(2000);
    }
    @AfterMethod
    //关闭浏览器
    public void closeChrome(){
        driver.quit();
    }
}
