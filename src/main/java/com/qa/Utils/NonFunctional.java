package com.qa.Utils;

import com.qa.Base.DriverFactory;
import com.qa.Base.TestBase;
import org.zaproxy.clientapi.core.ClientApiException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NonFunctional extends TestBase {
	private static Connection dbConnection;
	private static List<Object> list = new ArrayList<>();

	// This method generates zap security report
	public static void zapReport() {
		String title = "FMS V14 Uyeno Web App Security Report " + TestUtils.getDate();
		// traditional-html, traditional-html-plus, risk-confidence-html
		// https://www.zaproxy.org/docs/desktop/addons/report-generation/templates/
		String template = "risk-confidence-html";
		String description = "This is a Zap Security Report";
		String reportFileName = "FMS-V14-Uyeno-Zap-Security-Report " + TestUtils.getDate() + ".html";
		String targetFolder = System.getProperty("user.dir") + "/Reports/SecurityReports";
		if (DriverFactory.api != null) {
			try {
				DriverFactory.apiResponse = DriverFactory.api.reports.generate(title, template, null, description, null,
						null, null, null, null, reportFileName, null, targetFolder, null);
			} catch (ClientApiException e) {
				e.printStackTrace();
			}
		}
	}

	// This method establishes database connection
	public static void connectSQL() {
		System.out.println("Establishing connection to Database");
		String sqlServer = "jdbc:sqlserver://"+prop.getProperty("DBServerName")+":"+prop.getProperty("DBPort")+";"+"databaseName="+prop.getProperty("DBName")+";"+"username="+prop.getProperty("DBUsername")+";"+"password="+prop.getProperty("DBPassword")+";"+"integratedSecurity=false;trustServerCertificate=true";
		// Establish database connection
			try {
				dbConnection = DriverManager.getConnection(sqlServer);
			// Verify connection status
			if (dbConnection.isClosed()) {
				throw new SQLException("Not connected to Database");
			} else {
				System.out.println("Successfully connected to Database");
			}
	} catch(SQLException e) {
		e.printStackTrace();
	}
		}


	// This method executes query and validates data
	public static void selectTableQuery(String query, String name, String value) {
		// Execute query
		try {
		Statement statement = dbConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		System.out.println("result set " + resultSet);
		// Iterate through the data in the result set and display it
		while (resultSet.next()) {
			list.add(resultSet.getObject(name));
		}
		if (list.contains(value)) {
			log("pass", "<b style='color:green'>" + value + " " + name + "</b>" + " is validated in the database");
		} else {
			log("fail", "<span style='color:red'>" + value + " " + name + "</span>" + " is not present in the database");
		}
	} catch(SQLException e) {
			e.printStackTrace();
		}
}

	public static void executeSQLQuery(String tableName, String name, String value) {
		// Execute query
		try {
			PreparedStatement prepareStatement = dbConnection.prepareStatement("select * from "+tableName+" where "+name+"='"+value+"';");
			ResultSet resultSet = prepareStatement.executeQuery();
			// Iterate through the data in the result set and display it
			while(resultSet.next()) {
				System.out.println(resultSet.getString(name));
				if (resultSet.getString(name).contains(value)) {
					log("pass", "<b style='color:green'>" + value + " " + name + "</b>" + " is validated in the database");
				} else {
					log("fail", "<span style='color:red'>" + value + " " + name + "</span>" + " is not present in the database");
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeSQL() {
		TestWaits.threadSleep(2000);
		try {
			if(!dbConnection.isClosed()) {
				//Close the connection
				dbConnection.close();
				System.out.println("Database connection is closed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
