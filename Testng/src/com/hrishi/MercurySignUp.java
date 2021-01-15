package com.hrishi;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import org.testng.annotations.Test;

public class MercurySignUp 
{
WebDriver driver;
@BeforeSuite
public void openbrowser()
{
System.out.println("OPEN BROWSER");	
System.setProperty("webdriver.chrome.driver", "D:\\BrowserSoft\\chromedriver.exe");
driver=new ChromeDriver();
System.out.println("succesfully open browser");
}

@BeforeTest
public void openappurl()
{
System.out.println("OPEN APP URL");	
driver.get("http://demo.guru99.com/test/newtours/index.php");
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

@Test(dataProvider = "getdata")
public void register(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l)
{
System.out.println("Hello REGISTERBUDDY");

driver.findElement(By.linkText("REGISTER")).click();
driver.findElement(By.name("firstName")).sendKeys(a);
driver.findElement(By.name("lastName")).sendKeys(b);
driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(c);
driver.findElement(By.id("userName")).sendKeys(d);
driver.findElement(By.name("address1")).sendKeys(e);
driver.findElement(By.xpath("//input[@name='city']")).sendKeys(f);
driver.findElement(By.xpath("//input[@name='state']")).sendKeys(g);
driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(h);
WebElement cntry=driver.findElement(By.name("country"));
cntry.sendKeys(i);
cntry.sendKeys(Keys.DOWN);
driver.findElement(By.xpath("//input[@id='email']")).sendKeys(j);
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(k);
driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(l);
driver.findElement(By.xpath("//input[@name='submit']")).click();
//Thread.sleep(5);
driver.findElement(By.linkText("SIGN-OFF")).click();
System.out.println("user has done");
}

@DataProvider
public Object[][] getdata()
{
Object[][] data= new Object[2][12];
//me
data[0][0]="Hrishi";
data[0][1]="Dhote";
data[0][2]="111111";
data[0][3]="abc@123";
data[0][4]="wardha";
data[0][5]="Wardha";
data[0][6]="mah";
data[0][7]="442001";
data[0][8]="I";
data[0][9]="SSSS";
data[0][10]="ssss";
data[0][11]="ssss";
//2nd user
data[1][0]="Jimmy";
data[1][1]="Dhote";
data[1][2]="22222";
data[1][3]="abc@1234";
data[1][4]="wardha";
data[1][5]="Wardha";
data[1][6]="mah";
data[1][7]="442001";
data[1][8]="I";
data[1][9]="HHHH";
data[1][10]="hhhh";
data[1][11]="hhhh";

return data;
}
@AfterMethod
public void capturescreenshot() throws IOException
{
System.out.println("AFTER METHOD SCREENSHOT");
File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFileToDirectory(src, new File("D:\\Screenshots\\Mercury"));
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