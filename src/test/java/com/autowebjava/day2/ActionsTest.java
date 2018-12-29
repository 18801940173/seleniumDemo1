package com.autowebjava.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sundongfeng on 2018/12/20
 */
public class ActionsTest {
    WebDriver driver;

    @BeforeMethod
    //打开Chrome浏览器
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\Selenium_Demo01\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
    }

    /**
     * 打开百度页面
     * 在百度一下按钮上右键
     */
    @Test
    public void rightClickTest(){
        driver.get("https://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        //实例化Actions类
        Actions actions = new Actions(driver);
        //右键点击，记住一定要perform（）执行
        actions.contextClick(buttonBaidu).perform();

    }
    /**
     * 打开百度页面
     * 在百度一下按钮上双击
     */
    @Test
    public void doubleClickTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        //实例化Actions类
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        //双击百度一下
        actions.doubleClick(buttonBaidu).perform();
    }

    /**
     * 打开测试页面
     * 鼠标移动到 action 按钮
     * 那么显示 hello world
     * @throws InterruptedException
     */
    @Test
    public void moveMouseTest() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("file:///E:/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        //实例化Actions类
        Actions actions = new Actions(driver);
//        Thread.sleep(3000);
        //鼠标移动到 action 按钮上
        actions.moveToElement(element).perform();       //移动鼠标好像没成功！
        Thread.sleep(5000);
        String hello = driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        System.out.println(hello);
        Assert.assertEquals(hello,"Hello World!");
        driver.quit();
    }

    /**
     * 打开测试页面
     * 拖拽
     * @throws InterruptedException
     */
    @Test
    public void dropTest() throws InterruptedException {
        driver.get("file:///E:/selenium_html/dragAndDrop.html");
        WebElement drag = driver.findElement(By.id("drag"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(drag,200,200).perform();
    }
    @Test
    public void dropTest2(){
        driver.get("file:///E:/selenium_html/dragAndDrop.html");
        WebElement element1 = driver.findElement(By.id("drag"));
        WebElement element2 = driver.findElement(By.xpath("/html/body/h1"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(element1).moveToElement(element2).release().perform();
    }

    /**
     * 打开测试页面
     * 下拉框选中1-3/1、3
     * @throws InterruptedException
     */
    @Test
    public void  selectTest() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        WebElement element1 = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement>  list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        //选中1-3
        actions.keyDown(Keys.SHIFT)
                .click(list.get(0))
                .click(list.get(2))
                .keyUp(Keys.SHIFT)
                .perform();

        //选中1、3
//        actions.keyDown(Keys.CONTROL).click(list.get(2)).keyUp(Keys.CONTROL).perform();

    }

    //Robot类模拟键盘按键
    /**
     * 打开百度页面
     * 按住Ctrl+S
     * 再按Alt+S
     * @throws InterruptedException
     */
    @Test
    public void saveHtml() throws AWTException, InterruptedException {
        driver.get("http://www.baidu.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_ALT);
//        robot.keyPress(KeyEvent.VK_S);

        //释放Ctrl键
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    /**
     * sendKeys实现上传
     * @throws InterruptedException
     */
    @Test
    public void uploadTest(){
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\easecredit19\\Downloads\\1755b805054199424a079af60e8538ce.jpg");
    }

    @Test
    public void downLoadTest() throws InterruptedException {
//        FirefoxProfile firefoxProfile = new FirefoxProfile();
//        //设置火狐的默认下载文件夹，0表示桌面，1表示我的下载，2表示自定义文件夹
//        firefoxProfile.setPreference("browser.download.folderList","2");
//        //设置自定义文件夹位置
//        firefoxProfile.setPreference("browser.download.dir","E:\\test");
//        //设置无需确认下载的文件格式
//        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream,application/vnd.ms-excel,text/csv,application/zip,application/exe,application/apk");
//
//        //打开一个预先设置的火狐
//        WebDriver driver = new FirefoxDriver(firefoxProfile);
//        driver.get("https://pc.qq.com/detail/1/detail_2661.html");
//        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/div[1]/div[3]/a[1]")).click();


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
