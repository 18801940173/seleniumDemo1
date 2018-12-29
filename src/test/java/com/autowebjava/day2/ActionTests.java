package com.autowebjava.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static java.lang.Thread.*;
import static org.apache.commons.io.FileUtils.*;

/**
 * Created by sundongfeng on 2018/12/18
 */
public class ActionTests {
    WebDriver driver;

    @BeforeMethod
    //打开Chrome浏览器
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 我要点击百度首页的新闻超链接
     */
    @Test
    public void clickTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        //点击新闻链接click()方法
        driver.findElement(By.linkText("新闻")).click();
        //获取当前页面的url
        String url = driver.getCurrentUrl();
        //校验当前页面是不是新闻页面
        Assert.assertEquals(url,"http://news.baidu.com/");
        sleep(5000);
    }

    /**
     * 打开百度页面
     * 在搜索文本框输入selenium  sendKeys()方法
     * 点击百度一下按钮进行搜索
     * 校验title是否等于“selenium_百度搜索”getTitle()方法
     */
    @Test
    public void sendKeysTest() throws InterruptedException {
        //打开百度页面
        driver.get("https://www.baidu.com");
        //定位文本输入框并输入selenium
        driver.findElement(By.id("kw")).sendKeys("selenium");
        //定位百度一下按钮，并点击
        driver.findElement(By.id("su")).click();
        sleep(3000);
        //校验title是否等于“selenium_百度搜索”
        String title = driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    /**
     * 1、打开百度首页
     * 2、在搜索文本框输入selenium
     * 3、清空搜索输入框
     */
    @Test
    public void clearTest() throws InterruptedException {
        //打开百度页面
        driver.get("https://www.baidu.com");
        //定位文本输入框并输入selenium
        driver.findElement(By.id("kw")).sendKeys("selenium");
        Thread.sleep(3000);
        //清空搜索文本框
        driver.findElement(By.id("kw")).clear();
        Thread.sleep(3000);
    }

    /**
     * 打开百度页面
     * 获取新闻文本
     */
    @Test
    public void getTextTest(){
        //打开百度页面
        driver.get("https://www.baidu.com");
        //获取搜索框的文本，getText()只能获取标签中间的文本需要特别注意
        String text = driver.findElement(By.xpath("//*[@id=\"u1\"]/a[1]")).getText();
        //校验是否是“新闻”
        Assert.assertEquals(text,"新闻");
    }

    /**
     * 打开百度页面
     * 获取文本框的targname
     * 校验是否为input
     */
    @Test
    public void targNameTest(){
        //打开百度页面
        driver.get("https://www.baidu.com");
        //定位元素获取tagName
        String tagName = driver.findElement(By.id("kw")).getTagName();
        //校验是否为input
        Assert.assertEquals(tagName,"input");
    }

    /**
     * 打开百度页面
     * 判断按钮显示的文本值为 百度一下
     */
    @Test
    public void getAttributeTest(){
        //打开百度页面
        driver.get("https://www.baidu.com");
        //定位元素获取getAttribute的value的对应值
        String value = driver.findElement(By.id("su")).getAttribute("value");
        //校验是否等于“百度一下”
        Assert.assertEquals(value,"百度一下");
    }

    /**
     * 打开百度页面
     * 判断是否显示百度一下按钮
     */
    @Test
    public void isDisplayedTest(){
        //打开百度页面
        driver.get("https://www.baidu.com");
        //定位元素获取是否展示
        Boolean bool = driver.findElement(By.id("su")).isDisplayed();
        //校验是否为TRUE
        Assert.assertTrue(bool,"校验一下百度按钮是否显示");

    }

    /**
     * 打开测试页面
     * 判断单选框被选中
     */
    @Test
    public void isSelectedTest(){
        //打开测试页面
        driver.get("https://graph.qq.com/oauth2.0/show?which=Login&display=pc&response_type=code&client_id=101487368&redirect_uri=https%3A%2F%2Fpacaio.match.qq.com%2Fqq%2FloginBack%3Fsurl%3Dhttps%3A%2F%2Fwww.qq.com%2F&state=5b481c68e379d");
        //定位获取单选框是否被选中
        WebElement element = driver.findElement(By.id("select_all"));
//        element.click();
        Boolean bool = element.isSelected();
        //校验是否为True
        Assert.assertTrue(bool);
    }

    /**
     * 打开测试页面
     * 判断登录按钮是否可用
     */
    @Test
    public void isEnabledTest(){
        driver.get("http://123.59.198.72:3000/login.html?call_url=%2Fregister_info.html%3Fid%3D3112706&status=login");
        Boolean bool = driver.findElement(By.id("login-login-btn")).isEnabled();
        Assert.assertTrue(bool);
//        Assert.assertFalse(bool);
    }

    /**
     * 截图百度首页
     */
    @Test
    public void shotTest(){
        driver.get("https://www.baidu.com");
        //
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D://test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    //关闭浏览器
    public void closeChrome(){
        driver.quit();
    }
}
