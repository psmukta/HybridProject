package operations;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbsClass {
	 protected WebDriver driver;
	@BeforeTest
	public void SetUp() {
		//System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
		//WebDriverManager.iedriver().setup();
		driver.manage().window().maximize();
	}
	//@AfterTest
	public void teardown() {
		driver.quit();
	}
}



