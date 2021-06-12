package FB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testfb {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\New folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign up")).click();
		driver.findElement(By.xpath("//*[text()='Mobile Number or Email']")).sendKeys("ddd");
	}
}
