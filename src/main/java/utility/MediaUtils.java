package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class MediaUtils {
	public static String absolutePath;
	
	public static void takeScreenshotAndSave(WebDriver driver, String subFolder, String methodName) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("Screenshots/" + subFolder + "/" + methodName + "_" + DateUtils.getDate()+".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
			absolutePath = destFile.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String takeScreenshot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}

}
