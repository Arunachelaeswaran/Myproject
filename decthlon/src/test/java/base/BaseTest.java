package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;

	public static FileReader f;
	public static Properties config = new Properties();

	public static FileReader f1;
	public static Properties loc = new Properties();

	@BeforeTest(description = "Launch Browser")
	public static void setup() throws IOException {

		if (driver == null) {
			f = new FileReader(
					System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			config.load(f);

			f1 = new FileReader(
					System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			loc.load(f1);

		}
		if (config.getProperty("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(config.getProperty("testurl"));

		} else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(config.getProperty("testurl"));
		}

	}

	@AfterTest(description = "Close Browser")
	public static void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		System.out.println("TearDown Successfully");
	}

}
