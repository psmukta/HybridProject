package operations;

import java.io.File;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UIOperation extends AbsClass{
	
	public UIOperation(WebDriver driver) {
		this.driver=driver;
	}
	
	public void KeyWordPerform(Properties p, String keyWord, String ObjectName, String ObjectType, String data) throws Exception {
		switch(keyWord.toUpperCase()) {
		
		case "GOTOURL":
			driver.get(p.getProperty(data));
			break;
		case "SENDKEYS":
			driver.findElement(this.getObject(p, ObjectName, ObjectType)).sendKeys(data);
			break;
		case "CLICK":
			driver.findElement(this.getObject(p, ObjectName, ObjectType)).click();
			break;
			
		case "GETTEXT":
			String text=driver.findElement(this.getObject(p, ObjectName, ObjectType)).getText();
			System.out.println("Text is : "+text);
			break;
		case "GETTYPEDTEXT":
			String typedText=driver.findElement(this.getObject(p, ObjectName, ObjectType)).getAttribute("value");
			System.out.println("Typed Text is: "+typedText);
			
		case "GETTITLE":
			driver.get(p.getProperty(data));
			String GetTitle=driver.getTitle();
			System.out.println("Title is" +GetTitle);
			break;
		case"ACTIONS":
			WebElement SM=driver.findElement(this.getObject(p, ObjectName, ObjectType));
			Actions act=new Actions(driver);
			act.moveToElement(SM).build().perform();
			break;
		case"GETPAGESOURCE":
			driver.get(p.getProperty(data));
			String PS=driver.getPageSource();
			break;
		case "SCREENSHOT":
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File(System.getProperty("user.dir")+"\\"+"CaptureShot\\Screenshot1.png"));
			break;
		case "CLOSE":
			driver.close();
			break;	
		case "THREAD":
			Thread.sleep(4000);
		}
		
	}
	private By getObject(Properties p,  String ObjectName, String ObjectType) throws Exception {
		if(ObjectType.equalsIgnoreCase("ID")) {
			return By.id(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("NAME")) {
			return By.name(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("XPATH")) {
			return By.xpath(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("CLASSNAME")) {
			return By.className(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("TAGNAME")) {
			return By.tagName(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("CSSSELECTOR")) {
			return By.cssSelector(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("LINKTEXT")) {
			return By.linkText(p.getProperty(ObjectName));
		}
		else if(ObjectType.equalsIgnoreCase("PARTIALLINKTEXT")) {
			return By.partialLinkText(p.getProperty(ObjectName));
		}
		else {
			throw new Exception("Wrong object type");
		}
		
	}

}
