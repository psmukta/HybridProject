package operations;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
		//case "GETTYPEDTEXT":
			//String typedText=driver.findElement(this.getObject(p, ObjectName, ObjectType)).getAttribute("value");
			//System.out.println("Typed Text is: "+typedText);
			//break;
		case "GETTITLE":
			driver.get(p.getProperty(data));
			String GetTitle=driver.getTitle();
			System.out.println("Title is" +GetTitle);
			break;
		case"SUBMENUHANDLING":
			WebElement SubMenu=driver.findElement(this.getObject(p, ObjectName, ObjectType));
			Actions act=new Actions(driver);
			act.moveToElement(SubMenu).build().perform();
			break;
		case"GETPAGESOURCE":
			driver.get(p.getProperty(data));
			String PS=driver.getPageSource();
			break;
		case "SCREENSHOT":
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File(System.getProperty("user.dir")+"\\"+"CaptureShot\\Screenshot2.png"));
			break;
		case "DOUBLECLICK":
			  WebElement DL=driver.findElement(this.getObject(p, ObjectName, ObjectType));
		     Actions action =new Actions(driver);
		     action.doubleClick(DL).build().perform();
		     break;
		     
		case  "HIGHLIGHTANYWEBELEMENT":
			WebElement element=driver.findElement(this.getObject(p, ObjectName, ObjectType));
			JavascriptExecutor jset=((JavascriptExecutor)driver);
			jset.executeScript("arguments[0].style.border='2px solid red'", element);
			break;
		
		case "ALERTHANDLING":
			Alert alt=driver.switchTo().alert();
			alt.accept();
			System.out.println(alt.getText());
			break;
		case "SELECT":
			Select monthSelect=new Select(driver.findElement(this.getObject(p, ObjectName, ObjectType)));
			monthSelect.selectByVisibleText(ObjectName);
			Select daySelect=new Select(driver.findElement(this.getObject(p, ObjectName, ObjectType)));
			daySelect.selectByVisibleText(ObjectName);
			Select yearSelect=new Select(driver.findElement(this.getObject(p, ObjectName, ObjectType)));
			yearSelect.selectByVisibleText(ObjectName);
			break;
		case "HANDLEIFRAME":
			driver.switchTo().frame(driver.findElement(this.getObject(p, ObjectName, ObjectType)));
			break;
		case"GOTOMAINFRAME":
			driver.switchTo().defaultContent();
			break;
		case "FILEUPLOAD":
			driver.findElement(this.getObject(p, ObjectName, ObjectType)).sendKeys(data);
			break;
	  case "CLOSE":
			driver.close();
			break;	
	  case "QUIT":
		  driver.quit();
		  break;
	  case "CLEAR":
	  driver.findElement(this.getObject(p, ObjectName, ObjectType)).clear();
	  break;
		case "THREAD":
			Thread.sleep(4000);
		case "MAINWINDOW":
			ArrayList<String>mainwindow=new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(mainwindow.get(0));
			break;
		case "CHILDWINDOW1":
			ArrayList<String>newtab1=new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newtab1.get(1));
			break;
		case "CHILDWINDOW2":
			ArrayList<String>newtab2=new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newtab2.get(2));
			break;
		case "CHILDWINDOW3":
			ArrayList<String>newtab3=new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newtab3.get(3));
			break;
			
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
