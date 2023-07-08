package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileAndEnv {

	public static Map<String, String> fileandenv = new HashMap<String, String>();

	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static  Map<String,String> envAndFile(){
		
		String environment= System.getProperty("env");
		try {
			if(environment.equalsIgnoreCase("dev")) {
				
				FileInputStream fisdev= new FileInputStream(System.getProperty("user.dir")+"/inputs/dev.properties");
				propMain.load(fisdev);
				fileandenv.put("ServerURL", propMain.getProperty("ServerURL"));
				fileandenv.put("username", propMain.getProperty("username"));
				fileandenv.put("password", propMain.getProperty("password"));

			}else if(environment.equalsIgnoreCase("test"))
			{
				FileInputStream fisqa= new FileInputStream(System.getProperty("user.dir")+"/inputs/test.properties");
				propMain.load(fisqa);
				fileandenv.put("ServerURL", propMain.getProperty("ServerURL"));
				fileandenv.put("username", propMain.getProperty("username"));
				fileandenv.put("password", propMain.getProperty("password"));
			}
		else if(environment.equalsIgnoreCase("testAdmin")) {

			FileInputStream fisqaAdmin= new FileInputStream(System.getProperty("user.dir")+"/inputs/testAdmin.properties");
			propMain.load(fisqaAdmin);
			fileandenv.put("ServerURL", propMain.getProperty("ServerURL"));
			fileandenv.put("username", propMain.getProperty("username"));
			fileandenv.put("password", propMain.getProperty("password"));
		}
		}
		catch (Exception e) {
			
		}
			
		return fileandenv;	
	}
	
	public static Map<String, String> getConfigReader(){
		
		if(fileandenv==null) {
			fileandenv=envAndFile();
		}
		return fileandenv;
		
	}
}
