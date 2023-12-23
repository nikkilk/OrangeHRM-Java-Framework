package clients;

import com.qa.Base.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Utils.TestUtils;


public class ClientsAddPageTest extends TestBase {
	
	@BeforeClass
	public void setup() {
		init();
		client.clientsScreen();
		actionsPage.clickAddBtn();
	}
	
	@Test(groups = "functional")
	public void TC_createClient() {
		String alertMessage = client.addAddress();
		TestUtils.assertEquals(alertMessage, prop.getProperty("clientAdded"));
	}
	
	@Test(groups = "functional")
	public void TC_getClient() {
		client.addAddress();
		String actClientName = client.getClientName();
		TestUtils.assertEquals(actClientName, "");
	}
	
	@Test(groups = "functional")
	public void TC_updateClient() {
		String alertMessage = client.addAddress();
		client.setClientName("auto");
		client.setAddress("mumbai");
		client.updateAddress(client.getClientName());
		TestUtils.assertEquals(alertMessage, prop.getProperty("clientUpdated"));
	}
	
	@Test(groups = "functional")
	public void TC_deleteClient() {
		String alertMessage = client.addAddress();
		TestUtils.assertEquals(alertMessage, prop.getProperty("clientDeleted"));
	}
	
	

}
