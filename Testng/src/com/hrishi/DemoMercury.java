package com.hrishi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoMercury
{
WebDriver driver;
@BeforeSuite
public void openbrowser()
{
System.out.println("OPEN BROWSER");	
System.setProperty("webdriver.chrome.driver", "D:\\a\\chromedriver.exe");
driver=new ChromeDriver();
System.out.println("succesfully open browser");
}

@Parameters({"url"})
@BeforeTest
public void openappurl(String urlname)
{
System.out.println("OPEN APP URL");	
driver.get(urlname);
System.out.println("succesfully open url");
}

@BeforeClass
public void appmaximize()
{
driver.manage().window().maximize();	
System.out.println("BEFORE CLASS MAXIMIZE");
}

@BeforeMethod
public void getallcookies()
{
System.out.println("BEFORE METHOD CCOKIES");
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
Set<Cookie> cookies1=driver.manage().getCookies();	
for (Cookie cookie : cookies1) 
{
System.out.println("COOKIE NAME= "+cookie.getName());
}
}

@Parameters({"username","password"})
@Test
public void loginwithvaliddata(String uname,String pass)
{
System.out.println("This is Test Method");
driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname);
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
driver.findElement(By.xpath("//input[@name='submit']")).click();
driver.findElement(By.linkText("SIGN-OFF")).click();
System.out.println("user has done");
}


@Parameters({"username1","password1"})
@Test
public void loginwithvaliddata1(String uname,String pass)
{
System.out.println("This is Test Method");
driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname);
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
driver.findElement(By.xpath("//input[@name='submit']")).click();
driver.findElement(By.linkText("SIGN-OFF")).click();
System.out.println("user has done");
}


@AfterMethod
public void capturescreenshot() throws IOException
{
System.out.println("AFTER METHOD SCREENSHOT");
File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFileToDirectory(src, new File("D:\\Screenshots\\Output"));
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
