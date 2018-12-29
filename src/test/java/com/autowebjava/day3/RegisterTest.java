package com.autowebjava.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class RegisterTest {
    WebDriver driver;

    @BeforeMethod
    //打开Chrome浏览器
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void registerTest(){
        driver.get("http://mail.163.com/");
        //控制权转交给iframe
        WebElement frame=driver.findElement(By.xpath( "//*[@id=\"loginDiv\"]/iframe[1]" ));
        driver.switchTo().frame(frame);
        //点击去注册按钮
        driver.findElement(By.id("changepage")).click();
        //获取当前driver所在的handle值
        String handle1 = driver.getWindowHandle();
        //driver切换到新的页面
        for (String handles :driver.getWindowHandles()) {
            if (handles.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handles);
        }
        String time = String.valueOf(System.currentTimeMillis()/100);
        //输入邮件地址
        driver.findElement(By.id("nameIpt")).sendKeys("sdf"+time);
        //输入密码
        driver.findElement(By.id("mainPwdIpt")).sendKeys("sundongfeng0.0");
        //确认密码
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("sundongfeng0.0");
        //输入手机号
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        //输入验证码
        driver.findElement(By.id("vcodeIpt")).sendKeys("123123");
        //输入短信验证码
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("45678");
        //点击立即注册
        driver.findElement(By.id("mainRegA")).click();

        //显示等待，进行验证
        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_mainAcode\"]/span")));
        String error = driver.findElement(By.xpath("//*[@id=\"m_mainAcode\"]/span")).getText();
        Assert.assertEquals(error,"  手机验证码不正确，请重新填写");

    }

    @Test
    public void baiduRegister(){
        driver.manage().window().maximize();
        driver.get("https://pan.baidu.com/");
        driver.findElement(By.xpath("//*[@id=\"login-container\"]/div[3]/div[6]/div/div[4]/a")).click();
        //driver切换到新的页面
        String handle1 = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handles);
        }

        String time = String.valueOf(System.currentTimeMillis()/100);
        //输入电话号码
        driver.findElement(By.id("TANGRAM__PSP_3__phone")).sendKeys(time);
        driver.findElement(By.id("TANGRAM__PSP_3__userName")).sendKeys("sdf"+time);
        driver.findElement(By.id("TANGRAM__PSP_3__password")).sendKeys("sundongfeng0.0");
        driver.findElement(By.id("TANGRAM__PSP_3__verifyCode")).sendKeys("123123");
        driver.findElement(By.id("TANGRAM__PSP_3__isAgree")).click();
        driver.findElement(By.id("TANGRAM__PSP_3__submit")).click();
        //显示等待，进行验证
        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TANGRAM__PSP_3__verifyCodeError")));
        String error = driver.findElement(By.id("TANGRAM__PSP_3__verifyCodeError")).getText();
        Assert.assertEquals(error,"短信激活码错误");

    }

    @AfterMethod
    //关闭浏览器
    public void closeChrome() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
