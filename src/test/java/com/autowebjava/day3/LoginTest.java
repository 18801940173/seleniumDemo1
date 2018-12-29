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
 * Created by sundongfeng on 2018/12/25
 */
public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    //打开Chrome浏览器
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void loginSuccess() throws InterruptedException {
        //调用登录
        login(driver,"meyoungtester","meyoung123");

        //显示等待，进行验证
        WebDriverWait wait =new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String logout = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");
    }

    @Test
    public void loginFail(){
        //调用登录
        login(driver,"meyoungtester","meyoung1234");

        //显示等待，进行验证
        WebDriverWait wait =new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        String error = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error,"帐号或密码错误");
    }
    @Test
    public static void login(WebDriver driver,String email,String pwd){
        driver.get("https://mail.163.com/");
        WebElement frame=driver.findElement(By.xpath( "//*[@id=\"loginDiv\"]/iframe[1]" ));
        driver.switchTo().frame(frame);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }
    @AfterMethod
    //关闭浏览器
    public void closeChrome() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
