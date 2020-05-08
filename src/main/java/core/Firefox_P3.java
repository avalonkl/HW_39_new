package core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Firefox_P3 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		Logger.getLogger("").setLevel(Level.OFF); // Suppress Warnings

		System.out.println("Browser: Firefox");

		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver.sh");
		driver = new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		final long start = System.currentTimeMillis();
		
		driver.get("http://facebook.com");
		driver.manage().window().maximize();

		System.out.println("Title: " + driver.getTitle());

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("avalonkl@gmail.com");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys(System.getenv("fb_password"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@value,'Log In')]"))).click();
		
		//Thread.sleep(1000);
		//System.out.println("Title: " + driver.getTitle());
		wait.until(ExpectedConditions.titleContains(") Facebook"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'_1vp5')]"))).click();
		
		String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='_gs6']"))).getText();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userNavigationLabel"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Выйти"))).click();

		final long finish = System.currentTimeMillis();
		driver.quit();
		System.out.println("You have " + friends + " friends");
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");
	}
}
