package com.flipkart.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Call_browser {

	static WebDriver driver;
	
	public static WebDriver setupbrowser(String browser){
		
		if(browser.equalsIgnoreCase("firefox")){
			
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\HP\\Desktop\\TECHNICAL_DOCS\\geckodriver-v0.15.0-win64\\geckodriver.exe");	
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
		
	}
	
		else if(browser.equalsIgnoreCase("chrome")){
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			ChromeOptions options=new ChromeOptions();
			options.addArguments("start-maximized");
			
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\chromedriver_win32 (1)\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
			return driver;			
		}
	
      else if(browser.equalsIgnoreCase("ie")){
    	  
    	  
			DesiredCapabilities capabilities=DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities.setCapability("requireWindowFocus",true);
			capabilities.setCapability("disable_popup",true);
			
			System.setProperty("webdriver.ie.driver","C:\\Users\\HP\\Desktop\\TECHNICAL_DOCS\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
			driver=new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			return driver;
		}
		
		return null;
}
	
	public static void geturl(String url){
		
		driver.get(url);
	}
	
	public static void closedriver(){
		
		driver.quit();
	}
	
	public static WebDriver driver(){
		
		return driver;
	}
	
	
	/*public static void main(String[] args) {
		
		
		//WebDriver driver=Call_browser.setupbrowser("firefox");	
		
	}*/
	
}