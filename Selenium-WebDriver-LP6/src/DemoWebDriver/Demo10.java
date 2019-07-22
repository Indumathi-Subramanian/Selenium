package DemoWebDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo10 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IndumathiSubramanian\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://realestate.upskills.in/wp-admin/");
		driver.findElement(By.name("log")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("adminuser@12345");
		Actions act1 = new Actions(driver);
		//act1.sendKeys(Keys.RETURN).perform();
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		String Expected=driver.getCurrentUrl();
		WebElement link=driver.findElement(By.xpath("//*[text()='Howdy, ']"));  //finds exact text
		//WebElement link=driver.findElement(By.xpath(//*[contains(text(),'Howdy')])); // finds partial text also
		//act1.moveToElement(link).click().perform();
		act1.contextClick(link).build().perform();//for right click
		Robot robot = new Robot();// to perform right click operation of window app
		robot.keyPress(KeyEvent.VK_DOWN); // to go down
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		String Actual = driver.getCurrentUrl();
		//if(Actual!=null && Actual==Expected) {
		if(Actual.equals(Expected)) {
		System.out.println(Actual);
		}
		else {
			System.out.println(Expected);
			System.out.println(Actual);
		}
		

	}

}
