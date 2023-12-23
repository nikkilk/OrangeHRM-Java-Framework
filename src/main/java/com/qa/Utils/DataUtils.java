package com.qa.Utils;

import com.github.javafaker.Faker;
import com.qa.Base.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class DataUtils extends TestBase  {
	public static Faker faker = new Faker(new Locale(prop.getProperty("TestData")));
	public static List<String> clientName;
	public static List<String> userName;
	public static List<String> role;
	public static List<String> serviceProvider;
	public static List<String> simType;
	public static List<String> enDate;
	public static List<String> jaDate;
	public static List<String> vehicleNo;
	public static List<String> unitType;
	
	private static FileInputStream fis;
	private static Workbook wb;
	private static Object data[][];

	
	
	// Read data from ManagementData Yaml file
	public static void ManagementData() {
		clientName = (List<String>) yamlMap.get("ClientName");
		userName = (List<String>) yamlMap.get("UserName");
		role = (List<String>) yamlMap.get("Role");
		serviceProvider = (List<String>) yamlMap.get("ServiceProvider");
		simType = (List<String>) yamlMap.get("SimType");
		enDate = (List<String>) yamlMap.get("EnDate");
		jaDate = (List<String>) yamlMap.get("JaDate");
		vehicleNo = (List<String>) yamlMap.get("VehicleNo");
		unitType = (List<String>) yamlMap.get("UnitType");
	}


	// Read all data from Excel file
	public static Object[][] readExcel() {
		try {
			fis = new FileInputStream("");
		wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int rowCount = wb.getSheetAt(0).getLastRowNum();
		for(int i=0; i<=rowCount; i++) {
			int cellCount = wb.getSheetAt(0).getRow(i).getLastCellNum();
			for(int j=0; j<cellCount; j++) {
//				data[][] = new Object[rowCount][cellCount];
				data[i][j] = wb.getSheetAt(0).getRow(i).getCell(j);
			}
		} 
		return data;
	}

	public static String randomString(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public static String randomInt(int length) {
		return faker.number().digits(length);
	}
	
	public static String randomAlphaNumeric(int length) {
		return faker.lorem().characters(length);
	}

	public static String randomSpecialChars(int length) {
			String specialChars = "!@#$%^&*()_+-=[]{}|;':\",./<>?"; // list of special characters
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			for (int i = 0; i < length; i++) {
				int randomIndex = random.nextInt(specialChars.length());
				char randomChar = specialChars.charAt(randomIndex);
				sb.append(randomChar);
			}
			String randomString = sb.toString();
			return randomString;
		}

	public static String randomAscii(int length) {
		return RandomStringUtils.randomAscii(length);
	}


}
