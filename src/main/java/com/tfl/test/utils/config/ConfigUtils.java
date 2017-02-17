package com.tfl.test.utils.config;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DON'T ADD ANY PROJECT SPECIFIC UTILS HERE
 * 
 * THIS IS FOR FRAMEWORK CONFIGURATION ONLY
 */
public class ConfigUtils implements ConfigFileName{

	/**
	 * TEAMCITY CONFIGS SHOULD OVERRIDE OUR LOCAL CONFIGS
	 */
	//Used by CI to determine which ENV and Browser to run tests on
	public static String TargetAPIEndPoint = System.getenv("TARGET_API_END_POINT");
	public static String TargetWebEndPoint = System.getenv("TARGET_WEB_END_POINT");
	public static String TargetTestBrowser = System.getenv("TARGET_TEST_BROWSER");
	public static String GeneratePrettyReports = System.getenv("GENERATE_PRETTY_REPORTS");
	public static String WhichEnv = System.getenv("TARGET_WEB_END_POINT_NAME");
	
	public static final boolean CLOSE_BROWSER_AFTER_TEST = true;


	private static Properties prop = null;
	
    /**
     * Read properties file which contains the base url, api endpoint details
     * This is to allow us to change environments quickly
     * Simply update : current.env to tst01, dev02, dev02, staging etc
     */
    public static Properties getProjectProperties(){
    	
    	if(prop == null){
	    	try {
	    		String res = new File("").getAbsolutePath() + File.separatorChar + "resources" + File.separatorChar + CONFIG_PROPERTIES_FILE_NAME;
	    		InputStream input = new FileInputStream(res);
	    		prop = new Properties();
	    		prop.load(input);
	 
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	        }
    	}
    	
    	return prop;
    }
    

    
	/**
	 * 
	 * @param driver
	 * @param amount
	 */
	public static void scrollDown(WebDriver driver, int amount) {
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0," + amount + ")", "");
	}
	
	/**
	 * Get a specific property value from our config file
	 * @param property
	 * @return
	 */
	public static String getASpecificProperty(String property) {
		String specifiedProperty = null;
		try {
			Properties prop = getProjectProperties();
			specifiedProperty = prop.getProperty(property);

		} catch (Exception e) {
			specifiedProperty = null;
		}

		return specifiedProperty;
	}


	/**
	 * Returns a logger based on the class name
	 * @param class1
	 * @return
	 */
	public static Logger getLogger(Class<?> class1) {
		PropertyConfigurator.configure("log4j.properties");
		Logger log = LoggerFactory.getLogger(class1.getSimpleName());
		
		return log;
	}


	/**
	 * Which browser to test on
	 * @return
	 */
	public static String getBrowerToTestOn() {
		String defaultBrowser = "";
		if(TargetTestBrowser != null){
			//This is for CI integration
			defaultBrowser = TargetTestBrowser;
		}else{
			defaultBrowser = ConfigUtils.getASpecificProperty("env.driver.browser");
		}
		return defaultBrowser;
	}


    /**
     * Get web endpoint base url
     * http://www.tfl.gov.uk/
     * @return
     */
	public static String getWebEndPoint() {
		if (TargetWebEndPoint == null) {
			try {
		        Properties prop = getProjectProperties();
		        String env = prop.getProperty("env.current");
		        if(WhichEnv != null){
		        	env = WhichEnv;
		        }
		        TargetWebEndPoint = prop.getProperty("env.url." + env);
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
		return TargetWebEndPoint;
	}
	

	/**
     * This will only be called if we have not set the TARGET_API_END_POINT 
     * or we have nullified it by : setx TARGET_API_END_POINT ""
     * 
     * This way we don't have to change our code everytime we want to change environment
     * Change env.current to tst01,dev01,dev02,staging etc and the correct end point should be 
     * selected with no change to our code
     * 
     * TeamCity will have TargetAPIEndPoint set therefore will not read properties file
     * 
     * Assumes key format = env.api.YOUR_SPECIFIC_ENV
     * 
     * http://api.tfl.gov.uk:8001/
     * @return
     */
    public static String getAPIEndPoint() {
    	//This is added to help with adding some flexibility to our testing - setx TARGET_API_END_POINT "" - this will nullify TARGET_API_END_POINT
    	if(TargetAPIEndPoint == null){
            try {
                Properties prop = ConfigUtils.getProjectProperties();
                String env = prop.getProperty("env.current");
                TargetAPIEndPoint = prop.getProperty("env.api." + env);
            } catch (Exception e) {
                TargetAPIEndPoint = null;
            }
    	}
        return TargetAPIEndPoint;
    }
	
	/**
	 * If you would like to generate pretty reports than either set GeneratePrettyReports
	 * or report.generate.pretty.report in our test.properties file
	 * @return
	 */
	public static String getGeneratePrettyReport(String property) {
		if (GeneratePrettyReports == null) {
			try {
				Properties prop = getProjectProperties();
				GeneratePrettyReports = prop.getProperty(property);
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
		return GeneratePrettyReports;
	}
	
	/**
	 * Creates a new url from : baseUrl+sectionURL
	 * On test.properties add an entry like : 
	 * env.section.url.lez=abc/def/ghi/lez.html or something like that
	 * 
	 * @param section : lez, cst, ccs, or whatever you put in the properties file
	 * @return
	 */
	public static String getWebURLIncludingSpecifiedSection(String section) {
		String targetpoint = null;
		try {
			String baseUrl = getWebEndPoint();
			String sectionId = getSectionKey(section);
			Properties prop = getProjectProperties();
			String sectionUrl = prop.getProperty(sectionId);
			targetpoint = baseUrl + sectionUrl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return targetpoint;
	}

	
	/**
	 * Creates a new url from : baseUrl+sectionURL
	 * On test.properties add an entry like : 
	 * env.section.url.lez=abc/def/ghi/lez.html or something like that
	 * 
	 * @param section : lez, cst, ccs, or whatever you put in the properties file
	 * @return
	 */
	public static String getAPIURLIncludingSpecifiedSection(String section) {
		String targetpoint = null;
		try {
			String baseUrl = getAPIEndPoint();
			String sectionId = getSectionKey(section);
			Properties prop = getProjectProperties();
			String sectionUrl = prop.getProperty(sectionId);
			targetpoint = baseUrl + sectionUrl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return targetpoint;
	}

	/**
	 * section url key should follow a specific pattern
	 * env.section.url.apage=
	 * env.section.url.cst1=
	 * @param section
	 * @return
	 */
	private static String getSectionKey(String section) {
        String sectionId = "env.section.url." + section;
		return sectionId;
	}

}
