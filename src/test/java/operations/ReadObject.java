package operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadObject {
	Properties p=new Properties();
	
	public Properties getObjectRepository() throws IOException {
		
		File f=new File(System.getProperty("user.dir")+"\\src\\test\\java\\objects\\Object1.properties");
		FileInputStream fis=new FileInputStream(f);
		p.load(fis);
		return p;
	}
	

}
