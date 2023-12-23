package com.qa.Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnMapPage extends TestBase {
	
	public OnMapPage() {

		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//button[@title='Track Live' or @title='ライブ追跡']")
	public WebElement trackLiveBtn;
	
	@FindBy(xpath="//button[@title='Track History' or @title='トラック履歴']")
	WebElement trackHistoryBtn;

}
