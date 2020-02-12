package testNGPart1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.getDatafromExcel;

public class dataProviderTest {
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.get("https://www.astroyogi.com/kundli");
		Thread.sleep(3000);

	}

	
	
	@DataProvider
	public Iterator<Object[]> fetchData(ArrayList<Object[]> getData) {
		Iterator<Object[]> myData = getDatafromExcel.getData().iterator();
		return myData;
		
	}
	
	@Test(dataProvider = "fetchData")
	public void dataEnterTest(String Name, String Year, String Month, String Date, String Time, String Place) throws InterruptedException {

		WebElement name = driver.findElement(By.cssSelector("input#Kund_Name"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",name);
		Thread.sleep(2000);
		
		name.sendKeys(Name );

		Select select1 = new Select(driver.findElement(By.cssSelector("select#UserGender")));
		select1.selectByIndex(0);
		
		Thread.sleep(1000);

		//String dob = "15/08/1985";
		driver.findElement(By.name("Kund_Dateofbirth")).click();
		Thread.sleep(5000);
		
		Select year = new Select(driver.findElement(By.xpath("//select[@class = 'ui-datepicker-year']")));
		year.selectByVisibleText(Year);
		Thread.sleep(2000);
		
		Select month = new Select(driver.findElement(By.className("ui-datepicker-month")));
		month.selectByVisibleText(Month);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(), '15')]")).click();
		
		driver.findElement(By.name("Kund_BirthTime")).submit();
		driver.findElement(By.name("Kund_BirthTime")).clear();
		
		driver.findElement(By.name("Kund_BirthTime")).sendKeys(Time);
		driver.findElement(By.xpath("//label[contains(text(),'Birth Date')]")).click();
		
		driver.findElement(By.cssSelector("input#Kund_BirthPlace")).submit();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("input#Kund_BirthPlace"))).click().
		sendKeys(Place).build().perform();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> element = driver.findElements(By.cssSelector("ul#ui-id-1"));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		
		for (WebElement elem : element) {
			if (elem.getText().contains("Faizabad,Uttar Pradesh,IN")) {
				elem.click();
			}

		}

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
