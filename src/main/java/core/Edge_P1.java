package core;
 
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
 
public class Edge_P1 {
 
        static WebDriver driver;
 
        public static void main(String[] args) throws InterruptedException {
              
               Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
               
               System.out.println("Browser: Edge");
              
               System.setProperty("webdriver.edge.driver", "/usr/local/bin/msedgedriver");
 
               driver = new EdgeDriver();
 
               driver.get("http://facebook.com");
               driver.manage().window().maximize();
               System.out.println("Title: " + driver.getTitle());
               driver.findElement(By.id("email")).sendKeys("avalonkl@gmail.com");
               Thread.sleep(1000);
               driver.findElement(By.id("pass")).sendKeys(System.getenv("fb_password"));
               Thread.sleep(1000);
               String[] loginId = {"u_0_b", "u_0_4", "u_0_2"};
               int i =0;
               while (driver.findElements(By.id(loginId[i])).isEmpty() && i < loginId.length) i++;
               driver.findElement(By.id(loginId[i])).click();
               Thread.sleep(5000);
               driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).click(); //*[@id="u_0_a"]/div[1]/div[1]/div/a/span/span
               Thread.sleep(5000);
               String[] friendsXpath = { "//*[@id=\"u_0_14\"]/li[3]/a/span[1]",
       				"//*[@id=\"u_fetchstream_1_a\"]/li[3]/a/span[1]", "//*[@id=\"u_fetchstream_2_a\"]/li[3]/a/span[1]",
       				"//*[@id=\"u_fetchstream_3_a\"]/li[3]/a/span[1]", "//*[@id=\"u_jsonp_3_9\"]/li[3]/a/span[1]",
       				"//*[@id=\"u_jsonp_4_9\"]/li[3]/a/span[1]",
       				"/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/div/div[2]/div[3]/ul/li[3]/a/span[1]"};       
               int j = 0;
               while (driver.findElements(By.xpath(friendsXpath[j])).isEmpty() && j < friendsXpath.length) j++;
               String friends = driver.findElement(By.xpath(friendsXpath[j])).getText();
               Thread.sleep(3000);   
               driver.findElement(By.id("userNavigationLabel")).click();
               Thread.sleep(2000);
               driver.findElement(By.linkText("Выйти")).click();
               driver.quit();
               System.out.println("You have " + friends + " friends");
        }
}
