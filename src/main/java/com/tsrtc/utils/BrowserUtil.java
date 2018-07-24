package com.tsrtc.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 
 * This class is used to launch the browser
 * 
 * @author Venkat
 *
 */
public class BrowserUtil {

	private static Logger logger = Logger.getLogger(BrowserUtil.class);

	/**
	 * This method is used to launch the specific driver
	 * 
	 * @param browserName
	 *            Browser name
	 * @param url
	 *            Url
	 * @return Driver
	 */
	public WebDriver openBrowser(String browserName, String url) {
		WebDriver driver = null;

		try {
			switch (browserName) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\ptg\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\ptg\\workspace\\UIAutomation\\Lib\\IEDriverServer.exe");
				
				DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
				desiredCapabilities.acceptInsecureCerts();
				desiredCapabilities.setJavascriptEnabled(true);
				desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				
				driver = new InternetExplorerDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.firefox.driver",
						"C:\\Users\\ptg\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "gecko-firefox":
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\ptg\\workspace\\UIAutomation\\Lib\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;

			default:
				logger.error("Please supply valid browser name :: {}"
						+ browserName);
			}

			driver.navigate().to(url);
			driver.manage().window().maximize();
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
		return driver;
	}
}
