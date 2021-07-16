package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFilereader {
	
	
	public static String Projectpath =System.getProperty("user.dir");
	
	
	public  static String getProperties(String property) {
		
		
		Properties prop = new Properties();
		
		try {
			
		
			FileInputStream ip = new FileInputStream(Projectpath+"\\Resources\\Config.properties");
			
			prop.load(ip);
		}
		catch(Exception e) {
			System.out.println("Exception : " + e);
		}

		return prop.getProperty(property);
			
	}

}
