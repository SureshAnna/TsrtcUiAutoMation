package com.tsrtc.registration.testscripts;

import org.testng.annotations.Test;
import com.tsrtc.base.TsrtcBase;

public class ExcelTest extends TsrtcBase {

	@Test
	public void verifyExcelTest() {
		Object[][] object = new Object[2][1];
		object = excelUtil.readExcelData("C:\\Users\\ptg\\Desktop\\readExcelTest.xlsx", "Sheet1");
	}
}
