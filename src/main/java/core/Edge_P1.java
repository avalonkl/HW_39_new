package core;
 
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class Edge_P1 {
 
        static WebDriver driver;
 
        public static void main(String[] args) throws InterruptedException {
              
               Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
               
               System.out.println("Browser: Edge");
              
               System.setProperty("webdriver.edge.driver", "/usr/local/bin/msedgedriver.sh");
 
               driver = new EdgeDriver();
               
               driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
               WebDriverWait wait = new WebDriverWait(driver, 15);
 
               driver.get("http://facebook.com");
               driver.manage().window().maximize();
               
               System.out.println("Title: " + driver.getTitle());
               
               driver.findElement(By.id("email")).sendKeys("avalonkl@gmail.com");
               driver.findElement(By.id("pass")).sendKeys(System.getenv("fb_password"));
               driver.findElement(By.xpath("//*[contains(@value,'Log In')]")).click();

               driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
               wait.until(ExpectedConditions.titleContains(") Facebook"));
       		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'_1vp5')]"))).click();
       		   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       		   
               String friends = driver.findElement(By.xpath("//span[@class='_gs6']")).getText(); 
               
               driver.findElement(By.id("userNavigationLabel")).click();
               driver.findElement(By.linkText("Выйти")).click();
               
               driver.quit();
               
               System.out.println("You have " + friends + " friends");
        }
}
