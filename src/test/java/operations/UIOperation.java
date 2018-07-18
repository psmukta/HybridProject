package operations;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
