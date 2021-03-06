package com.tsrtc.base;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.tsrtc.utils.CommonUtil;
import com.tsrtc.utils.DataBaseUtil;
import com.tsrtc.utils.DateUtil;
import com.tsrtc.utils.ExcelUtil;
import com.tsrtc.utils.PerformActionsUtil;
import com.tsrtc.utils.PropertiesUtil;
import com.tsrtc.utils.RandomDataUtil;
import com.tsrtc.utils.ReportUtil;
import com.tsrtc.utils.BrowserUtil;
import com.tsrtc.utils.DirectoryUtil;

/**
 * This is the base class for all the test classes
 * 
 * @author vgeesidi
 *
 */
public abstract class TsrtcBase {

	protected static Logger logger = Logger.getLogger(TsrtcBase.class);

	protected PropertiesUtil propertiesUtil = new PropertiesUtil();
	protected CommonUtil commonUtil = new CommonUtil();
	protected RandomDataUtil randomDataUtil = new RandomDataUtil();
	protected ExcelUtil excelUtil = new ExcelUtil();
	protected DateUtil dateUtil = new DateUtil();
	protected DataBaseUtil dataBaseUtil = new DataBaseUtil();
	protected ReportUtil reportUtil = new ReportUtil();
	protected BrowserUtil browserUtil = new BrowserUtil();
	protected PerformActionsUtil performActionsUtil;
	
	private DirectoryUtil directoryUtil = new DirectoryUtil();

	public WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		DOMConfigurator.configure("C:\\Users\\ptg\\workspace\\UIAutomation\\src\\log4j.xml");
		directoryUtil.removeExistingLogFile();
		
		propertiesUtil.initProperties();
		driver = browserUtil.openBrowser(PropertiesUtil.browserName,
				PropertiesUtil.url);
		performActionsUtil = new PerformActionsUtil(driver);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(5000);
		// driver.close();
		driver.quit();
	}

	@DataProvider
	public Object[][] getData(ITestContext context) {
		Object[][] excelData = excelUtil.getData(context);
		 return excelData;
	}
}