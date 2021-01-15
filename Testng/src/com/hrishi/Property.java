package com.hrishi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Property
{
	WebDriver driver;
Properties pro=new Properties();

	@BeforeSuite
	public void openbrowser() throws Exception
	{
	FileInputStream fis=new FileInputStream("D:\\neonworkspace\\Testng\\config.properties");
	pro.load(fis);	
	System.out.println("OPEN BROWSER");	
	System.setProperty("webdriver.chrome.driver", "D:\\BrowserSoft\\chromedriver.exe");
	driver=new ChromeDriver();
	}

	@BeforeTest
	public void openappurl()
	{
	System.out.println("OPEN APP URL");	
	driver.get(pro.getProperty("url"));
	}

	@BeforeClass
	public void appmaximize()
	{
	System.out.println("BEFORE CLASS MAXIMIZE");
	driver.manage().window().maximize();	
	}

	@BeforeMethod
	public void getcookies()
	{
	System.out.println("BEFORE METHOD CCOKIES");
	Set<Cookie> cookies1=driver.manage().getCookies();	
	for (Cookie cookie : cookies1) 
	{
	System.out.println("COOKIE NAME= "+cookie.getName());
	System.out.println("COOKIE DOMAIN= "+cookie.getDomain());
	}
	}

	@Test
	public void signup()
	{
	System.out.println("WELCOME TO TEST FOR SIGNUP");	
	driver.findElement(By.name("firstname")).sendKeys("Hrishi");
	driver.findElement(By.name("lastname")).sendKeys("Dhote");
	driver.findElement(By.name("reg_email__")).sendKeys("rdhote715@gmail.com");
	driver.findElement(By.name("reg_email_confirmation__")).sendKeys("rdhote715@gmail.com");
	driver.findElement(By.name("reg_passwd__")).sendKeys("hrishi77777");
	}

}
