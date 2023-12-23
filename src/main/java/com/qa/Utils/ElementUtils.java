package com.qa.Utils;

import com.qa.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ElementUtils extends TestBase {
	private static HttpURLConnection httpConnection;
	private static String response;

	// This method fetches element height
	public static int getElementHeight(WebElement element, String elementName) {
		int elementHeight = element.getSize().getHeight();
		log("info", elementName + " field height is " + "<b>" + elementHeight);
		return elementHeight;
	}

	// This method fetches element width
	public static int getElementWidth(WebElement element, String elementName) {
		int elementWidth = element.getSize().getWidth();
		log("info", elementName + " field width is " + "<b>" + elementWidth);
		return elementWidth;
	}

	// This method fetches element location
	public static Point getElementLocation(WebElement element, String elementName) {
		Point elementLocation = element.getLocation();
		log("info", elementName + " field location is " + "<b>" + elementLocation);
		return elementLocation;
	}

	// This method fetches element x-coordinate
	public static int getElementXCoordinate(WebElement element, String elementName) {
		int xCoordinate = element.getLocation().getX();
		log("info", elementName + " field X-Coordinate is " + "<b>" + xCoordinate);
		return xCoordinate;
	}

	// This method fetches element y-coordinate
	public static int getElementYCoordinate(WebElement element, String elementName) {
		int yCoordinate = element.getLocation().getX();
		log("info", elementName + " field Y-Coordinate is " + "<b>" + yCoordinate);
		return yCoordinate;
	}

	// This method verifies broken links on a page
	public static void brokenLinks() {
		List<WebElement> linkList = getDriver().findElements(By.tagName("a"));
		List<WebElement> activeLinks = new ArrayList<>();
		for (int i = 0; i <= linkList.size() - 1; i++) {
			System.out.println(linkList.get(i).getAttribute("href"));
			if (linkList.get(i).getAttribute("href") != null
					&& (!linkList.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linkList.get(i));
			}
		}
		log("info", "Size of active links: " + activeLinks.size());

		for (int j = 0; j <= activeLinks.size() - 1; j++) {
			try {
				httpConnection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
				httpConnection.setRequestProperty("javax.net.ssl.keyStore", "./src/main/resources");
				httpConnection.setRequestProperty("javax.net.ssl.keyStorePassword", "changeit");
				httpConnection.setRequestProperty("javax.net.ssl.keyStoreType", "JKS");
				httpConnection.setRequestProperty("javax.http.ssl.insecure", "true");
				httpConnection.setRequestProperty("jdk.security.allowNonCaAnchor", "true");
				httpConnection.connect();
				response = httpConnection.getResponseMessage();
				httpConnection.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (response.contains("OK")) {
				log("pass", "All links are active");
				Assert.assertTrue(true);
			} else {
				log("fail", "Following links are broken" + activeLinks.get(j).getAttribute("href") + " - " + response);
				Assert.assertTrue(false);
			}
		}
	}

	// This method verifies broken links on a page
	public static void brokenImages() {
		List<WebElement> imageList = getDriver().findElements(By.tagName("img"));
		List<WebElement> activeImages = new ArrayList<>();
		for (int i = 0; i <= imageList.size() - 1; i++) {
			System.out.println(imageList.get(i).getAttribute("img"));
			if (imageList.get(i).getAttribute("alt") != null && (imageList.get(i).getAttribute("src") != null)) {
				activeImages.add(imageList.get(i));
			}
		}
		log("info", "Size of active links: " + activeImages.size());
		for (int j = 0; j <= activeImages.size() - 1; j++) {
			try {
				httpConnection = (HttpURLConnection) new URL(activeImages.get(j).getAttribute("src")).openConnection();
				httpConnection.connect();
				response = httpConnection.getResponseMessage();
				System.out.println(activeImages.get(j).getAttribute("src") + response);
				httpConnection.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (response.contains("OK")) {
				log("pass", "All links are active");
				Assert.assertTrue(true);
			} else {
				log("fail", "Following links are broken" + activeImages.get(j).getAttribute("src") + " - " + response);
				Assert.assertTrue(false);
			}
		}
	}

}
