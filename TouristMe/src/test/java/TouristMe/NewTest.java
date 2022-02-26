package TouristMe;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("http://localhost:8090/TouristMe/ShowListing");  
	  driver.findElement(By.linkText("Login")).click();
	  driver.get("http://localhost:8090/TouristMe/ShowListing");  
	  driver.findElement(By.linkText("Register")).click();
	  driver.get("http://localhost:8090/TouristMe/ShowListing");  
	  driver.findElement(By.linkText("Booking")).click();
	  driver.get("http://localhost:8090/TouristMe/ShowListing"); 
	  
	  //check if the routing is working correctly
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
