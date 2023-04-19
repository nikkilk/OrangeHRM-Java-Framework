package constants;

public class FrameworkConstants {
	
	public static final String currentDirectory = System.getProperty("user.dir");
	
	public static final String configFilePath = currentDirectory + "/src/main/java/config/Config.properties";
	
	public static final String extentReportPath = currentDirectory + "/Reports/ExtentReport/Web Automation Report_";
	
	public static final String successScreenshotPath = currentDirectory + "/Screenshot/Success";
	
	public static final String failureScreenshotPath = currentDirectory + "/Screenshot/Failure";
	
	public static final String skippedScreenshotPath = currentDirectory + "/Screenshot/Skipped";
	
	public static final String credentialsFilePath = currentDirectory + "/src/main/java/testData/Credentials.yml";
	
	public static final String osName = System.getProperty("os.name");
	
    public static final String authorName = System.getProperty("user.name");
    
    public static final String javaVersion = System.getProperty("java.version");
    
    public static final String fileEncoding = System.getProperty("file.encoding");


    // URL parameters
    public static final String GridURL = "http://localhost:4444/";

}
