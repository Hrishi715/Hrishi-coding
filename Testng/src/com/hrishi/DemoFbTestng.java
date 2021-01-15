package com.hrishi;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoFbTestng 
{
WebDriver driver;

@BeforeSuite
public void openbrowser()
{
System.out.println("OPEN BROWSER");	
System.setProperty("webdriver.chrome.driver", "D:\\BrowserSoft\\chromedriver.exe");
driver=new ChromeDriver();
}

@BeforeTest
public void openappurl()
{
System.out.println("OPEN APP URL");	
driver.get("https://www.facebook.com/");
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

@AfterMethod
public void capturescreenshot() throws IOException
{
	System.out.println("AFTER METHOD SCREENSHOT");
File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src, new File("D:\\Screenshots\\Fb.png"));
System.out.println("succesfully took");
}

@AfterClass
public void deletecookies()
{
	System.out.println("AFTERCLASS DELETE COOKIE");
driver.manage().deleteAllCookies();	
}

@AfterTest
public void dbclose()
{
System.out.println("AFTER TEST CLOSE");	
driver.close();
}

@AfterSuite
public void closebrowser()
{
System.out.println("AFTER SUITE QUIT");
driver.quit();
}
}
