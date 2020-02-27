package com.impactiva.smoke.lib;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotTaker {
 public static String captureScreenshot(WebDriver driver, String screenShotName){
	 try {
		TakesScreenshot ts = (TakesScreenshot)driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 String dest  = "./reports/screenshots/"+screenShotName+".png";
		 FileUtils.copyFile(source, new File(dest) );
		 System.out.println("Printout taken");
		 return dest;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Exception while taking screen shot"+e.getMessage());
		e.printStackTrace();
		return e.getMessage();
 }
	
}
}
