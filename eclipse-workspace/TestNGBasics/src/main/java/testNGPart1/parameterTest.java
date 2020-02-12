package testNGPart1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class parameterTest {
	WebDriver driver;

	@Test
	@Parameters({ "env", "browser", "url1", "url2" })
	public void parmTest1(String env, String browser, String url1, String url2) throws InterruptedException {
		if (env.equals("QA")) {
			if (browser.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(url1);

				Thread.sleep(5000);
				driver.close();

			}

		}
	}

	@Test
	@Parameters({ "env", "browser", "url1", "url2" })
	public void parmTest2(String env, String browser, String url1, String url2) throws InterruptedException {
		if (env.equals("QA")) {
			if (browser.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", "C://Program Files/chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(url2);
				Thread.sleep(5000);
				driver.close();

			}

		}
	}
}
