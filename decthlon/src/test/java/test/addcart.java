package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import base.BaseTest;

public class addcart extends BaseTest {

	@Test(priority = 1, description = "Login Test")
	public void addcart() throws InterruptedException, IOException {

		// Maximize the window
		driver.manage().window().maximize();

		// implicit timeout
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// close the display message
		driver.findElement(By.xpath(loc.getProperty("close"))).click();
		
		//screenshot
		TakesScreenshot ss1 = (TakesScreenshot)driver;
		File scrs1 = ss1.getScreenshotAs(OutputType.FILE);
		File scrs_dest1 = new File("./src\\test\\resources\\Snaps/img1.png");
		FileHandler.copy(scrs1, scrs_dest1);

		// search
		driver.findElement(By.id(loc.getProperty("search"))).sendKeys("shoes" + Keys.ENTER);

		// move to the product and clicked
		WebElement shoe = driver.findElement(By.xpath(loc.getProperty("prd_shoe")));
		Actions ac = new Actions(driver);
		ac.moveToElement(shoe).perform();
		ac.click(shoe).perform();

		// click the shoe color
		driver.findElement(By.xpath(loc.getProperty("shoe_clr"))).click();

		// click the size
		driver.findElement(By.xpath(loc.getProperty("shoe_size"))).click();

		// addtocart
		driver.findElement(By.xpath(loc.getProperty("addcart_btn"))).click();

		Thread.sleep(5000);

		// click the goto cart button
		driver.findElement(By.xpath(loc.getProperty("gotocart_btn"))).click();

		// proceed to payment
		driver.findElement(By.xpath(loc.getProperty("proceed_chck"))).click();

		// close the payment dialogbox
		driver.findElement(By.xpath(loc.getProperty("close"))).click();

		// click the decthlon logo to go HomePage
		driver.findElement(By.xpath(loc.getProperty("logo"))).click();

		// click the accessories epic
		WebElement access = driver.findElement(By.xpath(loc.getProperty("access_cmpt")));
		access.click();

		Set<String> windowhandles = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(windowhandles);

		// move to the Accessories window
		driver.switchTo().window(list.get(1));

		//Move to the bags & backpacks component
		WebElement product = driver.findElement(By.xpath(loc.getProperty("mov_to_bags_cmpt")));
		ac.moveToElement(product).perform();
		ac.click(product).perform();

		// click the bag & backpacks
		driver.findElement(By.xpath(loc.getProperty("clck_bags_cmpt"))).click();

		// move to the bag product and click
		WebElement productbag = driver.findElement(By.xpath(loc.getProperty("mov_to_bag_prd")));
		ac.moveToElement(productbag).perform();
		ac.click(productbag).perform();

		// addtocart
		driver.findElement(By.xpath(loc.getProperty("addcart_btn"))).click();

		Thread.sleep(5000);

		// click the goto cart button
		driver.findElement(By.xpath(loc.getProperty("gotocart_btn"))).click();
		
		//screenshot
		TakesScreenshot ss2 = (TakesScreenshot)driver;
		File scrs2 = ss2.getScreenshotAs(OutputType.FILE);
		File scrs_dest2 = new File("./src\\test\\resources\\Snaps/img2.png");
		FileHandler.copy(scrs2, scrs_dest2);

		// proceed to payment
		driver.findElement(By.xpath(loc.getProperty("proceed_chck"))).click();

		// close the payment dialogbox
		driver.findElement(By.xpath(loc.getProperty("close"))).click();

	}

}
