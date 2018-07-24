package com.tsrtc.utils;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * 
 * This class is used to handle directory util
 * 
 * @author Venkat
 *
 */
public class DirectoryUtil {

	private Logger logger = Logger.getLogger(DirectoryUtil.class);

	/**
	 * 
	 * This method is used to remove existing log file
	 * 
	 */
	public void removeExistingLogFile() {
		String filePath = "C:\\Users\\ptg\\workspace\\UIAutomation\\Tsrtc.log";
		try {
			File file = new File(filePath);
			if (file.exists()) {
				if (file.delete()) {
					logger.info("File deleted successfully");
				} else {
					logger.info("File is not deleted");
				}
			}
		} catch (Exception exception) {
			logger.error(exception);
		}
	}
}
