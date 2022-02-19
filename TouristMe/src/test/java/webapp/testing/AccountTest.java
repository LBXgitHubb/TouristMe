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
		
		// creating 2 new user.
		driver.findElement(By.id("register")).click();

		driver.findElement(By.name("userName")).sendKeys("mrp");
		driver.findElement(By.name("password")).sendKeys("5YuVy5*-_z^G3j-5");
		driver.findElement(By.name("re-password")).sendKeys("5YuVy5*-_z^G3j-5");

		driver.findElement(By.id("submit")).submit();
		
		//route back and create another user
		driver.get("http://localhost:8090/TouristMe/ShowListing");
		
		driver.findElement(By.id("register")).click();
		
		driver.findElement(By.name("userName")).sendKeys("mrbp");
		driver.findElement(By.name("password")).sendKeys("5YuVy5*-_z^G3j-5");
		driver.findElement(By.name("re-password")).sendKeys("5YuVy5*-_z^G3j-5");
		
		driver.findElement(By.id("submit")).submit();
	
		// navigate back to home page and do login
		driver.get("http://localhost:8090/TouristMe/ShowListing");
		
		driver.findElement(By.id("login")).click();
		driver.findElement(By.name("userName")).sendKeys("tim");
		driver.findElement(By.name("password")).sendKeys("5YuVy5*-_z^G3j-5");
		driver.findElement(By.id("submit")).submit();
		
		//routing back to home page click user and delete user
		driver.get("http://localhost:8090/TouristMe/ShowListing");
		
		driver.findElement(By.id("users")).click();
		driver.findElement(By.id("mrp")).click();
		
		//logout
		driver.get("http://localhost:8090/TouristMe/ShowListing");
		driver.findElement(By.id("logout")).click();
		
		

	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}

