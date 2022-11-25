package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBaseCucumber {

    public static WebDriver driver;
    public static Properties prop;

    static String configpath=System.getProperty("user.dir")+"\\src\\test\\java\\configuration\\config.properties"; // to get path for config properties file


    public TestBaseCucumber() throws IOException {
        prop=new Properties();
        FileInputStream file=new FileInputStream(configpath);
        prop.load(file);

    }


    public static void startdriver()  //this initilization method before any test
    {

        if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new FirefoxDriver();
        }
        driver.get(prop.getProperty("URL"));           //to get url from config.properties and open it in browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //implicit wait to make page load and element
        driver.manage().window().maximize();              //to maximize window
//        Dimension size=new Dimension(1024,768);
//        driver.manage().window().setSize(size);
    }
}
