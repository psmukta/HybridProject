package operations;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;

public abstract class AbsClass {
	 protected WebDriver driver;
	@BeforeTest
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	//@AfterTest
	public void teardown() {
		driver.quit();
	}
}



