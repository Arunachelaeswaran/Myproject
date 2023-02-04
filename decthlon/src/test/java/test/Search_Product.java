package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadMyExcel;

public class Search_Product extends BaseTest  {

	@Test(dataProviderClass = ReadMyExcel.class, dataProvider  = "product")
	public static void producttest(String testdata) throws InterruptedException {
		// Maximize the window
		driver.manage().window().maximize();

		// implicit timeout
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// close the display message
		driver.findElement(By.xpath(loc.getProperty("close"))).click();

		// search
		driver.findElement(By.id(loc.getProperty("search"))).sendKeys(testdata+ Keys.ENTER);
		
		Thread.sleep(3000);
		

	}
	

}
