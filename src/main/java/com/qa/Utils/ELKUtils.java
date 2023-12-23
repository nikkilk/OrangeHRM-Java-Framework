package com.qa.Utils;

import java.util.HashMap;
import java.util.Map;

import com.qa.Base.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ELKUtils extends TestBase {

	private ELKUtils() { }

	public static void realTImeDashboard(String testName, String status) {
		if(Boolean.parseBoolean(prop.getProperty("RealTimeDashboard"))) {
			Map<String, String> hm = new HashMap<>();
			hm.put("name", testName);
			hm.put("status", status);

			RestAssured.useRelaxedHTTPSValidation();
			Response response = RestAssured.given().auth().preemptive().basic("elastic", "-xEU1jPemAmnyMk4K_7G").header("Content-Type", "application/json").log().all().body(hm)
					.post("https://localhost:9200/result/_doc/");
			//	response.prettyPrint();
		}
	}
}
