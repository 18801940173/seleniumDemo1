package com.autowebjava.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by sundongfeng on 2018/12/24
 */
public class downloadTest {
    WebDriver driver;

    @BeforeMethod
    //打开Chrome浏览器
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
    }
    @Test
    public void downLoadTest() throws InterruptedException {
//        FirefoxProfile firefoxProfile = new FirefoxProfile();
//        //设置火狐的默认下载文件夹，0表示桌面，1表示我的下载，2表示自定义文件夹
//        firefoxProfile.setPreference("browser.download.folderList","0");
//        //设置自定义文件夹位置
//        firefoxProfile.setPreference("browser.download.dir","E:\\test");
//        //设置无需确认下载的文件格式
//        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream,application/vnd.ms-excel,text/csv,application/zip");
//
//        //打开一个预先设置的火狐
//        WebDriver driver = new FirefoxDriver(firefoxProfile);
//        driver.get("https://pc.qq.com/detail/1/detail_2661.html");
//        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/div[1]/div[3]/a[1]")).click();
//        Thread.sleep(200000);
//        driver.quit();


        String downloadFilepath = "E:\\test";
        HashMap<String,Object> chromeProfiles = new HashMap<String, Object>();
        chromeProfiles.put("profile.default_content_settings.popups",2);
        chromeProfiles.put("download.default_directory",downloadFilepath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",chromeProfiles);

        driver = new ChromeDriver(options);
        driver.get("https://pc.qq.com/detail/1/detail_2661.html");
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/div[1]/div[3]/a[1]")).click();
        Thread.sleep(300000);

    }

    @AfterMethod
    //关闭浏览器
    public void closeChrome() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
