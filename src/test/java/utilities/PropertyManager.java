package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	private static PropertyManager instance ; 
	private  static String firstname; 
	private static String lastname;  
	private static String password; 
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+
            "/resources/configuration.properties";
    
    public static PropertyManager getInstance() {
    	if(instance == null) {
    		synchronized (lock) {
    			instance = new PropertyManager();
    			instance.loadData();
    		}
    	}
    	return instance;
    }
    public void loadData() {
        Properties prop = new Properties();
        try {
        prop.load(new FileInputStream(propertyFilePath));
        }catch(IOException e) {
        	System.out.println("Configuration properties file cannot be found");
			System.out.println(propertyFilePath);
		}
        firstname = prop.getProperty("firstname");
        lastname = prop.getProperty("lastname");
        password = prop.getProperty("password");
    }
	
	public String getFirstname() {
		return firstname ; 
	}
	public String getLastname() {
		return lastname ; 
	}
	public String getPassword() {
		return password ; 
	}
	
}
