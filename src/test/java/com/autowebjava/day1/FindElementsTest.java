package com.autowebjava.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

/**
 * Created by sundongfeng on 2018/12/17
 */
public class FindElementsTest {
    WebDriver driver;
    @BeforeMethod
    public void cpenChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开百度页面
     * 通过ID定位搜索文本框
     */
    @Test
    public void byIdTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement keyField =  driver.findElement(By.id("kw"));
        keyField.sendKeys("中国");
        Thread.sleep(3000);
    }

    /**
     * 打开百度页面
     * 通过name定位搜索文本框
     */
    @Test
    public void byNameTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement keyField = driver.findElement(By.name("wd"));
        keyField.sendKeys("中国");
        Thread.sleep(3000);
    }

    /**
     * 打开百度页面
     * 通过class定位搜索文本框
     */
    @Test
    public void byClassTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField = driver.findElement(By.className("fm"));
    }
    /**
     * 打开百度页面
     * 通过LinkText定位搜索文本框
     */
    @Test
    public void byLinkTextTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField = driver.findElement(By.linkText("新闻"));
    }
    /**
     * 打开百度页面
     * 通过partialLinkText定位搜索文本框
     */
    @Test
    public void byPartLinkTextTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField = driver.findElement(By.partialLinkText("闻"));
    }

    @Test
    public void byXpathsTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField = driver.findElement(By.xpath("//*[@id=\"u1\"]/a"));
        System.out.println(keyField.getText());
//        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"u1\"]/a"));
//        for (int i = 0; i < list.size(); i++) {
//            String text = list.get(i).getText();
//            System.out.println(text);
//        }

    }
    /**
     * 打开百度页面
     * 通过tagName定位搜索文本框(因为此种方法找出来基本不是一个所以，用findElements)
     */
    @Test
    public void byTagNameTest(){
        driver.get("https://www.baidu.com");
        List<WebElement> list = driver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }
    /**
     * 打开百度页面
     * 通过xPath定位百度一下按钮
     */
    @Test
    public void byXpathTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField = driver.findElement(By.xpath("//*[@id=\"su\"]"));
    }
    /**
     * 打开百度页面
     * 通过cssSelector定位百度图片
     */
    @Test
    public void byCssSelectorTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
//        WebElement keyField = driver.findElement(By.cssSelector("#lg>img"));
        WebElement keyField = driver.findElement(By.cssSelector("#lg > img.index-logo-src"));

//        keyField.click();
//        Thread.sleep(3000);
    }
    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
