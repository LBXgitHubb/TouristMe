package webapp.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AccountTest {
	@Test
	public void f() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// navigate the browser to this url
		driver.get("http://localhost:8090/TouristMe/ShowListing");
		// clicking register.

		driver.findElement(By.id("register")).click();

		driver.findElement(By.name("userName")).sendKeys("mrp");
		driver.findElement(By.name("password")).sendKeys("5YuVy5*-_z^G3j-5");
		driver.findElement(By.name("re-password")).sendKeys("5YuVy5*-_z^G3j-5");

		driver.findElement(By.id("submit")).submit();

		// navigate back to homepage
		driver.get("http://localhost:8090/TouristMe/ShowListing");
		
		//do login logout and delete user

	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}

//driver.findElement(By.name("userName")).sendKeys("hello");