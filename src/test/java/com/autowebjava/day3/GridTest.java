package com.autowebjava.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by sundongfeng on 2018/12/27
 */
public class GridTest {
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        //创建一个DesiredCapabilities类型
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //实例化一个driver
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.11.32:6666/wd/hub"),dc);

        driver.get("http://www.baidu.com");
        Thread.sleep(8000);
        driver.quit();
    }

    //数据驱动
    @DataProvider(name = "data1")
    public Object[][] test1(){
                return new Object[][]{
                {"firefox","http://192.168.11.32:6666/wd/hub"},
                {"chrome","http://192.168.11.32:5555/wd/hub"}};
    }

    @Test(dataProvider = "data1")
    public void testGrid2(String browser,String url) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;
        if (browser.contentEquals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else if (browser =="chrome"){
            dc = DesiredCapabilities.chrome();
        }else{
            System.out.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL(url),dc);

        driver.get("http://www.baidu.com");
        Thread.sleep(8000);
        driver.quit();
    }

}
